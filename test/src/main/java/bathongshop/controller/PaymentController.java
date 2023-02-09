package bathongshop.controller;

import java.io.IOException;

import java.sql.SQLException;
import java.util.ArrayList;
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
import bathongshop.constant.NotificationEnum;
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
			HttpSession session = request.getSession();
			session.setAttribute(PublicConstant.JSON_STRING, JSONString);
			logger.info(JSONString);

			List<OrderedModel> orderProducts = jsonData(JSONString);
			List<ProductModel> products = getProductListByOrderList(orderProducts);

			double subtotal = calculateSubTotal(products);
			double shippingFee = ConstantDoubleEnum.CONSTANT_SHIPPINGFEE.getValue();
			double total = subtotal + ConstantDoubleEnum.CONSTANT_SHIPPINGFEE.getValue();
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

	public List<ProductModel> getProductListByOrderList(List<OrderedModel> orderProducts)
			throws JsonProcessingException {
		try {
			List<ProductModel> list = new ArrayList<ProductModel>();
			for (OrderedModel orderedProduct : orderProducts) {
				ProductModel product = productDAO.selectProduct(orderedProduct.getProductId());
				product.setInputQuantity(orderedProduct.getQuantity());
				list.add(product);
			}
			return list;
		} catch (Exception e) {
			logger.error(PublicConstant.THIS_IS_ERROR, e.getMessage());
		}
		return null;
	}

	public double calculateSubTotal(List<ProductModel> products) throws Exception {
		double subtotal = ConstantDoubleEnum.CONSTANT_0.getValue();
		try {
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
			Transaction transaction = payment.getTransactions().get(ConstantIntegerEnum.CONSTANT_0.getValue());
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
			String JSONString = String.valueOf(session.getAttribute(PublicConstant.JSON_STRING));

			PaymentService paymentServices = new PaymentService();
			Payment payment = paymentServices.executePayment(paymentId, payerId);
			PayerInfo payerInfo = payment.getPayer().getPayerInfo();
			Transaction transaction = payment.getTransactions().get(ConstantIntegerEnum.CONSTANT_0.getValue());

			List<OrderedModel> orderProducts = jsonData(JSONString);
			Map<Integer, Integer> orderList = new HashMap<Integer, Integer>();
			for (OrderedModel orderedModel : orderProducts) {
				orderList.put(orderedModel.getProductId(), orderedModel.getQuantity());
			}

			int customerId = (int) session.getAttribute(PublicConstant.CUSTOMERID);
			Order order = Order.newOrderByCustomerId(customerId);
			int orderId = orderDAO.addOrder(order);
			boolean flag = false;
			for (int key : orderList.keySet()) {
				OrderItem orderItem = new OrderItem(key, orderList.get(key), orderId);
				boolean orderStatus = orderItemDAO.addOrderItem(orderItem);
				if (orderStatus == true) {
					int inventoryQuantity = productDAO.takeInventoryQuantity(key);
					int newQuantity = inventoryQuantity - orderList.get(key);
					productDAO.updateQuantityByProductId(key, newQuantity);
					orderDAO.updatePaymentStatusByOrderId(orderId);
				} else {
					flag = true;
				}
			}
			if (flag == true) {
				orderDAO.deleteOrderByOrderId(orderId);
				request.setAttribute(NotificationEnum.ORDER_FAIL_NOTIFICATION.getValue(),
						NotificationEnum.ORDER_FAIL_NOTIFICATION_MESSAGE.getValue());
				RequestDispatcher dispatcher = request.getRequestDispatcher(PublicConstant.NOTIFICATION_JSP);
				dispatcher.forward(request, response);
			} else {
				session.removeAttribute(PublicConstant.CART);
				session.removeAttribute(PublicConstant.JSON_STRING);
				request.setAttribute(PublicConstant.ORDER_ID, orderId);
				request.setAttribute(PublicConstant.PAYER, payerInfo);
				request.setAttribute(PublicConstant.TRANSACTION, transaction);
				request.getRequestDispatcher(PublicConstant.PAYMENT_RECEIPT_JSP).forward(request, response);
			}

		} catch (Exception e) {
			logger.error(PublicConstant.THIS_IS_ERROR, e.getMessage());
		}
	}

	protected void checkoutOrder(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.sendRedirect(PublicConstant.CHECKOUT_ORDER_JSP);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
