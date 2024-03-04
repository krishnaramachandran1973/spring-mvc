package com.wipro.mapper;

import java.time.ZoneId;
import java.util.Date;

import com.wipro.dto.FareDto;
import com.wipro.dto.FlightDto;
import com.wipro.model.Flight;

public class DataMapper {
	public static FlightDto toFlightDto(Flight flight) {
		FareDto fareDto = FareDto.builder()
				.amount(flight.getFare()
						.getAmount())
				.currency(flight.getFare()
						.getCurrency())
				.build();
		return FlightDto.builder()
				.flightNumber(flight.getFlightNumber())
				.departureAirport(flight.getDepartureAirport())
				.departureTime(Date.from(flight.getDepartureTime()
						.atZone(ZoneId.systemDefault())
						.toInstant()))
				.arrivalTime(Date.from(flight.getArrivalTime()
						.atZone(ZoneId.systemDefault())
						.toInstant()))
				.destinationAirport(flight.getDestinationAirport())
				.availableSeats(flight.getAvailableSeats())
				.fareDto(fareDto)
				.build();
	}

}
