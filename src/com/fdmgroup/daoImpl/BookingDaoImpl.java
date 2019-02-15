package com.fdmgroup.daoImpl;

import java.util.List;
import javax.persistence.EntityManager;
import com.fdmgroup.dao.IBookingDao;
import com.fdmgroup.model.Booking;

public class BookingDaoImpl implements IBookingDao {

	private DbConnection connection = null;
	
	public BookingDaoImpl() {
		super();
		this.connection =  DbConnection.getInstance();
	}

	@Override
	public void create(Booking t) {
		EntityManager em = connection.getEntityManager();
		em.getTransaction().begin();
		em.persist(t);
		em.getTransaction().commit();
		em.close();
	}

	@Override
	public Booking readById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Booking> readAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean delete(Booking t) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(Booking t) {
		// TODO Auto-generated method stub
		return false;
	}

}
