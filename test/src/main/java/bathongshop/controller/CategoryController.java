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
import bathongshop.constant.PublicConstant;
import bathongshop.entity.Brand;
import bathongshop.entity.Product;

@WebServlet(PublicConstant.CATEGORY_URL)
public class CategoryController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ProductDAO productDAO = new ProductDAO();
	private BrandDAO brandDAO = new BrandDAO();

	public CategoryController() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String command = request.getParameter(PublicConstant.COMMAND);
		switch (command) {
		case PublicConstant.CATEGORY_COMMAND:
			category(request, response);
			break;
		case PublicConstant.SALEOFF_COMMAND:
			saleOff(request, response);
			break;
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

	public void category(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			String categoryPage = request.getParameter(PublicConstant.CATEGORY_PARAMETER);
			int pageId = Integer.parseInt(request.getParameter(PublicConstant.PAGEID_PARAMETER));
			String sort = request.getParameter(PublicConstant.SORT_PARAMETER) != null
					? request.getParameter(PublicConstant.SORT_PARAMETER)
					: PublicConstant.DEFAULT_COMMAND;
			int brandId = request.getParameter(PublicConstant.BRAND_ID) != null
					? Integer.parseInt(request.getParameter(PublicConstant.BRAND_ID))
					: Integer.parseInt(PublicConstant.CATEGORYID_DEFAULT);

			int categoryId = Integer.parseInt(PublicConstant.CATEGORYID_DEFAULT);
			switch (categoryPage) {
			case PublicConstant.RACKETS_PAGE_COMMAND:
				categoryId = Integer.parseInt(PublicConstant.RACKETS_CATEGORYID);
				break;
			case PublicConstant.BAGS_PAGE_COMMAND:
				categoryId = Integer.parseInt(PublicConstant.BAGS_CATEGORYID);
				break;
			case PublicConstant.CLOTHING_PAGE_COMMAND:
				categoryId = Integer.parseInt(PublicConstant.CLOTHING_CATEGORYID);
				break;
			case PublicConstant.SHOES_PAGE_COMMAND:
				categoryId = Integer.parseInt(PublicConstant.SHOES_CATEGORYID);
				break;
			case PublicConstant.STRING_PAGE_COMMAND:
				categoryId = Integer.parseInt(PublicConstant.STRING_CATEGORYID);
				break;
			}
			String[] sortSelect = { PublicConstant.DEFAULT_COMMAND, PublicConstant.PRICE_ASC_COMMAND,
					PublicConstant.PRICE_DESC_COMMAND, PublicConstant.AZ_COMMAND, PublicConstant.ZA_COMMAND };
			String sortColumn = PublicConstant.EMPTY_STRING;
			String sortType = PublicConstant.EMPTY_STRING;
			switch (sort) {
			case PublicConstant.DEFAULT_COMMAND:
				sortColumn = PublicConstant.ID;
				sortType = PublicConstant.ASC;
				break;
			case PublicConstant.PRICE_ASC_COMMAND:
				sortColumn = PublicConstant.PRICE_COLUMN;
				sortType = PublicConstant.ASC;
				break;
			case PublicConstant.PRICE_DESC_COMMAND:
				sortColumn = PublicConstant.PRICE_COLUMN;
				sortType = PublicConstant.DESC;
				break;
			case PublicConstant.AZ_COMMAND:
				sortColumn = PublicConstant.NAME_COLUMN;
				sortType = PublicConstant.ASC;
				break;
			case PublicConstant.ZA_COMMAND:
				sortColumn = PublicConstant.NAME_COLUMN;
				sortType = PublicConstant.DESC;
				break;
			}
			int itemPerPage = Integer.parseInt(PublicConstant.ITEM_PER_PAGE);
			int totalProducts = productDAO.totalCategoryProduct(categoryId);
			int startItem = (pageId - Integer.parseInt(PublicConstant.CONSTANT_1)) * itemPerPage;
			int totalPage = (int) Math
					.ceil(totalProducts * Double.parseDouble(PublicConstant.CONSTANT_DOUBLE_1) / itemPerPage);
			List<Brand> brandList = brandDAO.selectAllBrands();
			List<Product> categoryList = productDAO.selectAllProductByCategoryId(categoryId, startItem, itemPerPage,
					sortColumn, sortType, brandId);
			HttpSession session = request.getSession();
			session.setAttribute(PublicConstant.CATEGORY_PAGE, categoryPage);
			request.setAttribute(PublicConstant.BRAND_LIST, brandList);
			request.setAttribute(PublicConstant.BRAND_ID, brandId);
			request.setAttribute(PublicConstant.SORT_SELECT, sortSelect);
			session.setAttribute(PublicConstant.SORT_SELECTED, sort);
			request.setAttribute(PublicConstant.CATEGORY_LIST, categoryList);
			request.setAttribute(PublicConstant.TOTAL_PAGE, totalPage);
			request.setAttribute(PublicConstant.CURRENT_PAGE, pageId);
			RequestDispatcher dispatcher = request.getRequestDispatcher(PublicConstant.CATEGORY_JSP);
			dispatcher.forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void saleOff(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			List<Product> saleOffProduct = productDAO.selectSaleOffProduct();
			request.setAttribute(PublicConstant.SALE_OFF_PRODUCT, saleOffProduct);
			RequestDispatcher dispatcher = request.getRequestDispatcher(PublicConstant.SALEOFF_JSP);
			dispatcher.forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
