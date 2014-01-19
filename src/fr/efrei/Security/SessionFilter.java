package fr.efrei.Security;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class SessionFilter implements Filter {

	public void doFilter(ServletRequest req, ServletResponse res,
            FilterChain chain) throws IOException, ServletException {
 
        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) res;
        
        HttpSession session = request.getSession(false);
       
        if (session == null || session.getAttribute("user") == null) {
           
        	System.out.println("Not authenticated.");
        	response.sendRedirect("/Odecca4/login");
        	return;
        }
        
        chain.doFilter(req, res);
    }
    public void init(FilterConfig config) throws ServletException {
         
    }
    public void destroy() {
        //add code to release any resource
    }
}