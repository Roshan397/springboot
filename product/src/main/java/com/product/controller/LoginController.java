package com.product.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.product.model.Login;
import com.product.service.LoginService;

@RestController
public class LoginController {
	@Autowired
	LoginService ls;
	@PostMapping("/checkLogin")
	public String validateUser(@RequestBody Login l)
	{
		System.out.println(l.getUsername());
		return ls.valideteUser(l.getUsername(), l.getPassword());
	}
	
	@PostMapping("/addUser")
	public Login addDetails(@RequestBody Login l)
	{
		return ls.saveUser(l);
	}

}
