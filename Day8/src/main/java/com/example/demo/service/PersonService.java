package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.PersonRepository;
import com.example.demo.model.Person;

@Service
public class PersonService {
	@Autowired
	PersonRepository personRepo;
	
	public List<Person> fetchAllPersons(){
		List<Person> s=personRepo.findAll();
		return s;
	}
	
	public Person savePersons(Person p) {
		Person x=personRepo.save(p);
		return x;
	}

}
