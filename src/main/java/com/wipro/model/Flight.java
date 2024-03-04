package com.wipro.model;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Flight {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String flightNumber;
	private String departureAirport;
	private String destinationAirport;
	private LocalDateTime departureTime;
	private LocalDateTime arrivalTime;
	private int availableSeats;
	@ToString.Exclude
	@EqualsAndHashCode.Exclude
	@OneToOne
	@JoinColumn(name = "fare_id")
	private Fare fare;
	@Enumerated(EnumType.STRING)
	private FlightType type;

}
