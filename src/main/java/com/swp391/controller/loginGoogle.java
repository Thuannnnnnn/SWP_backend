package com.swp391.controller;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.swp391.model.Users;
import com.swp391.service.UserService;
@RestController
@RequestMapping("/api")
public class loginGoogle {

	@Autowired
	private UserService Us;

	@GetMapping("/signgoogle")
	 public ResponseEntity<Users> currentUser(OAuth2AuthenticationToken oAuthenticationToken) {
        Map<String, Object> attributes = oAuthenticationToken.getPrincipal().getAttributes();

        String email = toPerson(attributes).getEmail();
        System.out.println(email);
 
        if (Us.isEmailExists(email.toLowerCase())) {
        	Users user = Us.getUserByEmail(email);
	        HttpHeaders headers = new HttpHeaders();
	        System.out.println("Logged in successfully");
	        headers.add("message", "Logged in successfully");
	        return ResponseEntity.ok().headers(headers).body(user);
        } else {
        	System.out.println("no Oke");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }
	

	public Root toPerson(Map<String, Object> map) {
		if (map == null) {
			return null;
		}
		Root root = new Root();

		root.setEmail((String) map.get("email"));
		root.setName((String) map.get("name"));
		root.setPicture((String) map.get("picture"));
		return root;

	}
}
