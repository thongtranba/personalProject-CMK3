package controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.OrderDAO;
import dao.OrderItemDAO;
import dao.ProductDAO;
import model.Order;
import model.OrderItem;
import model.Product;

/**
 * Servlet implementation class MyPurchase
 */
@WebServlet("/myPurchase")
public class MyPurchaseServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	ProductDAO productDAO = new ProductDAO();
	OrderItemDAO orderItemDAO = new OrderItemDAO();
	OrderDAO orderDAO = new OrderDAO();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public MyPurchaseServlet() {
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
			if (command != null && command.equals("MY_ORDER")) {
				int customerId = Integer.parseInt(request.getParameter("id"));
				List<Order> orderList = orderDAO.selectAllOrderByCustomerId(customerId);
				request.setAttribute("orderList", orderList);
				
				RequestDispatcher dispatcher = request.getRequestDispatcher("myPurchase.jsp");
				dispatcher.forward(request, response);

			} else if (command != null && command.equals("MY_ORDER_DETAILS")) {
				
				int id = Integer.parseInt(request.getParameter("orderId"));
				List<Product> products = productDAO.selectAllProductByOrderId(id);
				request.setAttribute("orderId", id);
				request.setAttribute("productList", products);
				RequestDispatcher dispatcher = request.getRequestDispatcher("myOrderDetail.jsp");
				dispatcher.forward(request, response);

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
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
