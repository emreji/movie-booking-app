package com.fdmgroup.daoImpl;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import com.fdmgroup.dao.ITheatreDao;
import com.fdmgroup.model.Theatre;

public class TheatreDaoImpl implements ITheatreDao {

	private DbConnection connection = null;

	public TheatreDaoImpl() {
		super();
		connection = DbConnection.getInstance();
	}
	
	@Override
	public void create(Theatre t) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Theatre readById(int id) {
		EntityManager em = connection.getEntityManager();
		Theatre foundTheatre = em.find(Theatre.class, id);
		em.close();
		return foundTheatre;
	}

	@Override
	public List<Theatre> readAll() {
		EntityManager em = connection.getEntityManager();
		TypedQuery<Theatre> query = em.createNamedQuery("th.findAll", Theatre.class);
		List<Theatre> theatres = query.getResultList();
		em.close();
		
		return theatres;
	}

	@Override
	public boolean delete(Theatre t) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(Theatre t) {
		// TODO Auto-generated method stub
		return false;
	}
	
}
