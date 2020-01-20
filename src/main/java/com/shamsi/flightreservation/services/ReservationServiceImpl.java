package com.shamsi.flightreservation.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.shamsi.flightreservation.dto.ReservationRequest;
import com.shamsi.flightreservation.entities.Flight;
import com.shamsi.flightreservation.entities.Passenger;
import com.shamsi.flightreservation.entities.Reservation;
import com.shamsi.flightreservation.repos.FlightRepository;
import com.shamsi.flightreservation.repos.PassengerRepository;
import com.shamsi.flightreservation.repos.ReservationRepository;
import com.shamsi.flightreservation.util.EmailUtil;
import com.shamsi.flightreservation.util.PDFGenerator;

@Service

public class ReservationServiceImpl implements ReservationService {

	@Autowired
	FlightRepository flightRepository;
	@Autowired
	PassengerRepository passengerRepository;
	@Autowired
	ReservationRepository reservationRepository;
	@Autowired
	PDFGenerator pdfGenerator;
	@Autowired
	EmailUtil emailUtil;
	private static final Logger LOGGER = LoggerFactory.getLogger(ReservationServiceImpl.class);
	@Override
	public Reservation bookFlight(ReservationRequest request) {
		LOGGER.info("Inside bookFlight()");
		Long flightid= request.getFlightid();
		LOGGER.info("Fetching Flight for FlightId: "+flightid);
		Flight flight = flightRepository.findById( flightid).get();
		Passenger passenger = new Passenger();
		passenger.setFirstName(request.getPassengerFirstName());
		passenger.setLastName(request.getPassengerLastName());
		passenger.setPhone(request.getPassengerPhone());
		passenger.setEmail(request.getPassengerEmail());
		LOGGER.info("Saving the Passenger: "+passenger);
		Passenger savedPassenger = passengerRepository.save(passenger);
		Reservation reservation = new Reservation();
		reservation.setFlight(flight);
		reservation.setPassenger(savedPassenger);
		reservation.setCheckedIn(false);
		LOGGER.info("Saving the reservation: "+reservation);
		Reservation savedReservation = reservationRepository.save(reservation);
		LOGGER.info("Generating the PDF for Itinerary ");
		String filePath = "C:/Users/pc/Documents/reservations/reservation"+savedReservation.getId()+".pdf";
		LOGGER.info("saving the PDF");
		pdfGenerator.generateItinerary(savedReservation, filePath);
		LOGGER.info("Emailing the Itinerary");
		emailUtil.sendItinerary(passenger.getEmail(), filePath);	
		return savedReservation;
	}

}
