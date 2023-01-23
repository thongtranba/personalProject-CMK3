package bathongshop.controller;

import java.io.IOException;
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

import bathongshop.DAO.OrderDAO;
import bathongshop.DAO.OrderItemDAO;
import bathongshop.DAO.ProductDAO;
import bathongshop.entity.Order;
import bathongshop.entity.OrderItem;
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
			submitCart(request, response);
			break;
		case "MY_ORDER":
			myOrder(request, response);
			break;
		case "MY_ORDER_DETAILS":
			myOrderDetails(request, response);
			break;

		}

////			} else if (command != null && command.equals("VIEW_CART")) {
////				response.sendRedirect("HomeServlet");

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

	private void submitCart(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			HttpSession session = request.getSession();
			Map<Integer, ProductModel> cart = (Map<Integer, ProductModel>) session.getAttribute("cart");
			int customerId = (int) session.getAttribute("customerId");
			order = new Order(customerId);
			int orderId = orderDAO.addOrder(order);

			for (int key : cart.keySet()) {
				OrderItem orderItem = new OrderItem(key, orderId);
				orderItemDAO.addOrderItem(orderItem);

			}
			session.removeAttribute("cart");
			response.sendRedirect("payment.jsp");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void myOrder(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			int customerId = Integer.parseInt(request.getParameter("id"));
			List<Order> orderList = orderDAO.selectAllOrderByCustomerId(customerId);
			request.setAttribute("orderList", orderList);

			RequestDispatcher dispatcher = request.getRequestDispatcher("myPurchase.jsp");
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
			RequestDispatcher dispatcher = request.getRequestDispatcher("myOrderDetail.jsp");
			dispatcher.forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
