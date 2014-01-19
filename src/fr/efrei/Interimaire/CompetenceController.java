package fr.efrei.Interimaire;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CompetenceController
 */
public class CompetenceController extends HttpServlet {

	private static final long serialVersionUID = -2715231458980314338L;
	
	private CompetenceManager cm = new CompetenceManager();
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CompetenceController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		
		if(request.getParameter("action") != null) {
			if (request.getParameter("action").equals("view")) {
				
				
				if(request.getParameter("recordid") == null)
					throw new ServletException("Not record found.");
				
				int recordid = Integer.parseInt(request.getParameter("recordid"));
				
				request.setAttribute("competence", cm.getCompetenceById(recordid));
				
				this.getServletContext().getRequestDispatcher("/modules/Interimaire/ViewCompetence.jsp").forward(request, response);
			
			
			}  else if (request.getParameter("action").equals("edit")) {
				
				if(request.getParameter("recordid") == null)
					throw new ServletException("Not record found.");
				int recordid = Integer.parseInt(request.getParameter("recordid"));
				
				Competence comp = cm.getCompetenceById(recordid);
				
				
				request.setAttribute("competence", cm.getCompetenceById(recordid));
				this.getServletContext().getRequestDispatcher("/modules/Interimaire/EditCompetence.jsp").forward(request, response);
				
			}  else if (request.getParameter("action").equals("new")) {
				request.setAttribute("competence", new Competence());
				this.getServletContext().getRequestDispatcher("/modules/Interimaire/EditCompetence.jsp").forward(request, response);
			}  else if (request.getParameter("action").equals("delete")) {
				
				if(request.getParameter("recordid") == null)
					throw new ServletException("Not record found.");
				
				int recordid = Integer.parseInt(request.getParameter("recordid"));
				
				cm.remove(cm.getCompetenceById(recordid));
				
				response.sendRedirect("/Odecca4/app/competence");
			}
		}
		
		else {
			try {
				request.setAttribute("competencelist", cm.getAllCompetence());
			} catch (Exception e) {
				
			}
			
			this.getServletContext().getRequestDispatcher("/modules/Interimaire/ListCompetence.jsp").forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


		Competence comp = new Competence();
		comp.setId(Integer.parseInt(request.getParameter("id")));
		comp.setNom(request.getParameter("nom"));
		
		cm.save(comp);
		
		response.sendRedirect("/Odecca4/app/competence?action=view&recordid="+comp.getId());
	}

}
