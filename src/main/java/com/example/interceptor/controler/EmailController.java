/**
 * 
 */
package com.example.interceptor.controler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.interceptor.service.EmailService;

/**
 * @author Aqeel
 *
 */

@RestController("/email")
public class EmailController {
	
	Logger logger = LoggerFactory.getLogger(EmailController.class);
	
	@Autowired
	private EmailService emailService;
	
	@GetMapping("/sendEmail")
	public ResponseEntity<String> sendEmail() {
		logger.info(">>> sendEmail() >> EmailController");
		
		String emailResponse = emailService.sendEmail();
		
		return ResponseEntity.status(HttpStatus.OK).body(emailResponse);
	}

}
