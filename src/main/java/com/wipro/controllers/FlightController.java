package com.wipro.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.wipro.controllers.form.SearchForm;
import com.wipro.dto.FlightDto;
import com.wipro.service.FlightService;

import jakarta.validation.Valid;

@Controller
public class FlightController {
	private FlightService flightService;

	@Autowired
	public FlightController(FlightService flightService) {
		this.flightService = flightService;
	}

	@RequestMapping(path = "home", method = RequestMethod.GET)
	public String home(Model model) {
		List<FlightDto> allFlights = this.flightService.getAllFlights();
		model.addAttribute("flights", allFlights);
		return "flight_list";
	}

	@PostMapping("search")
	public String flightSearch(@Valid SearchForm form, BindingResult result, Model model,
			RedirectAttributes redirectAttributes) {
		if (result.hasErrors()) {
			redirectAttributes.addFlashAttribute("errorMessage", "Error in submitted form");
			return "redirect:/home";
		}
		List<FlightDto> flights = this.flightService.findFlightBySourceAndDestination(form.getFrom(), form.getTo());
		model.addAttribute("flights", flights);
		return "flight_list";
	}

}
