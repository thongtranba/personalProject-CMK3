package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.CustomerDAO;
import model.Customer;

/**
 * Servlet implementation class CustomerServlet
 */
@WebServlet("/register")
public class CustomerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private CustomerDAO customerDAO = new CustomerDAO();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CustomerServlet() {

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		  register(request, response);
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		 List<Customer> customers = customerDAO.selectAllCustomers();
			System.out.println("customers:: " + customers.size());
			 response.sendRedirect("HomeSevlet");
		
	}
	 private void register(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
			String username = request.getParameter("username");
			String password = request.getParameter("password");
			String mobile = request.getParameter("mobile");
			String email = request.getParameter("email");
			String address = request.getParameter("address");
			Customer newCustomer = new Customer(username, password, mobile, email, address);
			try {
				int result = customerDAO.insertCustomer(newCustomer);
				if (result == 1) {
					request.setAttribute("NOTIFICATION", "Registered Successfully!");
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			RequestDispatcher dispatcher = request.getRequestDispatcher("HomeSevlet");
	        dispatcher.forward(request, response);
			 
	    }

}