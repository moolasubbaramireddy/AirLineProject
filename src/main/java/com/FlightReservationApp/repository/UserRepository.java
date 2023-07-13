package com.FlightReservationApp.repository;




import org.springframework.data.jpa.repository.JpaRepository;

import com.FlightReservationApp.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {

	 User findByEmail(String emailId);

	// List<User> findByEmail(String emailId);




	

}
