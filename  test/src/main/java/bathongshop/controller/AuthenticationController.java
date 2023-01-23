package bathongshop.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bathongshop.DAO.CustomerDAO;
import bathongshop.entity.Customer;

/**
 * Servlet implementation class AuthenticServlet
 */
@WebServlet("/authentication")
public class AuthenticationController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private CustomerDAO customerDAO = new CustomerDAO();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AuthenticationController() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
			String command = request.getParameter("command");
			switch (command) {
			case "LOGIN":
				logIn(request, response);
				break;
			case "REGISTER":
				register(request, response);
				break;
			case "LOGOUT":
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
			String email = request.getParameter("email");
			String password = request.getParameter("password");
			Customer customer = customerDAO.validate(email, password);
			if (customer == null) {
				request.setAttribute("loginNotification", "Login fail!!");
				RequestDispatcher dispatcher = request.getRequestDispatcher("notification.jsp");
				dispatcher.forward(request, response);
			} else {
				HttpSession session = request.getSession(false);
				session.setAttribute("customerId", customer.getId());
				session.setAttribute("username", customer.getUsername());
				session.setAttribute("mobile", customer.getMobile());
				session.setAttribute("address", customer.getAddress());
				response.sendRedirect("home");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	private void register(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			String username = request.getParameter("username");
			String password = request.getParameter("password");
			String mobile = request.getParameter("mobile");
			String email = request.getParameter("email");
			String address = request.getParameter("address");
			Customer newCustomer = new Customer(username, password, mobile, email, address);
			int result = customerDAO.insertCustomer(newCustomer);
			if (result == 1) {
				request.setAttribute("registerNotification", "Registered Successfully!");
			}
			RequestDispatcher dispatcher = request.getRequestDispatcher("notification.jsp");
			dispatcher.forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	private void logOut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			HttpSession session = request.getSession(false);
			session.removeAttribute("username");
			session.removeAttribute("mobile");
			session.removeAttribute("address");
			response.sendRedirect("home");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
