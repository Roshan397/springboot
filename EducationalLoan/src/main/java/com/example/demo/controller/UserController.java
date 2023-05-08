package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.LoanApplicationModel;
import com.example.demo.model.UserModel;
import com.example.demo.service.UserService;

@RestController
@CrossOrigin("http://localhost:3000")
@RequestMapping("/user")
public class UserController {
	@Autowired
	UserService userSer;
	@PostMapping("/login")
	public String validateUser(@RequestBody UserModel u)
	{
		return userSer.valideteUser(u.getEmail(), u.getPassword());
	}
	
	@PostMapping("/signup")
	public UserModel addDetails(@RequestBody UserModel u)
	{
		return userSer.saveUser(u);
	}

	@GetMapping(value="/getProfile")
	public List<UserModel> get()
	{
		List<UserModel> s=userSer.get();
		return s;
	}
	
	@GetMapping(value="/viewLoan/{user}")
	public LoanApplicationModel getById(@PathVariable int user)
	{
		LoanApplicationModel gbi=userSer.getById(user);
		return gbi;
		
	}
	@DeleteMapping(value="/delete/{id}")
	public void Del(@PathVariable int id)
	{
		userSer.Del(id);
	}
	@PutMapping(value="/update")
	public UserModel updateDetails(@RequestBody UserModel u)
	{
		return userSer.saveUser(u);
	}

}
