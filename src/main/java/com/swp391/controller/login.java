package com.swp391.controller;
import java.util.Map;

import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class login {
	@GetMapping("/signgoogle")
	public Map<String, Object> currentUser(OAuth2AuthenticationToken oAthenticationToken){	
		System.out.println(toPerson(oAthenticationToken.getPrincipal().getAttributes()).getEmail());
		System.out.println(toPerson(oAthenticationToken.getPrincipal().getAttributes()).getPicture());
		System.out.println(toPerson(oAthenticationToken.getPrincipal().getAttributes()).getName());
		return oAthenticationToken.getPrincipal().getAttributes();		
	}
		
	public Root toPerson(Map<String, Object> map) {
		if(map==null) {		
			return null;
		}
		Root root = new Root();
		
		root.setEmail((String) map.get("email"));
		root.setName((String) map.get("name"));
		root.setPicture((String) map.get("picture"));
		return root;

		
		
	}
}
