package com.carrental.backend.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.carrental.backend.form.UserForm;
import com.carrental.backend.model.User;
import com.carrental.backend.repository.UserRepository;

@RestController
@RequestMapping("api")
public class UserController {
	
	@Autowired
	private UserRepository userRepo;
	
	@RequestMapping(value="login", method = RequestMethod.POST)
	public User getUser(@RequestBody UserForm form, HttpServletResponse response, HttpServletRequest request) {
		User user = new User(); 
		user = userRepo.getUserByUsernameAndPassword(form.getUsername(),form.getPassword());
		
		return user;
	}
}
