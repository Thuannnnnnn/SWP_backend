package com.swp391.controller;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

	@GetMapping("/user")
	public ResponseEntity<?> getUserInfo(@AuthenticationPrincipal OAuth2User principal) {
	    if (principal != null) {
	        // Trả về thông tin người dùng
	        return ResponseEntity.ok(principal.getAttributes());
	    } else {
	        // Trả về thông báo lỗi hoặc chuyển hướng
	        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("User not authenticated");
	    }
	}}
