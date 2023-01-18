package bathongshop.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletInputStream;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.WebConnection;

import bathongshop.DAO.ProductDAO;
import bathongshop.entity.Product;

/**
 * Servlet implementation class Home
 */
@WebServlet(urlPatterns = {"/HomeServlet"})

public class HomeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ProductDAO productDAO = new ProductDAO();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public HomeServlet() {
		super();
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		List<Product> products = productDAO.selectAllProducts();
		System.out.println("products:: " + products.size());
		
		List<Product> popularProduct = productDAO.selectPopularProducts();
		List<Product> lastestProduct = productDAO.selectLatestProducts();
		List<Product> service = productDAO.selectService();
		
		
		request.setAttribute("popularProduct", popularProduct);
		request.setAttribute("lastestProduct", lastestProduct);
		request.setAttribute("service", service);
		RequestDispatcher dispatcher = request.getRequestDispatcher("home.jsp");
		dispatcher.forward(request, response);

		

	}	
}
