package com.fdmgroup.daoImpl;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class DbConnection {

	private static final String PERSISTENCE_NAME = "MovieBookingWeb";
	private static DbConnection connection = null;
	private EntityManagerFactory emf = null;
	
	private DbConnection() {
		init();
	}

	private void init() {
		if (emf == null || !emf.isOpen()) {
			emf = Persistence.createEntityManagerFactory(PERSISTENCE_NAME);
		}
	}

	public static DbConnection getInstance() {
		if (connection == null) {
			connection = new DbConnection();
		}
		
		return connection;
	}
	
	public EntityManager getEntityManager() {
		init();
		return emf.createEntityManager();
	}
	
	public void closeEmf() {
		if (emf != null && emf.isOpen()) {
			emf.close();
		}
	}
}



















