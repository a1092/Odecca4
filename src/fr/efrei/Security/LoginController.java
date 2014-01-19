package fr.efrei.Security;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	private UserManager user = new UserManager();
	
    /**
     * Default constructor. 
     */
    public LoginController() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession(false);
	       
        if (session != null && session.getAttribute("userid") != null) {
			response.sendRedirect("/Odecca4/app/home");
			return;
        }
        
		this.getServletContext().getRequestDispatcher("/view/login.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String login = request.getParameter("login");
		String password = request.getParameter("password");
		
		User u = null;
		try {
			u = user.authenticate(login, password);
		} catch (Exception e) {
			
			System.out.println("Error in servlet Login : "+e.getMessage());
			this.getServletContext().getRequestDispatcher("/view/login.jsp").forward(request, response);
			return;
		}
		
		HttpSession session = request.getSession(true);
		session.setMaxInactiveInterval(30*60);
		session.setAttribute("userid", u.getId());
		
		response.sendRedirect("/Odecca4/app/home");
	}

}
