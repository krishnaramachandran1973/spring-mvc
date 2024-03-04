package com.wipro.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.wipro.model.Fare;
import com.wipro.service.FareService;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;

@Service
public class FareServiceImpl implements FareService {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public Fare getFareById(Long id) {
		return entityManager.find(Fare.class, id);
	}

	@Override
	public List<Fare> getAllFares() {
		TypedQuery<Fare> query = entityManager.createQuery("SELECT f FROM Fare f", Fare.class);
		return query.getResultList();
	}

	@Override
	@Transactional
	public void addFare(Fare fare) {
		entityManager.persist(fare);
	}

	@Override
	@Transactional
	public void updateFare(Fare fare) {
		entityManager.merge(fare);
	}

	@Override
	@Transactional
	public void deleteFare(Long id) {
		Fare fare = entityManager.find(Fare.class, id);
		if (fare != null) {
			entityManager.remove(fare);
		}
	}
}
