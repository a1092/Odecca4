package fr.efrei.Mission;

import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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
				request.setAttribute("postulationlist", mm.getPostulationByMission(mm.getMissionById(recordid)));
				
				
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
			}  else if (request.getParameter("action").equals("postuler")) {
				
				if(request.getParameter("recordid") == null) {

					HttpSession session = request.getSession();
					User u = (User)session.getAttribute("user");
					
					try {
						request.setAttribute("missionlist", mm.getMissionByStatut("En cours"));
						
					} catch (Exception e) {
						
					}
					
					this.getServletContext().getRequestDispatcher("/modules/Mission/ListMission.jsp").forward(request, response);
					
				} else {
					
					int recordid = Integer.parseInt(request.getParameter("recordid"));
					
					if(request.getParameter("postuler") != null && request.getParameter("postuler").equals("true")) {
						
						HttpSession session = request.getSession();
						User u = (User)session.getAttribute("user");
						
						Postulation p = new Postulation();
						p.setInterimaire(mm.getInterimaireById(u.getId()));
						p.setMission(mm.getMissionById(recordid));
						p.setStatut("Candidature");
						
						p.setInscription(new Date());
						mm.save(p);
					} else {
						
						HttpSession session = request.getSession();
						User u = (User)session.getAttribute("user");
						
						Postulation p = mm.getPostulationByMissionInterimaire(mm.getMissionById(recordid), mm.getInterimaireById(u.getId()));
						
						mm.remove(p);
					}
					
					response.sendRedirect("/Odecca4/app/mission?action=postuler");
				}
			} else if (request.getParameter("action").equals("missioner")) {
				
				if(request.getParameter("mission") == null || request.getParameter("interimaire") == null)
					throw new ServletException("Not record found.");
				
				int missionid = Integer.parseInt(request.getParameter("mission"));
				int interimaireid = Integer.parseInt(request.getParameter("interimaire"));
				
				Mission mission = mm.getMissionById(missionid);
				Interimaire interimaire = mm.getInterimaireById(interimaireid);
				Postulation p = mm.getPostulationByMissionInterimaire(mission, interimaire);
				
				p.setStatut("Selectionné");
				
				mm.save(p);
				
				mission.setStatut("Terminé");
				mm.save(mission);
				
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
		
		if(mis.getId() == 0) {
			mis.setStatut("En cours");
		}
		
		
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
		mis.setAccount(mm.getAccountById(Integer.parseInt(request.getParameter("account"))));
		
		
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
