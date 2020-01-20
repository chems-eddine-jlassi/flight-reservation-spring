package com.shamsi.flightreservation.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.shamsi.flightreservation.dto.ReservationRequest;
import com.shamsi.flightreservation.entities.Flight;
import com.shamsi.flightreservation.entities.Reservation;
import com.shamsi.flightreservation.repos.FlightRepository;
import com.shamsi.flightreservation.services.ReservationService;

@Controller
public class ReservationController {

	@Autowired
	FlightRepository flightRepository;
	@Autowired
	ReservationService reservationService ;
	private static final Logger LOGGER = LoggerFactory.getLogger(ReservationController.class);
	
	@RequestMapping("/showCompleteReservation")
	public String showCompleteReservation(@RequestParam("flightid") Long flightid, ModelMap modelMap) {
		LOGGER.info("Inside showCompleteReservation() with flightId: "+flightid);
		Flight flight = flightRepository.findById(flightid).get();
		LOGGER.info("Inside showCompleteReservation() and flight is: "+flight);
		modelMap.addAttribute("flight", flight);
		return "CompleteReservation";
	}

	@RequestMapping(value = "/completeReservation", method = RequestMethod.POST)
	public String completeReservation(ReservationRequest request, ModelMap modelMap) {
		LOGGER.info("Inside completeReservation() with Reservation Request: "+ request);
        Reservation reservation= reservationService.bookFlight(request);
        modelMap.addAttribute("msg","Resrvation created sucessfully and the id is " + reservation.getId() );         
		return "reservationConfirmation";
	}

}
