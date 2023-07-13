package com.FlightReservationApp.service;

import com.FlightReservationApp.dto.ReservationRequest;
import com.FlightReservationApp.entity.Reservation;

public interface ReservationService {

	Reservation bookFlight(ReservationRequest request);

}
