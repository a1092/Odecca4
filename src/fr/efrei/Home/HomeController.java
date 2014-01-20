package fr.efrei.Home;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fr.efrei.Mission.MissionManager;
import fr.efrei.Mission.Postulation;
import fr.efrei.Security.User;

/**
 * Servlet implementation class HomeController
 */
public class HomeController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	private MissionManager mm = new MissionManager();
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HomeController() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		User u = (User)session.getAttribute("user");
		
		
		
		try {
			request.setAttribute("postulation_encours", mm.getPostulationByStatutInterimaire("En cours", mm.getInterimaireById(u.getId())));
			request.setAttribute("postulation_termine", mm.getPostulationByStatutInterimaire("Terminé", mm.getInterimaireById(u.getId())));
			
		} catch (Exception e) {
			
		}
		
		this.getServletContext().getRequestDispatcher("/modules/Home/Dashboard.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
