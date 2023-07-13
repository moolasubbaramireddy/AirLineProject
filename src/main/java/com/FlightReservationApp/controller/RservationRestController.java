package com.FlightReservationApp.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.FlightReservationApp.dto.ReservationUpdateRequest;
import com.FlightReservationApp.entity.Reservation;
import com.FlightReservationApp.repository.ReservationRepository;

@RestController
public class RservationRestController {
	
	@Autowired
	private ReservationRepository reservationRepo;
	
	@RequestMapping("/reservation/{id}")
	public Reservation  findReservation(@PathVariable("id") long id) {
		Optional<Reservation> findById = reservationRepo.findById(id);
		Reservation reservation = findById.get();
		return reservation;
	}
	
	@RequestMapping("/reservation")
	public Reservation updateServation(@RequestBody ReservationUpdateRequest request) {
		Optional<Reservation> findById = reservationRepo.findById(request.getId());
		Reservation reservation = findById.get();
		reservation.setCheckedIn(request.isCheckedIn());
		reservation.setNumberOfBags(request.getNumberOfBags());
		Reservation reservation2 = reservationRepo.save(reservation);
		return reservation2;
	}

}
