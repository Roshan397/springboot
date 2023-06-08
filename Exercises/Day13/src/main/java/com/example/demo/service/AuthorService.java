package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Author;
import com.example.demo.repository.AuthorRepository;

@Service
public class AuthorService {
	@Autowired
	AuthorRepository authorRepo;
	
	public Author saveAuthor(Author a) {
		return authorRepo.save(a);
	}

	public List<Author> fetchAuthor() {
		List<Author> aList=authorRepo.findAll();
		return aList;
	}
}
