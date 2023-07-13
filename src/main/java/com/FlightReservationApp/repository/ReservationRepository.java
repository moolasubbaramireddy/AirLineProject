package com.FlightReservationApp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.FlightReservationApp.entity.Reservation;

@Repository
public interface ReservationRepository extends JpaRepository<Reservation, Long> {

}
