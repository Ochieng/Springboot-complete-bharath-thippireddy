package com.mohammad.flightcheckin.integration;

import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.mohammad.flightcheckin.integration.dto.Reservation;
import com.mohammad.flightcheckin.integration.dto.ReservationUpdateRequest;

@Component
public class ReservatioinRestClientImpl implements ReservationRestClient {

	private static final String RESERVATION_REST_URL = "https://localhost:8070/flightreservation/reservations/";
	private static final RestTemplate restTemplate = new RestTemplate();
	
	@Override
	public Reservation findReservation(Long id) {
		
		Reservation reservation = restTemplate.getForObject(RESERVATION_REST_URL+id, Reservation.class);
		return reservation;
	}

	@Override
	public Reservation updateReservation(ReservationUpdateRequest request) {
		
		Reservation reservation = restTemplate.postForObject(RESERVATION_REST_URL, request, Reservation.class);
		return reservation;
	}
}
