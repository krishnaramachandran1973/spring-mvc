package com.wipro.service;

import java.time.LocalDateTime;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.wipro.model.Fare;
import com.wipro.model.Flight;
import com.wipro.model.FlightType;

import jakarta.annotation.PostConstruct;

@Service
public class DataGenerationService {

	@Autowired
	private FlightService flightService;

	@Autowired
	private FareService fareService;

	@PostConstruct
	@Transactional
	public void generateData() {

		if (flightService.getAllFlights()
				.isEmpty()) {
			generateFares();

		}
	}

	private void generateFares() {
		// Generate and save fares
		for (int i = 0; i < 10; i++) {
			Fare fare = new Fare();
			double randomValue = 150 + (150 - 100) * new Random().nextDouble();
			fare.setAmount(Math.round(randomValue * 100.0) / 100.0);
			fare.setCurrency("INR"); // Or any other currency
			fareService.addFare(fare);
			generateFlights(fare, i);
		}
	}

	private void generateFlights(Fare fare, int i) {
		// Generate and save flights
		Flight flight = new Flight();
		flight.setFlightNumber("FL" + String.format("%03d", i + 1));
		flight.setDepartureAirport("Airport" + (i + 1));
		flight.setDestinationAirport("Airport" + (i + 2));
		flight.setDepartureTime(LocalDateTime.now());
		flight.setArrivalTime(LocalDateTime.now());
		flight.setAvailableSeats(new Random().nextInt(200));
		flight.setFare(fare); // Assuming 10 fares
		flight.setType(FlightType.DOMESTIC);
		flightService.addFlight(flight);
	}
}
