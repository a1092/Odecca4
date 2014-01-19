package fr.efrei.Mission;

import java.util.List;

import javax.persistence.EntityTransaction;

import fr.efrei.Account.Account;
import fr.efrei.Interimaire.Competence;
import fr.efrei.Interimaire.Interimaire;
import fr.efrei.System.Bean;

public class MissionManager extends Bean {

	public List<Mission> getAllMission() throws Exception {
		return em.createNamedQuery("Mission.findAll", Mission.class).getResultList();
	}
	
	public Mission getMissionById(int id) {
		return em.createNamedQuery("Mission.findById", Mission.class).setParameter("missionid", id).getSingleResult();
	}
	
	public void remove(Mission m) {
		
		EntityTransaction tx = em.getTransaction();
        tx.begin();
       
		em.remove(m);
		
		tx.commit();
	}
	
	public List<Competence> getAllCompetences() throws Exception {
		return em.createNamedQuery("Competence.findAll", Competence.class).getResultList();
	}
	
	public List<Account> getAllAccount() throws Exception {
		return em.createNamedQuery("Account.findAll", Account.class).getResultList();
	}
	
	public Competence getCompetence(int competenceid) {
		return em.createNamedQuery("Competence.findById", Competence.class).setParameter("competenceid", competenceid).getSingleResult();
	}
	
	public void save(Mission m) {
		
		EntityTransaction tx = em.getTransaction();
        tx.begin();
        
        if(m.getId() == 0)
			em.persist(m);
		else
			em.merge(m);
        
        tx.commit();
	}
	
	public Secteur getSecteurById(int id) {
		return em.createNamedQuery("Secteur.findById", Secteur.class).setParameter("secteurid", id).getSingleResult();
	}
	
	public List<Secteur> getAllSecteur() throws Exception {
		return em.createNamedQuery("Secteur.findAll", Secteur.class).getResultList();
	}
}
