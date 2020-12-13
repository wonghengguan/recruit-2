package com.carrental.backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.carrental.backend.form.UserForm;
import com.carrental.backend.model.User;
import com.carrental.backend.repository.UserRepository;

import java.util.HashMap;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("api/user")
public class UserController {
	
	@Autowired
	private UserRepository userRepo;
	
	@RequestMapping(value="/login", method = RequestMethod.POST)
	public Object getUser(@RequestBody UserForm form) {
		User user = userRepo.getUserByUsernameAndPassword(form.getUsername(),form.getPassword());

		HashMap<String, String> responseMap = new HashMap<>();

		if (user == null) {
			responseMap.put("ERR", "User not found!");
			return responseMap;
		}
		
		return user;
	}
}
