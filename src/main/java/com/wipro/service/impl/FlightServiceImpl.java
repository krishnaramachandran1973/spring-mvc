package com.wipro.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.wipro.dto.FlightDto;
import com.wipro.mapper.DataMapper;
import com.wipro.model.Flight;
import com.wipro.service.FlightService;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;

@Service
public class FlightServiceImpl implements FlightService {

	@PersistenceContext
	private EntityManager entityManager;

	@Transactional
	public void addFlight(Flight flight) {
		entityManager.persist(flight);
	}

	public Flight getFlightById(Long id) {
		return entityManager.find(Flight.class, id);
	}

	public List<FlightDto> getAllFlights() {
		List<Flight> flights = entityManager.createQuery("SELECT f FROM Flight f", Flight.class)
				.getResultList();
		return flights.stream()
				.map(DataMapper::toFlightDto)
				.collect(Collectors.toList());
	}

	@Transactional
	public void updateFlight(Flight flight) {
		entityManager.merge(flight);
	}

	@Transactional
	public void deleteFlight(Long id) {
		Flight flight = entityManager.find(Flight.class, id);
		if (flight != null) {
			entityManager.remove(flight);
		}
	}

	@Override
	public List<FlightDto> findFlightBySourceAndDestination(String from, String to) {
		TypedQuery<Flight> query = entityManager.createQuery(
				"SELECT f FROM Flight f WHERE f.departureAirport = :departureAirport AND f.destinationAirport = :destinationAirport",
				Flight.class);
		query.setParameter("departureAirport", from);
		query.setParameter("destinationAirport", to);
		List<Flight> flights = query.getResultList();
		return flights.stream()
				.map(DataMapper::toFlightDto)
				.collect(Collectors.toList());
	}
}
