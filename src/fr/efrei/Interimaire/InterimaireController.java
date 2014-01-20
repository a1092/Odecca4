package fr.efrei.Interimaire;

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

import fr.efrei.Security.User;

/**
 * Servlet implementation class InterimaireController
 */
public class InterimaireController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	
	private InterimaireManager im = new InterimaireManager();
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InterimaireController() {
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
				
				request.setAttribute("interimaire", im.getInterimaireById(recordid));
				
				this.getServletContext().getRequestDispatcher("/modules/Interimaire/ViewInterimaire.jsp").forward(request, response);
			
			
			}  else if (request.getParameter("action").equals("edit")) {
				
				if(request.getParameter("recordid") == null)
					throw new ServletException("Not record found.");
				int recordid = Integer.parseInt(request.getParameter("recordid"));
				
				request.setAttribute("interimaire", im.getInterimaireById(recordid));
				try {
					request.setAttribute("competenceslist", im.getAllCompetences());
				} catch (Exception e) {
					
				}
				this.getServletContext().getRequestDispatcher("/modules/Interimaire/EditInterimaire.jsp").forward(request, response);
				
			}  else if (request.getParameter("action").equals("new")) {
				
				
				try {
					request.setAttribute("competenceslist", im.getAllCompetences());
				} catch (Exception e) {
					
				}
				
				request.setAttribute("interimaire", new Interimaire());
				this.getServletContext().getRequestDispatcher("/modules/Interimaire/EditInterimaire.jsp").forward(request, response);
			
			}  else if (request.getParameter("action").equals("delete")) {
				
				if(request.getParameter("recordid") == null)
					throw new ServletException("Not record found.");
				
				int recordid = Integer.parseInt(request.getParameter("recordid"));
				
				im.remove(im.getInterimaireById(recordid));
				
				response.sendRedirect("/Odecca4/app/interimaire");
			}
		}
		
		else {
			try {
				request.setAttribute("interimairelist", im.getAllInterimaire());
			} catch (Exception e) {
				
			}
			
			this.getServletContext().getRequestDispatcher("/modules/Interimaire/ListInterimaire.jsp").forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Interimaire inte = new Interimaire();
		User user = new User();
		
		if(request.getParameter("id") != null)
			user.setId(Integer.parseInt(request.getParameter("id")));

		if(user.getId() == 0)  {
			user.setLogin(new BigInteger(130, new SecureRandom()).toString(32).substring(1, 8));
			user.setPassword(new BigInteger(130, new SecureRandom()).toString(32).substring(1, 5));
			user.setRole("INTER");
		} else {
			user = im.getInterimaireById(user.getId()).getUser();
		}
		
		user.setFirstname(request.getParameter("firstname"));
		user.setLastname(request.getParameter("lastname"));
		user.setEmail(request.getParameter("email"));
		
		im.save(user);
		
		inte.setId(user.getId());
		inte.setUser(user);
		inte.setFormation(request.getParameter("formation"));
		
		DateFormat formatter = new SimpleDateFormat("dd/mm/yyyy");
	
		try {
			inte.setNaissance(formatter.parse(request.getParameter("naissance")));
		} catch (ParseException e) {
			
		}
		
		String[] qualification = request.getParameterValues("qualification");
		
		if(qualification != null) {
			for(int i=0; i < qualification.length; i++) {
				
				Competence q = im.getCompetence(Integer.parseInt(qualification[i]));
				inte.addQualification(q);
			}
		}
		
		im.save(inte);
		
		response.sendRedirect("/Odecca4/app/interimaire?action=view&recordid="+inte.getId());
	}

}
