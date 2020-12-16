package com.carrental.backend.controller;

import com.carrental.backend.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.carrental.backend.form.UserForm;
import com.carrental.backend.model.User;
@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("api/user")
public class UserController {
	
	@Autowired
	private UserService userService;

	@RequestMapping(value="/login", method = RequestMethod.POST)
	public Long login(@RequestBody UserForm form) {
		User user = userService.getUserByUsernameAndPassword(form);

		if (user != null) {
			return user.getId();
		}

		return null;
	}

	@RequestMapping(value="/getUser", method = RequestMethod.POST)
	public User getUser(@RequestBody UserForm form) {
		User user = userService.getUserById(form);

		if (user != null) {

			return user;
		}

		return null;
	}
}
