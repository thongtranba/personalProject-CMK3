package controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ProductDAO;
import model.Product;

/**
 * Servlet implementation class HomeServlet
 */
@WebServlet("/")
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

		String action = request.getServletPath();
		
		switch (action) {
		
		case "/rackets":
			try {
				showRackets(request, response);
			} catch (SQLException e) {
				e.printStackTrace();
			}

			break;
		case "/bags":
			try {
				showBags(request, response);
			} catch (SQLException e) {
				e.printStackTrace();
			}

			break;
		case "/clothing":
			try {
				showClothing(request, response);
			} catch (SQLException e) {
				e.printStackTrace();
			}

			break;
		case "/shoes":
			try {
				showShoes(request, response);
			} catch (SQLException e) {
				e.printStackTrace();
			}

			break;
		case "/strings":
			try {
				showStrings(request, response);
			} catch (SQLException e) {
				e.printStackTrace();
			}

			break;
		case "/productDetail":
			try {
				showProductDetail(request, response);
				
			} catch (SQLException e) {
				e.printStackTrace();
			}

			break;

		default:
			try {
				listProduct(request, response);
			} catch (SQLException e) {
				e.printStackTrace();
			}

			break;
		}
		

	}

	private void showProductDetail(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, ServletException, IOException {
	
		int id = Integer.parseInt(request.getParameter("id"));
		Product existingProduct = productDAO.selectProduct(id);
		RequestDispatcher dispatcher = request.getRequestDispatcher("productDetail.jsp");
		request.setAttribute("product", existingProduct);
		dispatcher.forward(request, response);
		

	}	

	private void listProduct(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
		List<Product> listProduct = productDAO.selectAllProducts();
		request.setAttribute("listProduct", listProduct);
		RequestDispatcher dispatcher = request.getRequestDispatcher("home.jsp");
		dispatcher.forward(request, response);
	}
	private void showRackets(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
		int categoryId = Integer.parseInt(request.getParameter("categoryId"));
		List<Product> listRacket = productDAO.selectAllProductByCategoryId(categoryId);
		request.setAttribute("listRacket", listRacket);
		RequestDispatcher dispatcher = request.getRequestDispatcher("rackets.jsp");
		dispatcher.forward(request, response);
	}
	private void showBags(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
		int categoryId = Integer.parseInt(request.getParameter("categoryId"));
		List<Product> listBags = productDAO.selectAllProductByCategoryId(categoryId);
		request.setAttribute("listBags", listBags);
		RequestDispatcher dispatcher = request.getRequestDispatcher("bags.jsp");
		dispatcher.forward(request, response);
	}
	private void showClothing(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
		int categoryId = Integer.parseInt(request.getParameter("categoryId"));
		List<Product> listCloth = productDAO.selectAllProductByCategoryId(categoryId);
		request.setAttribute("listCloth", listCloth);
		RequestDispatcher dispatcher = request.getRequestDispatcher("clothing.jsp");
		dispatcher.forward(request, response);
	}
	private void showShoes(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
		int categoryId = Integer.parseInt(request.getParameter("categoryId"));
		List<Product> listShoes = productDAO.selectAllProductByCategoryId(categoryId);
		request.setAttribute("listShoes", listShoes);
		RequestDispatcher dispatcher = request.getRequestDispatcher("shoes.jsp");
		dispatcher.forward(request, response);
	}
	private void showStrings(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
		int categoryId = Integer.parseInt(request.getParameter("categoryId"));
		List<Product> listStrings = productDAO.selectAllProductByCategoryId(categoryId);
		request.setAttribute("listStrings", listStrings);
		RequestDispatcher dispatcher = request.getRequestDispatcher("strings.jsp");
		dispatcher.forward(request, response);
	}
	
}
