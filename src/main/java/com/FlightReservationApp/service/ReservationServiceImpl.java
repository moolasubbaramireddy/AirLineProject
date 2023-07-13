package com.FlightReservationApp.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.FlightReservationApp.dto.ReservationRequest;
import com.FlightReservationApp.entity.Flight;
import com.FlightReservationApp.entity.Passenger;
import com.FlightReservationApp.entity.Reservation;
import com.FlightReservationApp.repository.FlightRepository;
import com.FlightReservationApp.repository.PassengerRepository;
import com.FlightReservationApp.repository.ReservationRepository;
import com.FlightReservationApp.utilities.EmailUtil;
import com.FlightReservationApp.utilities.PDFGenerator;

@Service
public class ReservationServiceImpl implements ReservationService {

	@Autowired
	private ReservationRepository reservationRepo;
	
	@Autowired
	private PassengerRepository passengerRepo;
	
	@Autowired
	private FlightRepository flightRepo;
	
	@Autowired
	private PDFGenerator pdfGenerator;
	
	@Autowired
	private EmailUtil emailUtil;
	
	@Override
	public Reservation bookFlight(ReservationRequest request) {
		
		
	
		Passenger passenger=new Passenger();
		passenger.setFirstName(request.getFirstName());
		passenger.setLastName(request.getLastName());
		passenger.setMiddleName(request.getMiddleName());
		passenger.setEmail(request.getEmail());
		passenger.setPhone(request.getPhone());
		passengerRepo.save(passenger);
		
		long flightId = request.getFlightId();
		Optional<Flight> findById = flightRepo.findById(flightId);
		Flight flight = findById.get();
		
		Reservation reservation=new Reservation();
		reservation.setFlight(flight);
		reservation.setPassenger(passenger);
		reservation.setCheckedIn(false);
		reservation.setNumberOfBags(0);
		
		reservationRepo.save(reservation);
		
		String filePath="E:\\SpringBoot_Pratice\\FlightReservationApp\\tickets\\reservation"+reservation.getId()+".pdf";
		
		pdfGenerator.generateItinerary(reservation,filePath);
		emailUtil.sendItinerary(passenger.getEmail(), filePath);
		return reservation;
		
	}

}
