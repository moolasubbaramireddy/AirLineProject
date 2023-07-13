package com.FlightReservationApp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.FlightReservationApp.entity.Passenger;


public interface PassengerRepository extends JpaRepository<Passenger, Long> {

}
