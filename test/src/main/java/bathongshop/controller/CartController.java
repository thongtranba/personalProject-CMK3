package bathongshop.controller;

import java.io.IOException;
import java.util.Arrays;
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

import bathongshop.constant.ConstantVariableEnum;
import bathongshop.constant.NotificationEnum;
import bathongshop.constant.PublicConstant;
import bathongshop.dao.OrderDAO;
import bathongshop.dao.OrderItemDAO;
import bathongshop.dao.ProductDAO;
import bathongshop.entity.Order;
import bathongshop.entity.OrderItem;
import bathongshop.model.OrderedModel;
import bathongshop.model.ProductModel;

@WebServlet(PublicConstant.CART_URL)
public class CartController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ProductDAO productDAO = ProductDAO.getProductDAO();
	private OrderDAO orderDAO = OrderDAO.getOrderDAO();
	private OrderItemDAO orderItemDAO = OrderItemDAO.getOrderItemDAO();
	private static Logger logger = LogManager.getLogger(CartController.class);

	public CartController() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String command = request.getParameter(PublicConstant.COMMAND);
		int productId = ConstantVariableEnum.CONSTANT_0.getValue();
		switch (command) {
		case PublicConstant.ADD_TO_CART:
			productId = Integer.parseInt(request.getParameter(PublicConstant.PRODUCTID));
			addToCart(request, response, productId);
			break;
		case PublicConstant.REMOVE:
			productId = Integer.parseInt(request.getParameter(PublicConstant.PRODUCTID));
			removeCart(request, response, productId);
			break;
		case PublicConstant.SUBMIT_CART:
			String JSONString = request.getParameter(PublicConstant.JSON_STRING);
			submitCart(request, response, JSONString);
			break;
		case PublicConstant.MY_ORDER:
			myOrder(request, response);
			break;
		case PublicConstant.MY_ORDER_DETAILS:
			myOrderDetails(request, response);
			break;
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

	private void addToCart(HttpServletRequest request, HttpServletResponse response, int productId)
			throws ServletException, IOException {
		try {
			ProductModel product = productDAO.selectProduct(productId);
			HttpSession session = request.getSession();
			Map<Integer, ProductModel> cart = (Map<Integer, ProductModel>) session.getAttribute(PublicConstant.CART);
			if (cart == null) {
				cart = new HashMap<Integer, ProductModel>();
			}
			String notification = NotificationEnum.ADD_TO_CART_NOTIFICATION_MESSAGE.getValue();
			cart.put(product.getId(), product);
			session.setAttribute(PublicConstant.CART, cart);
			request.setAttribute(PublicConstant.PRODUCT, product);
			request.setAttribute(NotificationEnum.ADD_TO_CART_NOTIFICATION.getValue(), notification);
			RequestDispatcher dispatcher = request
					.getRequestDispatcher(PublicConstant.PRODUCT_DETAIL_PAGE_BY_ID + productId);
			dispatcher.forward(request, response);
		} catch (Exception e) {
			logger.error(PublicConstant.THIS_IS_ERROR, e.getMessage());
		}
	}

	private void removeCart(HttpServletRequest request, HttpServletResponse response, int productId)
			throws ServletException, IOException {
		try {
			HttpSession session = request.getSession();
			Map<Integer, ProductModel> cart = (Map<Integer, ProductModel>) session.getAttribute(PublicConstant.CART);
			cart.remove(productId);
			response.sendRedirect(PublicConstant.HOME_CONTROLLER);
		} catch (Exception e) {
			logger.error(PublicConstant.THIS_IS_ERROR, e.getMessage());
		}
	}

	private void submitCart(HttpServletRequest request, HttpServletResponse response, String JSONString)
			throws ServletException, IOException {
		logger.info(JSONString);
		try {
			List<OrderedModel> orderProducts = jsonData(JSONString);
			Map<Integer, Integer> orderList = new HashMap<Integer, Integer>();
			for (OrderedModel orderedModel : orderProducts) {
				orderList.put(orderedModel.getProductId(), orderedModel.getQuantity());
			}
			HttpSession session = request.getSession();
			int customerId = (int) session.getAttribute(PublicConstant.CUSTOMERID);
			Order order = Order.NewOrderByCustomerId(customerId);
			int orderId = orderDAO.addOrder(order);
			boolean flag = false;
			for (int key : orderList.keySet()) {
				OrderItem orderItem = new OrderItem(key, orderList.get(key), orderId);
				boolean orderStatus = orderItemDAO.addOrderItem(orderItem);
				logger.info(orderStatus);
				if (orderStatus == true) {
					int inventoryQuantity = productDAO.takeInventoryQuantity(key);
					int newQuantity = inventoryQuantity - orderList.get(key);
					productDAO.updateQuantityByProductId(key, newQuantity);
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
				RequestDispatcher dispatcher = request.getRequestDispatcher(PublicConstant.PAYMENT_JSP);
				dispatcher.forward(request, response);
			}
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

	private void myOrder(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			int customerId = Integer.parseInt(request.getParameter(PublicConstant.ID));
			List<Order> orderList = orderDAO.selectAllOrderByCustomerId(customerId);
			request.setAttribute(PublicConstant.ORDER_LIST, orderList);
			RequestDispatcher dispatcher = request.getRequestDispatcher(PublicConstant.MY_PURCHASE_JSP);
			dispatcher.forward(request, response);
		} catch (Exception e) {
			logger.error(PublicConstant.THIS_IS_ERROR, e.getMessage());
		}
	}

	private void myOrderDetails(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			int id = Integer.parseInt(request.getParameter(PublicConstant.ORDER_ID));
			List<ProductModel> products = productDAO.selectAllProductByOrderId(id);
			request.setAttribute(PublicConstant.ORDER_ID, id);
			request.setAttribute(PublicConstant.PRODUCT_LIST_ATTRIBUTE, products);
			RequestDispatcher dispatcher = request.getRequestDispatcher(PublicConstant.MY_ORDER_DETAIL_JSP);
			dispatcher.forward(request, response);
		} catch (Exception e) {
			logger.error(PublicConstant.THIS_IS_ERROR, e.getMessage());
		}
	}
}
