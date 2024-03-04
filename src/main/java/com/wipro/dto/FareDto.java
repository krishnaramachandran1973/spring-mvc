package com.wipro.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder

public class FareDto {
	private Long id;
	private double amount;
	private String currency;
}
