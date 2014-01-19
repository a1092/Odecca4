package fr.efrei.Interimaire;

import java.util.List;

import javax.persistence.EntityTransaction;

import fr.efrei.System.Bean;

public class CompetenceManager extends Bean {
	
	public void save(Competence comp) {
		
		EntityTransaction tx = em.getTransaction();
        tx.begin();
        
        if(comp.getId() == 0)
			em.persist(comp);
		else
			em.merge(comp);
        
        tx.commit();
	}
	
	public void remove(Competence comp) {
		
		EntityTransaction tx = em.getTransaction();
        tx.begin();
       
		em.remove(comp);
		
		tx.commit();
	}
	
	public Competence getCompetenceById(int id) {
		return em.createNamedQuery("Competence.findById", Competence.class).setParameter("competenceid", id).getSingleResult();
	}
	
	@SuppressWarnings("unchecked")
	public List<Competence> getAllCompetence() throws Exception {
		return em.createNamedQuery("Competence.findAll").getResultList();
	}
}
