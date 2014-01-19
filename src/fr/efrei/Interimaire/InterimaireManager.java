package fr.efrei.Interimaire;

import java.util.List;

import javax.persistence.EntityTransaction;

import fr.efrei.Security.User;
import fr.efrei.System.Bean;

public class InterimaireManager extends Bean {
	
public void save(Interimaire interimaire) {
		
		EntityTransaction tx = em.getTransaction();
        tx.begin();
        
        if(interimaire.getId() == 0)
			em.persist(interimaire);
		else
			em.merge(interimaire);
        
        tx.commit();
	}

	public void save(User user) {
		
		EntityTransaction tx = em.getTransaction();
	    tx.begin();
	    
	    if(user.getId() == 0)
			em.persist(user);
		else
			em.merge(user);
	    
	    tx.commit();
	}
	
	public void remove(Interimaire interimaire) {
		
		EntityTransaction tx = em.getTransaction();
        tx.begin();
       
		em.remove(interimaire);
		
		tx.commit();
	}
	
	public Interimaire getInterimaireById(int id) {
		return em.createNamedQuery("Interimaire.findById", Interimaire.class).setParameter("interimaireid", id).getSingleResult();
	}
	

	public List<Interimaire> getAllInterimaire() throws Exception {
		return em.createNamedQuery("Interimaire.findAll", Interimaire.class).getResultList();
	}
	
	public List<Competence> getAllCompetences() throws Exception {
		return em.createNamedQuery("Competence.findAll", Competence.class).getResultList();
	}
	
	public Competence getCompetence(int competenceid) {
		return em.createNamedQuery("Competence.findById", Competence.class).setParameter("competenceid", competenceid).getSingleResult();
	}
	
}
