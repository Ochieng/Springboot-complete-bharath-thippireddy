package com.mohammad.flightcheckin.integration;

import com.mohammad.flightcheckin.integration.dto.Reservation;
import com.mohammad.flightcheckin.integration.dto.ReservationUpdateRequest;

public interface ReservationRestClient {
	
	public Reservation findReservation(Long id);
	
	public Reservation updateReservation(ReservationUpdateRequest request);

}
