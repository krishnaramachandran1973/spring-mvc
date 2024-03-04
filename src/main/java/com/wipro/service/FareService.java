package com.wipro.service;

import java.util.List;

import com.wipro.model.Fare;

public interface FareService {
	Fare getFareById(Long id);

	List<Fare> getAllFares();

	void addFare(Fare fare);

	void updateFare(Fare fare);

	void deleteFare(Long id);
}
