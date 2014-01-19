package fr.efrei.Security;

import java.util.List;

import fr.efrei.System.Bean;

public class UserManager extends Bean {
	
	 
	public User authenticate(String login, String password) throws Exception {
    	
		System.out.println("Authenticate ("+login+", "+password+")");
		System.out.println(em);
		
		List<User> user = em.createNamedQuery("User.Authenticate", User.class)
				.setParameter("login", login)
				.setParameter("password", password)
				.getResultList();

		
		if(user.size() == 0) {
			throw new Exception("Bad credentials");
		} else if(user.size() > 1) {
			throw new Exception("More than one user");
		}
		
		return user.get(0);
    }
}
