package com.swp391.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.swp391.model.Users;
import com.swp391.repository.UsersRepository;
import java.util.List;

@Service
public class UserService {
	@Autowired
	private UsersRepository ur;
	public List<Users> getAllUsers(){	
		return ur.findAll();
		
	}
}
