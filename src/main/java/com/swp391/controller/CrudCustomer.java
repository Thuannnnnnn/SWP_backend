package com.swp391.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.swp391.model.Users;
import com.swp391.service.UserService;

@RestController
@RequestMapping("/api")
public class CrudCustomer {

	@Autowired
	private UserService Us;
	
	@PostMapping("/insertUser")
	public void inserUser(@RequestBody Users user) {
		if(Us.save(user)) {
			System.out.println("ok");	
		} else {
			System.out.println("no Oke");
			
			
		}
		
	}
	
	@DeleteMapping("/deleteUser/{userId}")
	public ResponseEntity<String> deleteUser(@PathVariable Integer userId) {
	    if (Us.deleteUserData(userId)) {
	        return new ResponseEntity<>("Người dùng đã được xóa thành công", HttpStatus.OK);
	    } else {
	        return new ResponseEntity<>("Không tìm thấy người dùng hoặc xóa thất bại", HttpStatus.NOT_FOUND);
	    }
	}

	
	@PutMapping("/updateUser/{userId}")
    public ResponseEntity<String> updateUser(@PathVariable Integer userId, @RequestBody Users updatedUser) {
        if (Us.updateUsers(userId, updatedUser)) {
            return new ResponseEntity<>("Người dùng đã được cập nhật thành công", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Không tìm thấy người dùng hoặc cập nhật thất bại", HttpStatus.NOT_FOUND);
        }
    }
		
	@GetMapping("/User/{userId}")
    public ResponseEntity<Users> getUserById(@PathVariable Integer userId) {
        Optional<Users> userOptional = Us.showUserById(userId);

        return userOptional
                .map(user -> new ResponseEntity<>(user, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
	
}