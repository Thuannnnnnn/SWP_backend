package com.swp391.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.swp391.model.Users;
import com.swp391.repository.UsersRepository;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class UserService {
	@Autowired
	private UsersRepository ur;

	public List<Users> getAllUsers() {
		return ur.findAll();

	}

	public boolean save(Users user) {
		return ur.save(user) != null;
	}

	public boolean updateUsers(Integer userId, Users updatedUser) {
		Users existingUser = ur.findById(userId).orElse(null);

		if (existingUser != null) {
			// Cập nhật các trường của người dùng hiện tại với các giá trị mới
			existingUser.setFull_name(updatedUser.getFull_name());
			existingUser.setBirth_date(updatedUser.getBirth_date());
			existingUser.setPhone_number(updatedUser.getPhone_number());
			existingUser.setEmail(updatedUser.getEmail());
			existingUser.setPasswords(updatedUser.getPasswords());
			existingUser.setAddress(updatedUser.getAddress());
			existingUser.setUser_role(updatedUser.getUser_role());

			// Lưu người dùng đã cập nhật
			ur.save(existingUser);

			return true;
		}

		return false;
	}

	@Transactional
	public boolean deleteUserData(Integer id) {
		if (id >= 1) {
			Users users = ur.getById(id);
			if (users != null) {
				ur.deleteById(id);
				return true;
			}
		}

		return false;
	}

	public Optional<Users> showUserById(Integer userId) {
		return ur.findById(userId);
	}

	public Users getUserByEmail(String email) {

		return ur.findByEmail(email);
	}
}
