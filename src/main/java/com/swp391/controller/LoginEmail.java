package com.swp391.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.swp391.model.Users;
import com.swp391.service.JwtService;
import com.swp391.service.md5;
import com.swp391.service.UserService;
@RestController
@RequestMapping("/api")

public class LoginEmail {
	@Autowired
	private UserService Us;
	@Autowired
	private md5 md5;
	 @Autowired
	    private JwtService jwtService;
	 @PostMapping("/signIn")
	 public ResponseEntity<Object> LoginEmail(@RequestBody LoginRequest loginRequest) {
		 
		    String email = loginRequest.getEmail();
		    String password = loginRequest.getPassword();
		    System.out.println(email);
	     if(Us.getUserByEmail(email) != null) {
	         if(md5.getMD5(password,Us.getUserByEmail(email).getPasswords())) { 
	             Users user = Us.getUserByEmail(email);
	             String token = jwtService.generateToken(user.getEmail());
	             HttpHeaders headers = new HttpHeaders();
	            
	             headers.add(HttpHeaders.AUTHORIZATION, "Bearer " + token);
	             headers.add("message", "Logged in successfully");
	             return ResponseEntity.ok().headers(headers).body(user);
	         } else {
	             System.out.println(Us.getUserByEmail(email).getPasswords());
	             System.out.println(password);
	             return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
	                           .header("message", "Wrong password")
	                           .build();
	         }
	     
	     } else {  
	         
	         return ResponseEntity.status(HttpStatus.NOT_FOUND)
	                             .header("message", "Email does not exist")
	                             .build();
	     }
	 }
	 static class LoginRequest {
		    private String email;
		    private String password;
			public String getEmail() {
				return email;
			}
			public void setEmail(String email) {
				this.email = email;
			}
			public String getPassword() {
				return password;
			}
			public void setPassword(String password) {
				this.password = password;
			}

		    
		}

	@GetMapping("/Users")
	public List<Users> listU() {
		List<Users> c = Us.getAllUsers();
		return c;
	}
	@GetMapping("/Users1")
	public List<Users> lista() {
		List<Users> c = Us.getAllUsers();
		return c;
	}
	@GetMapping("/Users2")
	public List<Users> listb() {
		List<Users> c = Us.getAllUsers();
		return c;
	}
	@GetMapping("/Users3")
	public List<Users> listc() {
		List<Users> c = Us.getAllUsers();
		return c;
	}
	@GetMapping("/Users4")
	public List<Users> listd() {
		List<Users> c = Us.getAllUsers();
		return c;
	}
}
