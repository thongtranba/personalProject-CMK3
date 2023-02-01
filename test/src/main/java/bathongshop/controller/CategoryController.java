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

import bathongshop.DAO.BrandDAO;
import bathongshop.DAO.ProductDAO;
import bathongshop.entity.Brand;
import bathongshop.entity.Product;

/**
 * Servlet implementation class categoryServlet
 */
@WebServlet("/category")
public class CategoryController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ProductDAO productDAO = new ProductDAO();
	private BrandDAO brandDAO = new BrandDAO();

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
		case "SORT":
			sortCategory(request, response);
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
			String sort = request.getParameter("sort") != null ? request.getParameter("sort") : "Default";
			int brandId = request.getParameter("brandId") != null
					? Integer.parseInt(request.getParameter("brandId"))
					: 0;
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
			String[] sortSelect = { "Default", "Price ASC", "Price DESC", "AZ", "ZA" };
			String sortColumn = "";
			String sortType = "";
			switch (sort) {
			case "Default":
				sortColumn = "id";
				sortType = " ASC";
				break;
			case "Price ASC":
				sortColumn = "price";
				sortType = " ASC";
				break;
			case "Price DESC":
				sortColumn = "price";
				sortType = " DESC";
				break;
			case "AZ":
				sortColumn = "name";
				sortType = " ASC";
				break;
			case "ZA":
				sortColumn = "name";
				sortType = " DESC";
				break;
			}
			int itemPerPage = 9;
			int totalProducts = productDAO.totalCategoryProduct(categoryId);
			int startItem = (pageId - 1) * itemPerPage;
			int totalPage = (int) Math.ceil(totalProducts * 1.0 / itemPerPage);
			List<Brand> brandList = brandDAO.selectAllBrands();
			List<Product> categoryList = productDAO.selectAllProductByCategoryId(categoryId, startItem, itemPerPage,
					sortColumn, sortType, brandId);
			
			request.setAttribute("brandList", brandList);
			request.setAttribute("brandId", brandId);
			request.setAttribute("sortSelect", sortSelect);
			session.setAttribute("sortSelected", sort);
			request.setAttribute("categoryPage", categoryPage);
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
			RequestDispatcher dispatcher = request.getRequestDispatcher("sale-off-product.jsp");
			dispatcher.forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void sortCategory(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
