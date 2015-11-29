package com.shadow.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.shadow.dao.RequestDao;
import com.shadow.entity.AccountOpeningRequest;

@Repository
public class RequestDaoImpl implements RequestDao {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public AccountOpeningRequest saveRequest(AccountOpeningRequest request) {
		EntityManagerFactory emf = Persistence
				.createEntityManagerFactory("shadow");
		entityManager = emf.createEntityManager();
		entityManager.getTransaction().begin();
		entityManager.persist(request);
		entityManager.flush();
		entityManager.getTransaction().commit();
		entityManager.close();
		return request;
	}

	@Override
	public AccountOpeningRequest updateRequest(AccountOpeningRequest request) {
		EntityManagerFactory emf = Persistence
				.createEntityManagerFactory("shadow");
		entityManager = emf.createEntityManager();
		entityManager.getTransaction().begin();
		entityManager.merge(request);
		entityManager.flush();
		entityManager.getTransaction().commit();
		entityManager.close();
		return request;
	}

	@Override
	public List<AccountOpeningRequest> getAllRequest(String user) {
		EntityManagerFactory emf = Persistence
				.createEntityManagerFactory("shadow");
		entityManager = emf.createEntityManager();
		TypedQuery<AccountOpeningRequest> createQuery = entityManager
				.createQuery("Select r from AccountOpeningRequest r",
						AccountOpeningRequest.class);
		entityManager.close();
		return createQuery.getResultList();
	}

	@Override
	public AccountOpeningRequest getRequestById(Integer requestId) {
		EntityManagerFactory emf = Persistence
				.createEntityManagerFactory("shadow");
		entityManager = emf.createEntityManager();
		AccountOpeningRequest request = entityManager.find(
				AccountOpeningRequest.class, requestId);
		entityManager.close();
		return request;
	}

}
