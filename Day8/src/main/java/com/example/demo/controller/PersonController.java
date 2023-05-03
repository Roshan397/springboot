package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Person;
import com.example.demo.service.PersonService;

@RestController
public class PersonController {
	@Autowired
	PersonService pService;
	
	@GetMapping("/getAllPersons")
	public List<Person> fetchAllPersons() {
		List<Person> pList=pService.fetchAllPersons();
		return pList;
	}
	
	@PostMapping("/savePersons") 
	public Person savePersons(@RequestBody Person p) {
		return pService.savePersons(p);
	}

}
