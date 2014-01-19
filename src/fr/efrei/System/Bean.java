package fr.efrei.System;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Bean {

	protected EntityManagerFactory emf = Persistence.createEntityManagerFactory("odecca");
	protected EntityManager em = emf.createEntityManager();
}
