package bathongshop.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import bathongshop.DAO.ProductDAO;
import bathongshop.constant.PublicConstant;
import bathongshop.entity.Product;
import bathongshop.model.ProductModel;

@WebServlet(PublicConstant.PRODUCT_DETAIL_URL)
public class ProductDetailController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ProductDAO productDAO = new ProductDAO();
	private static Logger logger = LogManager.getLogger(ProductDetailController.class);

	public ProductDetailController() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
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
			logger.info(PublicConstant.LOG_INFO, e);
			logger.warn(PublicConstant.LOG_WARN, e);
			logger.debug(PublicConstant.LOG_DEBUG, e);
			logger.error(PublicConstant.LOG_ERROR, e);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
