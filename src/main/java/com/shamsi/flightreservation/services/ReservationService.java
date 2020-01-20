package com.shamsi.flightreservation.services;

import com.shamsi.flightreservation.dto.ReservationRequest;
import com.shamsi.flightreservation.entities.Reservation;

public interface ReservationService {
	
	
	public Reservation bookFlight(ReservationRequest request);

}
