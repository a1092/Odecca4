package fr.efrei.Mission;

import java.io.IOException;
import java.math.BigInteger;
import java.security.SecureRandom;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.efrei.Account.Account;
import fr.efrei.Account.AccountManager;
import fr.efrei.Interimaire.Competence;
import fr.efrei.Interimaire.Interimaire;
import fr.efrei.Security.User;

/**
 * Servlet implementation class MissionController
 */
public class MissionController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	private MissionManager mm = new MissionManager();
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MissionController() {
        super();
       
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
				
				request.setAttribute("mission", mm.getMissionById(recordid));
				
				this.getServletContext().getRequestDispatcher("/modules/Mission/ViewMission.jsp").forward(request, response);
			
			
			}  else if (request.getParameter("action").equals("edit")) {
				
				if(request.getParameter("recordid") == null)
					throw new ServletException("Not record found.");
				int recordid = Integer.parseInt(request.getParameter("recordid"));
				
				try {
					request.setAttribute("competenceslist", mm.getAllCompetences());
					request.setAttribute("accountlist", mm.getAllAccount());
					request.setAttribute("secteurlist", mm.getAllSecteur());
				} catch (Exception e) {
					
				}
				
				request.setAttribute("mission", mm.getMissionById(recordid));
				this.getServletContext().getRequestDispatcher("/modules/Mission/EditMission.jsp").forward(request, response);
				
			}  else if (request.getParameter("action").equals("new")) {
				
				try {
					request.setAttribute("competenceslist", mm.getAllCompetences());
					request.setAttribute("accountlist", mm.getAllAccount());
					request.setAttribute("secteurlist", mm.getAllSecteur());
				} catch (Exception e) {
					
				}
				
				request.setAttribute("mission", new Mission());
				this.getServletContext().getRequestDispatcher("/modules/Mission/EditMission.jsp").forward(request, response);
			}  else if (request.getParameter("action").equals("delete")) {
				
				if(request.getParameter("recordid") == null)
					throw new ServletException("Not record found.");
				
				int recordid = Integer.parseInt(request.getParameter("recordid"));
				
				mm.remove(mm.getMissionById(recordid));
				
				response.sendRedirect("/Odecca4/app/mission");
			}
		}
		
		else {
			try {
				request.setAttribute("missionlist", mm.getAllMission());
			} catch (Exception e) {
				
			}
			
			this.getServletContext().getRequestDispatcher("/modules/Mission/ListMission.jsp").forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		Mission mis = new Mission();
		
		if(request.getParameter("id") != null)
			mis.setId(Integer.parseInt(request.getParameter("id")));
		
		DateFormat formatter = new SimpleDateFormat("dd/mm/yyyy");
		
		try {
			mis.setDebut(formatter.parse(request.getParameter("debut")));
			mis.setFin(formatter.parse(request.getParameter("fin")));
		} catch (ParseException e) {
			
		}
		
		
		mis.setIntitule(request.getParameter("intitule"));
		mis.setLieu(request.getParameter("lieu"));
		mis.setDescription(request.getParameter("description"));
		mis.setTarif(Integer.parseInt(request.getParameter("tarif")));
		mis.setSecteur(mm.getSecteurById(Integer.parseInt(request.getParameter("secteur"))));
		
		
		String[] qualification = request.getParameterValues("competences");
		
		if(qualification != null) {
			for(int i=0; i < qualification.length; i++) {
				
				Competence q = mm.getCompetence(Integer.parseInt(qualification[i]));
				mis.addQualification(q);
			}
		}
		
		mm.save(mis);
		
		
		response.sendRedirect("/Odecca4/app/mission?action=view&recordid="+mis.getId());
	}

}
