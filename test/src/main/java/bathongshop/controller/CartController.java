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

import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import bathongshop.DAO.OrderDAO;
import bathongshop.DAO.OrderItemDAO;
import bathongshop.DAO.ProductDAO;
import bathongshop.entity.Order;
import bathongshop.entity.OrderItem;
import bathongshop.model.OrderedModel;
import bathongshop.model.ProductModel;

/**
 * Servlet implementation class addToCartServlet
 */
@WebServlet("/cart")
public class CartController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ProductDAO productDAO = new ProductDAO();
	private OrderDAO orderDAO = new OrderDAO();
	private OrderItemDAO orderItemDAO = new OrderItemDAO();
	private Order order = new Order();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CartController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String command = request.getParameter("command");

		int productId = 0;
		switch (command) {
		case "ADD_TO_CART":
			productId = Integer.parseInt(request.getParameter("productId"));
			addToCart(request, response, productId);
			break;
		case "REMOVE":
			productId = Integer.parseInt(request.getParameter("productId"));
			removeCart(request, response, productId);
			break;
		case "SUBMIT_CART":
			String JSONString = request.getParameter("JSONString");
			submitCart(request, response, JSONString);
			break;
		case "MY_ORDER":
			myOrder(request, response);
			break;
		case "MY_ORDER_DETAILS":
			myOrderDetails(request, response);
			break;

		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

	private void addToCart(HttpServletRequest request, HttpServletResponse response, int productId)
			throws ServletException, IOException {
		try {
			ProductModel product = productDAO.selectProduct(productId);
			HttpSession session = request.getSession();
			Map<Integer, ProductModel> cart = (Map<Integer, ProductModel>) session.getAttribute("cart");
			if (cart == null) {
				cart = new HashMap<Integer, ProductModel>();
			}
			String notification = "you added to cart! check your cart.";
			cart.put(product.getId(), product);
			session.setAttribute("cart", cart);
			request.setAttribute("product", product);
			request.setAttribute("notification", notification);
			RequestDispatcher dispatcher = request.getRequestDispatcher("product?id=" + productId);
			dispatcher.forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void removeCart(HttpServletRequest request, HttpServletResponse response, int productId)
			throws ServletException, IOException {
		try {
			HttpSession session = request.getSession();
			Map<Integer, ProductModel> cart = (Map<Integer, ProductModel>) session.getAttribute("cart");
			cart.remove(productId);
			response.sendRedirect("home");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void submitCart(HttpServletRequest request, HttpServletResponse response, String JSONString)
			throws ServletException, IOException {
		System.out.println(JSONString);

		try {
			List<OrderedModel> orderProducts = jsonData(JSONString);
			Map<Integer, Integer> orderList = new HashMap<Integer, Integer>();

			for (OrderedModel orderedModel : orderProducts) {
				orderList.put(orderedModel.getProductId(), orderedModel.getQuantity());
			}

			HttpSession session = request.getSession();
			int customerId = (int) session.getAttribute("customerId");
			order = new Order(customerId);
			int orderId = orderDAO.addOrder(order);
			for (int key : orderList.keySet()) {
				OrderItem orderItem = new OrderItem(key, orderList.get(key), orderId);
				orderItemDAO.addOrderItem(orderItem);
				int inventoryQuantity = productDAO.takeInventoryQuantity(key);
				int newQuantity = inventoryQuantity - orderList.get(key);
				productDAO.updateQuantityByProductId(key, newQuantity);
			}

			session.removeAttribute("cart");
			request.setAttribute("orderId", orderId);
			RequestDispatcher dispatcher = request.getRequestDispatcher("payment.jsp");
			dispatcher.forward(request, response);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public List<OrderedModel> jsonData(String JSONString) throws JsonProcessingException {
		try {
			ObjectMapper mapper = new ObjectMapper();
			mapper.setSerializationInclusion(Include.NON_NULL);
			List<OrderedModel> list = Arrays.asList(mapper.readValue(JSONString, OrderedModel[].class));
			return list;
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (NullPointerException e) {
			e.printStackTrace();
		}
		return null;
	}

	private void myOrder(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			int customerId = Integer.parseInt(request.getParameter("id"));
			List<Order> orderList = orderDAO.selectAllOrderByCustomerId(customerId);
			request.setAttribute("orderList", orderList);
			RequestDispatcher dispatcher = request.getRequestDispatcher("my-purchase.jsp");
			dispatcher.forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void myOrderDetails(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			int id = Integer.parseInt(request.getParameter("orderId"));
			List<ProductModel> products = productDAO.selectAllProductByOrderId(id);
			request.setAttribute("orderId", id);
			request.setAttribute("productList", products);
			RequestDispatcher dispatcher = request.getRequestDispatcher("my-order-detail.jsp");
			dispatcher.forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}