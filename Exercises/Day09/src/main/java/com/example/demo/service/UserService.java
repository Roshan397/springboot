package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;

@Service
public class UserService {
	@Autowired
	UserRepository uRepo;

	public User findByEmailAddress(String emailAddress) {
		return uRepo.findByEmailAddress(emailAddress);
	}

	public List<User> findByNameEndsWith(String name) {
		return uRepo.findByNameEndsWith(name);
	}
	
	
}
