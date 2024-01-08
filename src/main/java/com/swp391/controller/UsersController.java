package com.swp391.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.swp391.model.*;
import com.swp391.service.*;
import java.util.List;

@RestController
@RequestMapping("/api")
public class UsersController {

	@Autowired
    private UserService Us;

    @GetMapping("/Users")
    public List<Users> getAllStudents() {
        return Us.getAllUsers();
    }
    @GetMapping("/hello")
    public String index() {
		return "hello";
    	
    }
   
}
