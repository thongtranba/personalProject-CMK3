package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.LoginDAO;
import model.Customer;


/**
 * Servlet implementation class LoginController
 */
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private LoginDAO loginDAO = new LoginDAO();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    	    throws ServletException, IOException {
    	
    	 doGet(request, response);
   
    	    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    	    throws ServletException, IOException {
    	 
    	  String email = request.getParameter("email");
          String password = request.getParameter("password");
         
          try {
        	  Customer customer = loginDAO.validate(email, password);
              if (customer == null) {
            	  request.setAttribute("loginNotification", "Login fail!!");
            	  RequestDispatcher dispatcher = request.getRequestDispatcher("notification.jsp");
      			dispatcher.forward(request, response);
              }else {
            	  HttpSession session = request.getSession(false);
            	  session.setAttribute("customerId", customer.getId());
            	  session.setAttribute("username", customer.getUsername());
            	  session.setAttribute("mobile", customer.getMobile());
            	  session.setAttribute("address", customer.getAddress());
            	  response.sendRedirect("HomeServlet");
              } 
          } catch (Exception e) {
              e.printStackTrace();
          }
    	
    	    }


}
