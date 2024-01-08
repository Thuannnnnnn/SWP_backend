package com.swp391.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.swp391.model.Users;
import com.swp391.service.UserService;
@RestController
@RequestMapping("/api")
public class LoginEmail {

	@Autowired
	private UserService Us;

	 @GetMapping("/signIn")
		public ResponseEntity<Object> LoginEmail(String email, String password) {
	    	
			if(Us.getUserByEmail(email) != null) {
				if(Us.getUserByEmail(email).getPasswords().equals(password)) {
				
					Users user = Us.getUserByEmail(email);
			        HttpHeaders headers = new HttpHeaders();
			        headers.add("message", "Logged in successfully");
			        return ResponseEntity.ok().headers(headers).body(user);
				}else {
					
					return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
		                      .header("message", "Wrong password")
		                      .build();
				}
			
			}else {
				
				return ResponseEntity.status(HttpStatus.NOT_FOUND)
						  		.header("message", "Email does not exist")
						  		.build();
			}
		}
	
}
