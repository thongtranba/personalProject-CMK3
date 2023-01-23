package bathongshop.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bathongshop.DAO.ProductDAO;
import bathongshop.entity.Product;

/**
 * Servlet implementation class categoryServlet
 */
@WebServlet("/category")
public class CategoryController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ProductDAO productDAO = new ProductDAO();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CategoryController() {
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
		switch (command) {
		case "CATEGORY":
			category(request, response);
			break;
		case "SALEOFF":
			saleOff(request, response);
			break;
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

	public void category(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			String categoryPage = request.getParameter("category");
			int pageId = Integer.parseInt(request.getParameter("pageId"));
			HttpSession session = request.getSession();
			session.setAttribute("categoryPage", categoryPage);
			int categoryId = 0;
			switch (categoryPage) {
			case "rackets":
				categoryId = 1;
				break;
			case "bags":
				categoryId = 2;
				break;
			case "clothing":
				categoryId = 3;
				break;
			case "shoes":
				categoryId = 4;
				break;
			case "strings":
				categoryId = 5;
				break;
			}
			int itemPerPage = 9;
			int totalProducts = productDAO.totalCategoryProduct(categoryId);
			int startItem = (pageId - 1) * itemPerPage;
			int totalPage = (int) Math.ceil(totalProducts * 1.0 / itemPerPage);
			List<Product> categoryList = productDAO.selectAllProductByCategoryId(categoryId, startItem, itemPerPage);
			request.setAttribute("categoryList", categoryList);
			request.setAttribute("totalPage", totalPage);
			request.setAttribute("currentPage", pageId);
			RequestDispatcher dispatcher = request.getRequestDispatcher("category.jsp");
			dispatcher.forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void saleOff(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			List<Product> saleOffProduct = productDAO.selectSaleOffProduct();
			request.setAttribute("saleOffProduct", saleOffProduct);
			RequestDispatcher dispatcher = request.getRequestDispatcher("saleOffProduct.jsp");
			dispatcher.forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
