package com.swp391.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.swp391.model.Users;
import com.swp391.repository.UsersRepository;
import java.util.List;

@Service
@Transactional
public class UserService {
	@Autowired
	private UsersRepository ur;
	
	public List<Users> getAllUsers() {
		return ur.findAll();

	}

	public Users getUserByEmail(String email) {

		return ur.findByEmail(email);
	}

	public boolean isEmailExists(String email) {
		
		return ur.findByEmail(email) != null;
	}

}
