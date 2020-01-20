package com.shamsi.flightreservation.controllers;



import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.shamsi.flightreservation.dto.ReservationUpdateRequest;
import com.shamsi.flightreservation.entities.Reservation;
 
import com.shamsi.flightreservation.repos.ReservationRepository;

@RestController

public class ReservationRestController {
	
	@Autowired
	ReservationRepository reservationRepository;
 
	private static final Logger LOGGER = LoggerFactory.getLogger(ReservationRestController.class);
	
	@RequestMapping("/reservation/{id}")
	public Reservation findResevation (@PathVariable("id")Long id) {
		LOGGER.info("Inside findReservation() with Id: "+id);
		Reservation reservation = reservationRepository.findById(id).get();
		
		return reservation;
	}
	
	@RequestMapping("/reservations")
	public Reservation updateReservation(@RequestBody ReservationUpdateRequest request) {
		LOGGER.info("Inside updateReservation() for "+request);
		Reservation reservation = reservationRepository.findById(request.getId()).get();
		reservation.setNumberOfBags(request.getNumberOfBags());
		reservation.setCheckedIn(request.getCheckedIn());
		LOGGER.info("Saving the Reservation");
		Reservation reservation2 = reservationRepository.save(reservation);
		return reservation2;
		
	}
	
	
	
	
	
	
	
	
	
	
	
}
