package com.wipro.service;

import java.util.List;

import com.wipro.dto.FlightDto;
import com.wipro.model.Flight;

public interface FlightService {

	List<FlightDto> findFlightBySourceAndDestination(String from, String to);

	Flight getFlightById(Long id);

	List<FlightDto> getAllFlights();

	void addFlight(Flight flight);

	void updateFlight(Flight flight);

	void deleteFlight(Long id);

}
