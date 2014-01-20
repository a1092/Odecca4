package fr.efrei.Mission;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.JoinType;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

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
	
	public List<Mission> getMissionByStatut(String statut) {
		return em.createNamedQuery("Mission.findByStatut", Mission.class).setParameter("statut", statut).getResultList();
	}
	
public void remove(Mission m) {
		
		EntityTransaction tx = em.getTransaction();
        tx.begin();
       
		em.remove(m);
		
		tx.commit();
	}

	public void remove(Postulation m) {
		
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

	public void save(Postulation p) {
		
		EntityTransaction tx = em.getTransaction();
	    tx.begin();
	    
	    if(p.getId() == 0)
			em.persist(p);
		else
			em.merge(p);
	    
	    tx.commit();
	}
	
	public Secteur getSecteurById(int id) {
		return em.createNamedQuery("Secteur.findById", Secteur.class).setParameter("secteurid", id).getSingleResult();
	}
	
	public List<Secteur> getAllSecteur() throws Exception {
		return em.createNamedQuery("Secteur.findAll", Secteur.class).getResultList();
	}
	
	public Account getAccountById(int id) {
		return em.createNamedQuery("Account.findById", Account.class).setParameter("accountid", id).getSingleResult();
	}
	
	public Interimaire getInterimaireById(int id) {
		return em.createNamedQuery("Interimaire.findById", Interimaire.class).setParameter("interimaireid", id).getSingleResult();
	}
	
	public Postulation getPostulationByMissionInterimaire(Mission m, Interimaire i) {
		
		return em.createNamedQuery("Postulation.findByMissionInterimaire", Postulation.class).setParameter("interimaire", i).setParameter("mission", m).getSingleResult();
	}
	
	
	public List<Postulation> getPostulationByMission(Mission m) {
		return em.createNamedQuery("Postulation.findByMission", Postulation.class).setParameter("mission", m).getResultList();
	}
	
	public List<Postulation> getPostulationByStatutInterimaire(String statut, Interimaire i) {
		
		return em.createNamedQuery("Postulation.findByStatutInterimaire", Postulation.class).setParameter("interimaire", i).setParameter("statut", statut).getResultList();
	}
	
	public List<Mission> getPostulation(int userid) {
	
		
		
		CriteriaBuilder builder = em.getCriteriaBuilder();
	    CriteriaQuery<Mission> query = builder.createQuery(Mission.class);
	    
	    
		Root<Mission> fromMission = query.from(Mission.class);
		
		try {
		Join<Mission, Postulation> postulation = fromMission.join("postulations", JoinType.INNER);
		
		} catch(Exception e) {
			System.out.println(e);
		}
		
		
		List<Predicate> conditions = new ArrayList();
		conditions.add(builder.equal(fromMission.get("statut"), "En cours"));
		
		
		TypedQuery<Mission> typedQuery = em.createQuery(query
		        .select(fromMission)
		       .where(conditions.toArray(new Predicate[] {}))
		        //.orderBy(builder.asc(fromMission.get("statut")))
		       // .distinct(true)
		);
		
		return typedQuery.getResultList();
		
	}
}
