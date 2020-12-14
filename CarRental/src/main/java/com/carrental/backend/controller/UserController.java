package com.carrental.backend.controller;

import com.carrental.backend.services.UserService;
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
	private UserService userService;
	
	@RequestMapping(value="/login", method = RequestMethod.POST)
	public Object getUser(@RequestBody UserForm form) {
		User user = userService.getUser(form);

		HashMap<String, String> responseMap = new HashMap<>();

		if (user == null) {
			responseMap.put("ERR", "User not found!");
			return responseMap;
		}
		
		return user;
	}
}
