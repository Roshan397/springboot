package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Dog;
import com.example.demo.service.DogService;

@RestController
public class DogController {
	@Autowired
	DogService dService;

	@GetMapping("/findByNameStartsWith")
	List<Dog> findByNameStartsWith(String name) {
		return dService.findByNameStartsWith(name);
	}

	@GetMapping("/findByNameEndsWith")
	List<Dog> findByNameEndsWith(String name) {
		return dService.findByNameEndsWith(name);
	}
}
