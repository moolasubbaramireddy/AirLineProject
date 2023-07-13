package com.FlightReservationApp.utilities;

import java.io.File;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

@Component
public class EmailUtil {

	@Autowired
	private JavaMailSender sender;
	
	public void sendItinerary(String toAddress, String filePath) {
		MimeMessage message=sender.createMimeMessage();
		try {
			MimeMessageHelper mimeMessageHelper=new MimeMessageHelper(message,true);
			mimeMessageHelper.setTo(toAddress);
			mimeMessageHelper.setSubject("Itinerary of flight");
			mimeMessageHelper.setText("Please find the attech");
			mimeMessageHelper.addAttachment("Itinarery", new File(filePath));
			sender.send(message);
		} catch (MessagingException e) {
			e.printStackTrace();
		}
		
	}
	
}
