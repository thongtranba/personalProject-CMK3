package bathongshop.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import bathongshop.constant.PublicConstant;
import bathongshop.dao.CustomerDAO;
import bathongshop.entity.Customer;

@WebServlet(PublicConstant.AUTH_URL)
public class AuthenticationController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private CustomerDAO customerDAO = CustomerDAO.getCustomerDAO();
	private static Logger logger = LogManager.getLogger(AuthenticationController.class);

	public AuthenticationController() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String command = request.getParameter(PublicConstant.COMMAND);
		switch (command) {
		case PublicConstant.LOGIN:
			logIn(request, response);
			break;
		case PublicConstant.REGISTER:
			register(request, response);
			break;
		case PublicConstant.LOGOUT:
			logOut(request, response);
			break;
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

	private void logIn(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			String email = request.getParameter(PublicConstant.EMAIL);
			String password = request.getParameter(PublicConstant.PASSWORD);
			Customer customer = customerDAO.validate(email, password);
			if (customer == null) {
				request.setAttribute(PublicConstant.LOGIN_NOTIFICATION, PublicConstant.LOGIN_NOTIFICATION_MESSAGE);
				RequestDispatcher dispatcher = request.getRequestDispatcher(PublicConstant.NOTIFICATION_JSP);
				dispatcher.forward(request, response);
			} else {
				HttpSession session = request.getSession(false);
				session.setAttribute(PublicConstant.CUSTOMERID, customer.getId());
				session.setAttribute(PublicConstant.USERNAME, customer.getUsername());
				session.setAttribute(PublicConstant.MOBILE, customer.getMobile());
				session.setAttribute(PublicConstant.ADDRESS, customer.getAddress());
				RequestDispatcher dispatcher = request.getRequestDispatcher(PublicConstant.HOME_CONTROLLER);
				dispatcher.forward(request, response);
			}
		} catch (Exception e) {
			logger.error(PublicConstant.THIS_IS_ERROR, e.getMessage());
		}
	}

	private void register(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			String username = request.getParameter(PublicConstant.USERNAME);
			String password = request.getParameter(PublicConstant.PASSWORD);
			String mobile = request.getParameter(PublicConstant.MOBILE);
			String email = request.getParameter(PublicConstant.EMAIL);
			String address = request.getParameter(PublicConstant.ADDRESS);
			Customer newCustomer = new Customer(username, password, mobile, email, address);
			int result = customerDAO.insertCustomer(newCustomer);
			if (result == Integer.parseInt(PublicConstant.CONSTANT_1)) {
				request.setAttribute(PublicConstant.REGISTER_NOTIFICATION,
						PublicConstant.REGISTER_NOTIFICATION_MESSAGE);
			}
			RequestDispatcher dispatcher = request.getRequestDispatcher(PublicConstant.NOTIFICATION_JSP);
			dispatcher.forward(request, response);
		} catch (Exception e) {
			logger.error(PublicConstant.THIS_IS_ERROR, e.getMessage());
		}
	}

	private void logOut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			HttpSession session = request.getSession(false);
			session.removeAttribute(PublicConstant.USERNAME);
			session.removeAttribute(PublicConstant.MOBILE);
			session.removeAttribute(PublicConstant.ADDRESS);
			response.sendRedirect(PublicConstant.HOME_CONTROLLER);
		} catch (Exception e) {
			logger.error(PublicConstant.THIS_IS_ERROR, e.getMessage());
		}
	}

}
