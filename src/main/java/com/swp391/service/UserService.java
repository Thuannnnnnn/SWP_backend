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
	public Users getUserById(Integer user_id) {
		
		return ur.findByUserId(user_id);
	}
	public Users createUser(Users user) {
		return ur.save(user);
	}
	public Users update(Integer user_id, Users updateUser) {
		Users UserExiting = ur.findByUserId(user_id);
			if(UserExiting != null) {
				UserExiting.setFull_name(updateUser.getFull_name());
				UserExiting.setBirth_date(updateUser.getBirth_date());
				UserExiting.setEmail(updateUser.getEmail());
				UserExiting.setPhone_number(updateUser.getPhone_number());
				UserExiting.setPasswords(updateUser.getPasswords());
				UserExiting.setUser_role(updateUser.getUser_role());
				
				return ur.save(UserExiting);
			}
		 return null;
	}
	
	public void deleteUser(Integer user_id) {
		ur.deleteByUserId(user_id);
	}
}
