package com.wipro.dto;

import java.util.Date;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class FlightDto {
	private Long id;
	private String flightNumber;
	private String departureAirport;
	private String destinationAirport;
	private Date departureTime;
	private Date arrivalTime;
	private int availableSeats;
	private FareDto fareDto;
}
