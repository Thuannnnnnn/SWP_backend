package com.swp391.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.swp391.model.Users;
import com.swp391.service.UserService;
@RestController
@RequestMapping("/api")
public class test {


		@Autowired
		private UserService Us;
	
}
