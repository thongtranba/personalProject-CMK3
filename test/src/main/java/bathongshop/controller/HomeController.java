package bathongshop.controller;

import java.io.IOException;
import java.util.List;
import org.apache.logging.log4j.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bathongshop.constant.PublicConstant;
import bathongshop.dao.ProductDAO;
import bathongshop.entity.Product;

@WebServlet(urlPatterns = { PublicConstant.HOME_URL })

public class HomeController extends HttpServlet {

	private static Logger logger = LogManager.getLogger(HomeController.class);

	private static final long serialVersionUID = 1L;
	private ProductDAO productDAO = ProductDAO.getProductDAO();

	public HomeController() {
		super();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			List<Product> products = productDAO.selectAllProducts();
			logger.info(PublicConstant.ALL_PRODUCT + products.size());
			List<Product> popularProduct = productDAO.selectPopularProducts();
			List<Product> lastestProduct = productDAO.selectLatestProducts();
			List<Product> service = productDAO.selectService();
			request.setAttribute(PublicConstant.POPULAR_PRODUCT, popularProduct);
			request.setAttribute(PublicConstant.LATEST_PRODUCT, lastestProduct);
			request.setAttribute(PublicConstant.SERVICE_PRODUCT, service);
			RequestDispatcher dispatcher = request.getRequestDispatcher(PublicConstant.HOME_JSP);
			dispatcher.forward(request, response);
		} catch (Exception e) {
			logger.error(PublicConstant.THIS_IS_ERROR, e.getMessage());
		}
	}
}
