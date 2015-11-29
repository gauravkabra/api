package com.shadow.dao.impl;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.shadow.dao.LoginDao;
import com.shadow.entity.User;

@Repository
public class LoginDaoImpl implements LoginDao {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public User getUser(String userName) {
		try {
			EntityManagerFactory emf = Persistence
					.createEntityManagerFactory("shadow");
			entityManager = emf.createEntityManager();
			User singleResult = (User) entityManager
					.createQuery("Select u from User u where u.userName=:user",
							User.class).setParameter("user", userName)
					.getSingleResult();
			entityManager.close();
			return singleResult;
		} catch (Exception e) {
			return null;
		}
	}

	@Override
	public String saveUser(User user) {
		EntityManagerFactory emf = Persistence
				.createEntityManagerFactory("shadow");
		entityManager = emf.createEntityManager();
		entityManager.getTransaction().begin();
		entityManager.persist(user);
		entityManager.flush();
		entityManager.getTransaction().commit();

		entityManager.close();
		return user.getUserName();

	}

}
