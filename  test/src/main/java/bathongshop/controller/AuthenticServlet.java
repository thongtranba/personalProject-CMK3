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
import bathongshop.DAO.LoginDAO;
import bathongshop.entity.Customer;

/**
 * Servlet implementation class AuthenticServlet
 */
@WebServlet("/authenticServlet")
public class AuthenticServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private LoginDAO loginDAO = new LoginDAO();
	private CustomerDAO customerDAO = new CustomerDAO();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AuthenticServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			String command = request.getParameter("command");
			if (command != null && command.equals("LOGIN")) {
				String email = request.getParameter("email");
				String password = request.getParameter("password");
				Customer customer = loginDAO.validate(email, password);
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
					response.sendRedirect("HomeServlet");
				}
				
			} else if (command != null && command.equals("REGISTER")) {
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
				
			} else if (command != null && command.equals("LOGOUT")) {
				HttpSession session = request.getSession(false);
				session.removeAttribute("username");
				session.removeAttribute("mobile");
				session.removeAttribute("address");
				response.sendRedirect("HomeServlet");
			}

		} catch (Exception e) {
			e.printStackTrace();
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

}
