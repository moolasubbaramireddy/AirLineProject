package com.FlightReservationApp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.FlightReservationApp.entity.User;
import com.FlightReservationApp.repository.UserRepository;

@Controller
public class UserController {

	@Autowired
	private UserRepository userRepo;

	@RequestMapping("/showLoginPage")
	public String ShowLoginPage() {
		return "login";
	}

	@RequestMapping("/showReg")
	public String ShowReg() {
		return "showReg";
	}

	@RequestMapping("/saveReg")
	public String saveReg(@ModelAttribute("user") User user) {
		userRepo.save(user);
		return "login";
	}

	@RequestMapping("/verifyLogin")
	public String verifyLogin(@RequestParam("emailId") String emailId, @RequestParam("password") String password,
			ModelMap modelMap) {
		User user = userRepo.findByEmail(emailId);
		if (user != null) {
			if (user.getEmail().equals(emailId) && user.getPassword().equals(password)) {
				return "findFlights";

			}else {
				modelMap.addAttribute("error", "username and passwors is invailed");
				return "login";
			}

		} else {
			modelMap.addAttribute("error", "username and passwors is invailed");
			return "login";
		}

	}

}
