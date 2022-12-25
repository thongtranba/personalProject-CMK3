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
import model.Login;

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
    	        authenticate(request, response);
    	    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    	    throws ServletException, IOException {
    	
    	        response.sendRedirect("HomeSevlet");
    	    }


    private void authenticate(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        Login login= new Login();
        login.setUsername(username);
        login.setPassword(password);

        try {
            if (loginDAO.validate(login)) {
                RequestDispatcher dispatcher = request.getRequestDispatcher("");
                dispatcher.forward(request, response);
            } else {
                HttpSession session = request.getSession();
                 session.setAttribute("user", username);
              
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        
        RequestDispatcher dispatcher = request.getRequestDispatcher("HomeSevlet");
        dispatcher.forward(request, response);
    }
}
