package fr.efrei.Interimaire;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import fr.efrei.Account.Account;

public class InterimTest {
	
	public static void main(String[] args)
    {
		 EntityManagerFactory emf = Persistence.createEntityManagerFactory("odecca");
	/*
		 Interimaire inte = new Interimaire();
	     
		 inte.setEmail("toto@totoland.fr");
		 inte.setFirstname("interim");
		 */
		 
		 Account acc = new Account();
	     
	     acc.setNom("Efrei");
	     acc.setSiret("398-898-338 00023");
	     acc.setAdresse("30 AV DE LA REPUBLIQUE - 94800	  VILLEJUIF");
	     
		 EntityManager em = null;
	     EntityTransaction tx = null;
	     try {
	    	 em = emf.createEntityManager();
	    	 tx = em.getTransaction();
	    	  tx.begin();
	          em.persist(acc);
	          tx.commit();
	     } catch (RuntimeException e) {
	    	 System.out.println(e.getStackTrace());
	         tx.rollback();
	         
	     } finally {
	         if (em != null && em.isOpen()) {
	             em.close();
	         }
	     }
    }
	
     /*
     
     Account acc = new Account();
     
     acc.setName("Efrei");
     acc.setSiret("398-898-338 00023");
     acc.setAddress("30 AV DE LA REPUBLIQUE - 94800	  VILLEJUIF");
     
     Account acc2 = new Account();
     
     acc2.setName("Efrei");
     acc2.setSiret("398-898-338 00023");
     acc2.setAddress("30 AV DE LA REPUBLIQUE - 94800	  VILLEJUIF");
     
     EntityManager em = null;
     EntityTransaction tx = null;
     try {
         em = emf.createEntityManager();
         EntityTransaction tx = em.getTransaction();
         tx.begin();
         em.persist(acc);
         em.persist(acc2);
         tx.commit();

         System.out.println("acc id: " + acc.getId());
         System.out.println("acc2 id: " + acc2.getId());
     } catch (RuntimeException e) {
         tx.rollback();
         throw e;
     } finally {
         if (em != null && em.isOpen()) {
             em.close();
         }
     }
     
     */
}
