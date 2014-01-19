package fr.efrei.Mission;

import java.util.List;

import javax.persistence.EntityTransaction;

import fr.efrei.System.Bean;

public class SecteurManager extends Bean {
	
	public void save(Secteur sect) {
		
		EntityTransaction tx = em.getTransaction();
        tx.begin();
        
        if(sect.getId() == 0)
			em.persist(sect);
		else
			em.merge(sect);
        
        tx.commit();
	}
	
	public void remove(Secteur sect) {
		
		EntityTransaction tx = em.getTransaction();
        tx.begin();
       
		em.remove(sect);
		
		tx.commit();
	}
	
	public Secteur getSecteurById(int id) {
		return em.createNamedQuery("Secteur.findById", Secteur.class).setParameter("secteurid", id).getSingleResult();
	}
	
	@SuppressWarnings("unchecked")
	public List<Secteur> getAllSecteur() throws Exception {
		return em.createNamedQuery("Secteur.findAll").getResultList();
	}
}
