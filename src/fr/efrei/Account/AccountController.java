package fr.efrei.Account;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.efrei.Security.UserManager;

/**
 * Servlet implementation class AccountController
 */
public class AccountController extends HttpServlet {
	private static final long serialVersionUID = 1L;
      
	private AccountManager am = new AccountManager();
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AccountController() {
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
				
				request.setAttribute("account", am.getAccountById(recordid));
				
				this.getServletContext().getRequestDispatcher("/modules/Account/ViewAccount.jsp").forward(request, response);
			
			
			}  else if (request.getParameter("action").equals("edit")) {
				
				if(request.getParameter("recordid") == null)
					throw new ServletException("Not record found.");
				int recordid = Integer.parseInt(request.getParameter("recordid"));
				
				Account acc = am.getAccountById(recordid);
				
				
				request.setAttribute("account", am.getAccountById(recordid));
				this.getServletContext().getRequestDispatcher("/modules/Account/EditAccount.jsp").forward(request, response);
				
			}  else if (request.getParameter("action").equals("new")) {
				request.setAttribute("account", new Account());
				this.getServletContext().getRequestDispatcher("/modules/Account/EditAccount.jsp").forward(request, response);
			}  else if (request.getParameter("action").equals("delete")) {
				
				if(request.getParameter("recordid") == null)
					throw new ServletException("Not record found.");
				
				int recordid = Integer.parseInt(request.getParameter("recordid"));
				
				am.remove(am.getAccountById(recordid));
				
				response.sendRedirect("/Odecca4/app/account");
			}
		}
		
		else {
			try {
				request.setAttribute("accountlist", am.getAllAccount());
			} catch (Exception e) {
				
			}
			
			this.getServletContext().getRequestDispatcher("/modules/Account/ListAccount.jsp").forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


		Account acc = new Account();
		acc.setAdresse(request.getParameter("adresse"));
		acc.setId(Integer.parseInt(request.getParameter("id")));
		acc.setSiret(request.getParameter("siret"));
		acc.setNom(request.getParameter("nom"));
		
		am.save(acc);
		
		response.sendRedirect("/Odecca4/app/account?action=view&recordid="+acc.getId());
	}

}
