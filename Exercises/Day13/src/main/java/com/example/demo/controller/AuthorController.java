package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Author;
import com.example.demo.service.AuthorService;

@RestController
public class AuthorController {
	@Autowired
	AuthorService aService;
	
	@GetMapping("/fetchAuthor")
	public List<Author> fetchAuthor() {
		List<Author> aList=aService.fetchAuthor();
		return aList;
	}
	
	@PostMapping("/saveAuthor")
	public Author saveAuthor(@RequestBody Author a) {
		return aService.saveAuthor(a);
	}
}
