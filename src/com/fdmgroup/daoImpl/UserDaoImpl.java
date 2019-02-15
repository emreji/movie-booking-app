package com.fdmgroup.daoImpl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import com.fdmgroup.dao.IUserDao;
import com.fdmgroup.model.MBUser;

public class UserDaoImpl implements IUserDao {

	private DbConnection connection = null;
	
	public UserDaoImpl() {
		super();
		connection = DbConnection.getInstance();
	}

	@Override
	public void create(MBUser t) {
		EntityManager em = connection.getEntityManager();
		em.getTransaction().begin();
		em.persist(t);
		em.getTransaction().commit();
		em.close();
	}

	@Override
	public MBUser readById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<MBUser> readAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean delete(MBUser t) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(MBUser t) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public MBUser readByUsername(String username) {
		EntityManager em = connection.getEntityManager();
		TypedQuery<MBUser> query = em.createNamedQuery("user.findByUsername", MBUser.class);
		query.setParameter("username", username);
		List<MBUser> users = query.getResultList();
		em.close();
		if (users != null && users.size() == 1) {
			return users.get(0);
		}
		
		return null;
	}

}
