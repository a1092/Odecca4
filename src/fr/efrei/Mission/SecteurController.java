package fr.efrei.Mission;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class SecteurController
 */
public class SecteurController extends HttpServlet {

	private static final long serialVersionUID = -2715231458980314338L;
	
	private SecteurManager sm = new SecteurManager();
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SecteurController() {
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
				
				request.setAttribute("secteur", sm.getSecteurById(recordid));
				
				this.getServletContext().getRequestDispatcher("/modules/Mission/ViewSecteur.jsp").forward(request, response);
			
			
			}  else if (request.getParameter("action").equals("edit")) {
				
				if(request.getParameter("recordid") == null)
					throw new ServletException("Not record found.");
				int recordid = Integer.parseInt(request.getParameter("recordid"));
				
				Secteur sect = sm.getSecteurById(recordid);
				
				
				request.setAttribute("secteur", sm.getSecteurById(recordid));
				this.getServletContext().getRequestDispatcher("/modules/Mission/EditSecteur.jsp").forward(request, response);
				
			}  else if (request.getParameter("action").equals("new")) {
				request.setAttribute("secteur", new Secteur());
				this.getServletContext().getRequestDispatcher("/modules/Mission/EditSecteur.jsp").forward(request, response);
			}  else if (request.getParameter("action").equals("delete")) {
				
				if(request.getParameter("recordid") == null)
					throw new ServletException("Not record found.");
				
				int recordid = Integer.parseInt(request.getParameter("recordid"));
				
				sm.remove(sm.getSecteurById(recordid));
				
				response.sendRedirect("/Odecca4/app/secteur");
			}
		}
		
		else {
			try {
				request.setAttribute("secteurlist", sm.getAllSecteur());
			} catch (Exception e) {
				
			}
			
			this.getServletContext().getRequestDispatcher("/modules/Mission/ListSecteur.jsp").forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


		Secteur sect = new Secteur();
		sect.setId(Integer.parseInt(request.getParameter("id")));
		sect.setNom(request.getParameter("nom"));
		
		sm.save(sect);
		
		response.sendRedirect("/Odecca4/app/secteur?action=view&recordid="+sect.getId());
	}

}
