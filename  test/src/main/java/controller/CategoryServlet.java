package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ProductDAO;
import model.Product;

/**
 * Servlet implementation class categoryServlet
 */
@WebServlet("/category")
public class CategoryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ProductDAO productDAO = new ProductDAO();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CategoryServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			String command = request.getParameter("command");
			int categoryId = Integer.parseInt(request.getParameter("categoryId"));
			if(command !=null && command.equals("rackets")) {
				List<Product> listRacket = productDAO.selectAllProductByCategoryId(categoryId);
				request.setAttribute("listRacket", listRacket);
				RequestDispatcher dispatcher = request.getRequestDispatcher("rackets.jsp");
				dispatcher.forward(request, response);
			}else if(command !=null && command.equals("bags")) {
				List<Product> listBags = productDAO.selectAllProductByCategoryId(categoryId);
				request.setAttribute("listBags", listBags);
				RequestDispatcher dispatcher = request.getRequestDispatcher("bags.jsp");
				dispatcher.forward(request, response);
			}else if(command !=null && command.equals("clothing")) {
				List<Product> listCloth = productDAO.selectAllProductByCategoryId(categoryId);
				request.setAttribute("listCloth", listCloth);
				RequestDispatcher dispatcher = request.getRequestDispatcher("clothing.jsp");
				dispatcher.forward(request, response);
			}else if(command !=null && command.equals("shoes")) {
				List<Product> listShoes = productDAO.selectAllProductByCategoryId(categoryId);
				request.setAttribute("listShoes", listShoes);
				RequestDispatcher dispatcher = request.getRequestDispatcher("shoes.jsp");
				dispatcher.forward(request, response);
			}else if(command !=null && command.equals("strings")) {
				List<Product> listStrings = productDAO.selectAllProductByCategoryId(categoryId);
				request.setAttribute("listStrings", listStrings);
				RequestDispatcher dispatcher = request.getRequestDispatcher("strings.jsp");
				dispatcher.forward(request, response);
			}
			
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
