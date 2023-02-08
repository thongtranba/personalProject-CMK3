package bathongshop.controller;

import java.io.IOException;
import java.net.http.HttpClient.Redirect;
import java.sql.SQLException;

import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.paypal.api.payments.PayerInfo;
import com.paypal.api.payments.Payment;
import com.paypal.api.payments.ShippingAddress;
import com.paypal.api.payments.Transaction;
import com.paypal.base.rest.PayPalRESTException;

import bathongshop.constant.ConstantDoubleEnum;
import bathongshop.constant.ConstantIntegerEnum;
import bathongshop.constant.PublicConstant;
import bathongshop.dao.OrderDAO;
import bathongshop.dao.OrderItemDAO;
import bathongshop.dao.ProductDAO;
import bathongshop.entity.Order;
import bathongshop.entity.OrderItem;
import bathongshop.model.CheckOutDetail;
import bathongshop.model.OrderedModel;
import bathongshop.model.ProductModel;
import bathongshop.payment.PaymentService;

@WebServlet(PublicConstant.PAYMENT_URL)
public class PaymentController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ProductDAO productDAO = ProductDAO.getProductDAO();
	private OrderItemDAO orderItemDAO = OrderItemDAO.getOrderItemDAO();
	private OrderDAO orderDAO = OrderDAO.getOrderDAO();
	private static Logger logger = LogManager.getLogger(PaymentController.class);

	public PaymentController() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String command = request.getParameter(PublicConstant.COMMAND);
		switch (command) {
		case PublicConstant.PAY_COMMAND:
			payment(request, response);
			break;
		case PublicConstant.REVIEW_PAYMENT_COMMAND:
			reviewPayment(request, response);
			break;
		case PublicConstant.EXECUTE_PAMENT_COMMAND:
			executePayment(request, response);
			break;
		case PublicConstant.CHECKOUT_COMMAND:
			checkoutOrder(request, response);
			break;
		}
	}

	protected void payment(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			String JSONString = request.getParameter(PublicConstant.JSON_STRING);
			logger.info(JSONString);
			List<OrderedModel> orderProducts = jsonData(JSONString);
			Map<Integer, Integer> orderList = new HashMap<Integer, Integer>();
			for (OrderedModel orderedModel : orderProducts) {
				orderList.put(orderedModel.getProductId(), orderedModel.getQuantity());
			}

			HttpSession session = request.getSession(false);
			int customerId = (int) session.getAttribute(PublicConstant.CUSTOMERID);
			Order order = Order.newOrderByCustomerId(customerId);
			int orderId = orderDAO.addOrder(order);
			session.setAttribute(PublicConstant.ORDER_ID, orderId);
			for (int key : orderList.keySet()) {
				OrderItem orderItem = new OrderItem(key, orderList.get(key), orderId);
				boolean orderStatus = orderItemDAO.addOrderItem(orderItem);
				if (orderStatus == true) {
					int inventoryQuantity = productDAO.takeInventoryQuantity(key);
					int newQuantity = inventoryQuantity - orderList.get(key);
					productDAO.updateQuantityByProductId(key, newQuantity);
				}
			}

			List<ProductModel> products = productDAO.selectAllProductByOrderId(orderId);
			double subtotal = calculateSubTotal(orderId);
			double shippingFee = ConstantDoubleEnum.CONSTANT_SHIPPINGFEE.getValue();
			double total = calculateSubTotal(orderId) + ConstantDoubleEnum.CONSTANT_SHIPPINGFEE.getValue();
			Date checkoutDate = new Date();

			CheckOutDetail checkoutDetail = new CheckOutDetail();
			checkoutDetail.setOrderList(products);
			checkoutDetail.setSubTotal(subtotal);
			checkoutDetail.setShippingFee(shippingFee);
			checkoutDetail.setTotal(total);
			checkoutDetail.setCheckOutDate(checkoutDate);
			String firstName = String.valueOf(session.getAttribute(PublicConstant.USERNAME));
			String email = String.valueOf(session.getAttribute(PublicConstant.EMAIL));

			PaymentService paymentServices = new PaymentService();
			String approvalLink = paymentServices.authorizePayment(checkoutDetail, firstName, email, products);
			response.sendRedirect(approvalLink);
		} catch (PayPalRESTException e) {
			logger.error(PublicConstant.THIS_IS_ERROR, e.getMessage());
		} catch (SQLException e) {
			logger.error(PublicConstant.THIS_IS_ERROR, e.getMessage());
		} catch (Exception e) {
			logger.error(PublicConstant.THIS_IS_ERROR, e.getMessage());
		}
	}

	public List<OrderedModel> jsonData(String JSONString) throws JsonProcessingException {
		try {
			ObjectMapper mapper = new ObjectMapper();
			mapper.setSerializationInclusion(Include.NON_NULL);
			List<OrderedModel> list = Arrays.asList(mapper.readValue(JSONString, OrderedModel[].class));
			return list;
		} catch (IllegalArgumentException e) {
			logger.error(PublicConstant.THIS_IS_ERROR, e.getMessage());
		} catch (NullPointerException e) {
			logger.error(PublicConstant.THIS_IS_ERROR, e.getMessage());
		}
		return null;
	}

	public double calculateSubTotal(int orderId) throws Exception {
		double subtotal = ConstantDoubleEnum.CONSTANT_0.getValue();
		try {
			List<ProductModel> products = productDAO.selectAllProductByOrderId(orderId);
			for (ProductModel product : products) {
				if (product.getDiscountPrice() != ConstantDoubleEnum.CONSTANT_0.getValue()) {
					subtotal = subtotal + (product.getDiscountPrice() * product.getInputQuantity());
				} else {
					subtotal = subtotal + (product.getPrice() * product.getInputQuantity());
				}
			}
		} catch (Exception e) {
			logger.error(PublicConstant.THIS_IS_ERROR, e.getMessage());
		}
		return subtotal;
	}

	protected void reviewPayment(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			String paymentId = request.getParameter(PublicConstant.PAYMENT_ID);
			String payerId = request.getParameter(PublicConstant.PAYER_ID);

			PaymentService paymentServices = new PaymentService();
			Payment payment = paymentServices.getPaymentDetails(paymentId);
			PayerInfo payerInfo = payment.getPayer().getPayerInfo();
			Transaction transaction = payment.getTransactions().get(0);
			ShippingAddress shippingAddress = transaction.getItemList().getShippingAddress();

			request.setAttribute(PublicConstant.PAYER, payerInfo);
			request.setAttribute(PublicConstant.TRANSACTION, transaction);
			request.setAttribute(PublicConstant.SHIPPING_ADDRESS, shippingAddress);
			RequestDispatcher dispatcher = request.getRequestDispatcher(
					PublicConstant.PAYEMENT_REVIEW_JSP + paymentId + PublicConstant.PAYERID_PARAMETER + payerId);
			dispatcher.forward(request, response);
		} catch (PayPalRESTException e) {
			logger.error(PublicConstant.THIS_IS_ERROR, e.getMessage());
		}
	}

	protected void executePayment(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {

			String paymentId = request.getParameter(PublicConstant.PAYMENT_ID);
			String payerId = request.getParameter(PublicConstant.PAYER_ID);
			HttpSession session = request.getSession();
			int orderId = (int) session.getAttribute(PublicConstant.ORDER_ID);
			PaymentService paymentServices = new PaymentService();
			Payment payment = paymentServices.executePayment(paymentId, payerId);
			PayerInfo payerInfo = payment.getPayer().getPayerInfo();
			Transaction transaction = payment.getTransactions().get(ConstantIntegerEnum.CONSTANT_0.getValue());
			orderDAO.updatePaymentStatusByOrderId(orderId);

			session.removeAttribute(PublicConstant.CART);
			session.removeAttribute(PublicConstant.ORDER_ID);
			request.setAttribute(PublicConstant.PAYER, payerInfo);
			request.setAttribute(PublicConstant.TRANSACTION, transaction);
			request.getRequestDispatcher(PublicConstant.PAYMENT_RECEIPT_JSP).forward(request, response);

		} catch (PayPalRESTException e) {
			logger.error(PublicConstant.THIS_IS_ERROR, e.getMessage());
		}
	}

	protected void checkoutOrder(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		try {
			response.sendRedirect(PublicConstant.CHECKOUT_ORDER_JSP);

		} catch (Exception e) {
			logger.error(PublicConstant.THIS_IS_ERROR, e.getMessage());
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
