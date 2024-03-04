package com.wipro.model;

import jakarta.persistence.Entity;
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
public class Ticket {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@ToString.Exclude
	@EqualsAndHashCode.Exclude
	@OneToOne
	@JoinColumn(name = "flight_id")
	private Flight flight;
	@ToString.Exclude
	@EqualsAndHashCode.Exclude
	@OneToOne
	@JoinColumn(name = "passenger_id")
	private Passenger passenger;
}
