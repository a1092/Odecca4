package fr.efrei.Account;

import java.util.List;

import javax.persistence.EntityTransaction;

import fr.efrei.System.Bean;

public class AccountManager extends Bean {
	
	public void save(Account acc) {
		
		EntityTransaction tx = em.getTransaction();
        tx.begin();
        
        if(acc.getId() == 0)
			em.persist(acc);
		else
			em.merge(acc);
        
        tx.commit();
	}
	
	public void remove(Account acc) {
		
		EntityTransaction tx = em.getTransaction();
        tx.begin();
       
		em.remove(acc);
		
		tx.commit();
	}
	
	public Account getAccountById(int id) {
		return em.createNamedQuery("Account.findById", Account.class).setParameter("accountid", id).getSingleResult();
	}
	
	@SuppressWarnings("unchecked")
	public List<Account> getAllAccount() throws Exception {
		return em.createNamedQuery("Account.findAll").getResultList();
	}
	
	
}
