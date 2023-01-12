package controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.OrderDAO;
import dao.OrderItemDAO;
import dao.ProductDAO;
import model.Order;
import model.OrderItem;
import model.Product;

/**
 * Servlet implementation class addToCartServlet
 */
@WebServlet("/addToCartServlet")
public class AddToCartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ProductDAO productDAO = new ProductDAO();
	private OrderDAO orderDAO = new OrderDAO();
	private OrderItemDAO orderItemDAO = new OrderItemDAO();
	private Order order = new Order();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AddToCartServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			String command = request.getParameter("command");
			int productId = 0;
			if (command != null && command.equals("ADD_TO_CART")) {
				productId = Integer.parseInt(request.getParameter("productId"));
				Product product = productDAO.selectProduct(productId);
				HttpSession session = request.getSession();
				Map<Integer, Product> cart = (Map<Integer, Product>) session.getAttribute("cart");
				if (cart == null) {
					cart = new HashMap<Integer, Product>();
				}
				cart.put(product.getId(), product);
				session.setAttribute("cart", cart);
				request.setAttribute("product", product);
				response.sendRedirect("productDetail?id=" + productId);

//			} else if (command != null && command.equals("VIEW_CART")) {
//				response.sendRedirect("HomeServlet");
			} else if (command != null && command.equals("REMOVE")) {
				productId = Integer.parseInt(request.getParameter("productId"));
				HttpSession session = request.getSession();
				Map<Integer, Product> cart = (Map<Integer, Product>) session.getAttribute("cart");
				cart.remove(productId);
				response.sendRedirect("HomeServlet");
			}else if(command !=null && command.equals("SUBMIT_CART")) {
				HttpSession session = request.getSession();
				Map<Integer, Product> cart = (Map<Integer,Product>) session.getAttribute("cart");
				int customerId = (int) session.getAttribute("customerId");
				order = new Order(customerId);
				int orderId = orderDAO.addOrder(order);
				
				for (int key : cart.keySet()) {
					OrderItem orderItem = new OrderItem(key, orderId);
					orderItemDAO.addOrderItem(orderItem);
					
				}	
				session.removeAttribute("cart");
				response.sendRedirect("HomeServlet");
			}

		} catch (Exception e) {
			e.printStackTrace();
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

}
