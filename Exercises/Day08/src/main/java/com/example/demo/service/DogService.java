package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Dog;
import com.example.demo.repository.DogRepository;

@Service
public class DogService {
	@Autowired
	DogRepository dRepo;

	public List<Dog> findByNameStartsWith(String name) {
		return dRepo.findByNameStartsWith(name);
	}

	public List<Dog> findByNameEndsWith(String name) {
		return dRepo.findByNameEndsWith(name);
	}
}
