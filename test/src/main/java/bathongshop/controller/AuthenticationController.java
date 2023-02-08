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

import bathongshop.constant.ConstantVariableEnum;
import bathongshop.constant.NotificationEnum;
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
		case PublicConstant.UPDATE:
			update(request, response);
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
				request.setAttribute(NotificationEnum.LOGIN_NOTIFICATION.getValue(),
						NotificationEnum.LOGIN_NOTIFICATION_MESSAGE.getValue());
				RequestDispatcher dispatcher = request.getRequestDispatcher(PublicConstant.NOTIFICATION_JSP);
				dispatcher.forward(request, response);
			} else {
				HttpSession session = request.getSession(false);
				session.setAttribute(PublicConstant.CUSTOMERID, customer.getId());
				session.setAttribute(PublicConstant.USERNAME, customer.getUsername());
				session.setAttribute(PublicConstant.MOBILE, customer.getMobile());
				session.setAttribute(PublicConstant.EMAIL, customer.getEmail());
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
			int result = ConstantVariableEnum.CONSTANT_0.getValue();
			String username = request.getParameter(PublicConstant.USERNAME);
			String password = request.getParameter(PublicConstant.PASSWORD);
			String mobile = request.getParameter(PublicConstant.MOBILE);
			String email = request.getParameter(PublicConstant.EMAIL);
			String address = request.getParameter(PublicConstant.ADDRESS);
			Customer newCustomer = new Customer(username, password, mobile, email, address);
			boolean duplicatedEmailOrMobile = customerDAO.checkDuplicatedEmailAndMobile(email, mobile);
			if (duplicatedEmailOrMobile == true) {
				request.setAttribute(NotificationEnum.REGISTER_DUPLICATED_NOTIFICATION.getValue(),
						NotificationEnum.REGISTER_DUPLICATED_NOTIFICATION_MESSAGE.getValue());
				RequestDispatcher dispatcher = request.getRequestDispatcher(PublicConstant.NOTIFICATION_JSP);
				dispatcher.forward(request, response);
			} else {
				result = customerDAO.insertCustomer(newCustomer);
			}

			if (result == ConstantVariableEnum.CONSTANT_1.getValue()) {
				request.setAttribute(NotificationEnum.REGISTER_NOTIFICATION.getValue(),
						NotificationEnum.REGISTER_NOTIFICATION_MESSAGE.getValue());
				RequestDispatcher dispatcher = request.getRequestDispatcher(PublicConstant.NOTIFICATION_JSP);
				dispatcher.forward(request, response);
			} else {
				request.setAttribute(NotificationEnum.REGISTER_FAIL_NOTIFICATION.getValue(),
						NotificationEnum.REGISTER_FAIL_NOTIFICATION_MESSAGE.getValue());
				RequestDispatcher dispatcher = request.getRequestDispatcher(PublicConstant.NOTIFICATION_JSP);
				dispatcher.forward(request, response);
			}

		} catch (Exception e) {
			logger.error(PublicConstant.THIS_IS_ERROR, e.getMessage());
		}
	}

	private void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			HttpSession session = request.getSession();
			boolean result = false;
			int customerId = (int) session.getAttribute(PublicConstant.CUSTOMERID);
			String username = request.getParameter(PublicConstant.USERNAME);
			String password = request.getParameter(PublicConstant.PASSWORD);
			String mobile = request.getParameter(PublicConstant.MOBILE);
			String email = request.getParameter(PublicConstant.EMAIL);
			String address = request.getParameter(PublicConstant.ADDRESS);
			Customer updateCustomer = new Customer(username, password, mobile, email, address);
			boolean duplicatedEmailOrMobile = customerDAO.checkDuplicatedEmailAndMobile(email, mobile);
			if (duplicatedEmailOrMobile == true) {
				request.setAttribute(NotificationEnum.UPDATE_DUPLICATED_NOTIFICATION.getValue(),
						NotificationEnum.UPDATE_DUPLICATED_NOTIFICATION_MESSAGE.getValue());
				RequestDispatcher dispatcher = request.getRequestDispatcher(PublicConstant.NOTIFICATION_JSP);
				dispatcher.forward(request, response);
			} else {
				result = customerDAO.updateCustomer(updateCustomer, customerId);
			}
			if (result == true) {
				session.removeAttribute(PublicConstant.USERNAME);
				session.removeAttribute(PublicConstant.MOBILE);
				session.removeAttribute(PublicConstant.ADDRESS);
				session.removeAttribute(PublicConstant.EMAIL);
				request.setAttribute(NotificationEnum.UPDATE_NOTIFICATION.getValue(),
						NotificationEnum.UPDATE_NOTIFICATION_MESSAGE.getValue());
				RequestDispatcher dispatcher = request.getRequestDispatcher(PublicConstant.NOTIFICATION_JSP);
				dispatcher.forward(request, response);
			} else {
				request.setAttribute(NotificationEnum.UPDATE_FAIL_NOTIFICATION.getValue(),
						NotificationEnum.UPDATE_FAIL_NOTIFICATION_MESSAGE.getValue());
				RequestDispatcher dispatcher = request.getRequestDispatcher(PublicConstant.NOTIFICATION_JSP);
				dispatcher.forward(request, response);
			}

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
			session.removeAttribute(PublicConstant.EMAIL);
			response.sendRedirect(PublicConstant.HOME_CONTROLLER);
		} catch (Exception e) {
			logger.error(PublicConstant.THIS_IS_ERROR, e.getMessage());
		}
	}
}