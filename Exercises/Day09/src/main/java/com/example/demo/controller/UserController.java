package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.User;
import com.example.demo.service.UserService;

@RestController
public class UserController {
	@Autowired
	UserService uService;

	@GetMapping("/findByEmailAddress")
	public User findByEmailAddress(String emailAddress) {
		return uService.findByEmailAddress(emailAddress);
	}

	@GetMapping("/findByNameEndsWith")
	public List<User> findByNameEndsWith(String name) {
		return uService.findByNameEndsWith(name);
	}
}
