package com.fdmgroup.daoImpl;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import com.fdmgroup.dao.IScreenDao;
import com.fdmgroup.model.Screen;
import com.fdmgroup.model.Theatre;

public class ScreenDaoImpl implements IScreenDao {

	private DbConnection connection = null;

	public ScreenDaoImpl() {
		super();
		connection = DbConnection.getInstance();
	}
	
	@Override
	public void create(Screen t) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Screen readById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Screen> readAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean delete(Screen t) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(Screen t) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<Theatre> findTheatresByMovieId(int movieId) {
		EntityManager em = connection.getEntityManager();
		TypedQuery<Theatre> query = (TypedQuery<Theatre>) em.createNamedQuery("screen.findTheatresByMovieId");
		query.setParameter("movie_id", movieId);
		List<Theatre> theatres = query.getResultList();
		em.close();
		
		return theatres;
	}

	@Override
	public Screen findScreenByMovieId(int movieId, int theatreId) {
		EntityManager em = connection.getEntityManager();
		TypedQuery<Screen> query = em.createNamedQuery("screen.findScreenByMovieIdAndTheatreId", Screen.class);
		query.setParameter("theatre_id", theatreId);
		query.setParameter("movie_id", movieId);
		Screen screenFound = query.getSingleResult();
		em.close();
		return screenFound;
	}

}
