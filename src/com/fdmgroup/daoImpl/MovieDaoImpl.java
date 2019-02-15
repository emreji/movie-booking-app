package com.fdmgroup.daoImpl;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import com.fdmgroup.dao.IMovieDao;
import com.fdmgroup.model.Movie;

public class MovieDaoImpl implements IMovieDao {

	private DbConnection connection = null;

	public MovieDaoImpl() {
		super();
		connection = DbConnection.getInstance();
	}

	@Override
	public void create(Movie t) {
		EntityManager em = connection.getEntityManager();
		em.getTransaction().begin();
		em.persist(t);
		em.getTransaction().commit();
		em.close();
	}

	@Override
	public Movie readById(int id) {
		EntityManager em = connection.getEntityManager();
		Movie foundMovie = em.find(Movie.class, id);
		em.close();
		return foundMovie;
	}

	@Override
	public List<Movie> readAll() {
		EntityManager em = connection.getEntityManager();
		TypedQuery<Movie> query = em.createNamedQuery("mov.findAll", Movie.class);
		List<Movie> movies = query.getResultList();
		em.close();
		
		return movies;
	}

	@Override
	public boolean delete(Movie t) {
		return false;
	}

	@Override
	public boolean update(Movie t) {
		return false;
	}

	@Override
	public Movie findMovieByName(String movieName) {
		EntityManager em = connection.getEntityManager();
		TypedQuery<Movie> query = em.createNamedQuery("mov.findByName", Movie.class);
		query.setParameter("name", movieName);
		Movie movie = query.getSingleResult();
		em.close();
		
		return movie;
	}

	@Override
	public List<Movie> findMoviesByGenre(String genre) {
		return null;
	}

	@Override
	public List<Movie> searchMovieByNameOrGenre(String searchInput) {
		EntityManager em = connection.getEntityManager();
		TypedQuery<Movie> query = em.createNamedQuery("mov.searchByNameOrGenre", Movie.class);
		searchInput = searchInput.toUpperCase();
		query.setParameter("name", searchInput + "%");
		List<Movie> movies = query.getResultList();
		em.close();
		
		return movies;
	}

}
