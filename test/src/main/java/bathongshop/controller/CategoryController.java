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

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import bathongshop.constant.CategoryIdEnum;
import bathongshop.constant.ConstantDoubleEnum;
import bathongshop.constant.SortByEnum;
import bathongshop.constant.ConstantIntegerEnum;
import bathongshop.constant.PublicConstant;
import bathongshop.dao.BrandDAO;
import bathongshop.dao.ProductDAO;
import bathongshop.entity.Brand;
import bathongshop.entity.Product;
import bathongshop.model.ProductModel;

@WebServlet(PublicConstant.CATEGORY_URL)
public class CategoryController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ProductDAO productDAO = ProductDAO.getProductDAO();
	private BrandDAO brandDAO = BrandDAO.getBrandDAO();
	private static Logger logger = LogManager.getLogger(CategoryController.class);

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
		case PublicConstant.PRODUCT_DETAIL_COMMAND:
			productDetail(request, response);
			break;
		case PublicConstant.SEARCH_COMMAND:
			search(request, response);
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
					: CategoryIdEnum.CATEGORYID_DEFAULT.getValue();

			int categoryId = getCategoryIdByCategoryPage(categoryPage);
			String sortColumn = getSortColumnBySortRequest(sort);
			String sortType = getSortTypeBySortRequest(sort);
			int itemPerPage = Integer.parseInt(PublicConstant.ITEM_PER_PAGE);
			int totalProducts = productDAO.totalCategoryProduct(categoryId);
			int startItem = (pageId - ConstantIntegerEnum.CONSTANT_1.getValue()) * itemPerPage;
			int totalPage = getTotalPage(totalProducts, itemPerPage);

			String[] sortSelect = { PublicConstant.DEFAULT_COMMAND, PublicConstant.PRICE_ASC_COMMAND,
					PublicConstant.PRICE_DESC_COMMAND, PublicConstant.AZ_COMMAND, PublicConstant.ZA_COMMAND };
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
			logger.error(PublicConstant.THIS_IS_ERROR, e.getMessage());
		}
	}

	public String getSortColumnBySortRequest(String sort) {
		String sortColumn = PublicConstant.EMPTY_STRING;
		switch (sort) {
		case PublicConstant.DEFAULT_COMMAND:
			sortColumn = PublicConstant.ID;
			break;
		case PublicConstant.PRICE_ASC_COMMAND:
			sortColumn = SortByEnum.PRICE_COLUMN.getString();
			break;
		case PublicConstant.PRICE_DESC_COMMAND:
			sortColumn = SortByEnum.PRICE_COLUMN.getString();
			break;
		case PublicConstant.AZ_COMMAND:
			sortColumn = SortByEnum.NAME_COLUMN.getString();
			break;
		case PublicConstant.ZA_COMMAND:
			sortColumn = SortByEnum.NAME_COLUMN.getString();
			break;
		}
		return sortColumn;
	}

	public String getSortTypeBySortRequest(String sort) {
		String sortType = PublicConstant.EMPTY_STRING;
		switch (sort) {
		case PublicConstant.DEFAULT_COMMAND:
			sortType = SortByEnum.ASC.getString();
			break;
		case PublicConstant.PRICE_ASC_COMMAND:
			sortType = SortByEnum.ASC.getString();
			break;
		case PublicConstant.PRICE_DESC_COMMAND:
			sortType = SortByEnum.DESC.getString();
			break;
		case PublicConstant.AZ_COMMAND:
			sortType = SortByEnum.ASC.getString();
			break;
		case PublicConstant.ZA_COMMAND:
			sortType = SortByEnum.DESC.getString();
			break;
		}
		return sortType;
	}

	public int getCategoryIdByCategoryPage(String categoryPage) {
		int categoryId = CategoryIdEnum.CATEGORYID_DEFAULT.getValue();
		switch (categoryPage) {
		case PublicConstant.RACKETS_PAGE_COMMAND:
			categoryId = CategoryIdEnum.RACKETS_CATEGORYID.getValue();
			break;
		case PublicConstant.BAGS_PAGE_COMMAND:
			categoryId = CategoryIdEnum.BAGS_CATEGORYID.getValue();
			break;
		case PublicConstant.CLOTHING_PAGE_COMMAND:
			categoryId = CategoryIdEnum.CLOTHING_CATEGORYID.getValue();
			break;
		case PublicConstant.SHOES_PAGE_COMMAND:
			categoryId = CategoryIdEnum.SHOES_CATEGORYID.getValue();
			break;
		case PublicConstant.STRING_PAGE_COMMAND:
			categoryId = CategoryIdEnum.STRING_CATEGORYID.getValue();
			break;
		}
		return categoryId;
	}

	public int getTotalPage(int totalProducts, int itemPerPage) {
		int totalPage = (int) Math.ceil(totalProducts * ConstantDoubleEnum.CONSTANT_1.getValue() / itemPerPage);
		return totalPage;
	}

	protected void productDetail(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			int id = Integer.parseInt(request.getParameter(PublicConstant.ID));
			ProductModel existingProduct = productDAO.selectProduct(id);
			List<Product> relatedProduct = productDAO.selectRelatedProducts();
			request.setAttribute(PublicConstant.RELATED_PRODUCT, relatedProduct);
			request.setAttribute(PublicConstant.PRODUCT, existingProduct);
			RequestDispatcher dispatcher = request.getRequestDispatcher(PublicConstant.PRODUCT_DETAIL_JSP);
			dispatcher.forward(request, response);
		} catch (Exception e) {
			logger.error(PublicConstant.THIS_IS_ERROR, e.getMessage());
		}
	}

	protected void search(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			String search = request.getParameter(PublicConstant.SEARCH);
			List<Product> searchProducts = productDAO.searchProducts(search);
			request.setAttribute(PublicConstant.SEARCH_STRING, search);
			request.setAttribute(PublicConstant.SEARCH_PRODUCT, searchProducts);
			RequestDispatcher dispatcher = request.getRequestDispatcher(PublicConstant.SEARCH_JSP);
			dispatcher.forward(request, response);
		} catch (Exception e) {
			logger.error(PublicConstant.THIS_IS_ERROR, e.getMessage());
		}
	}

	public void saleOff(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			List<Product> saleOffProduct = productDAO.selectSaleOffProduct();
			request.setAttribute(PublicConstant.SALE_OFF_PRODUCT, saleOffProduct);
			RequestDispatcher dispatcher = request.getRequestDispatcher(PublicConstant.SALEOFF_JSP);
			dispatcher.forward(request, response);
		} catch (Exception e) {
			logger.error(PublicConstant.THIS_IS_ERROR, e.getMessage());
		}
	}
}