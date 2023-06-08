package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Books;
import com.example.demo.repository.BooksRepository;

@Service
public class BooksService {
	@Autowired
	BooksRepository bRepo;

	public List<Books> getAll() {
		List<Books> booksList = bRepo.findAll();
		return booksList;
	}

	public Books save(Books b) {
		Books book = bRepo.save(b);
		return book;
	}

	public Books update(Books b) {
		Books book = bRepo.saveAndFlush(b);
		return book;
	}

	public void delete(int bookId) {
		bRepo.deleteById(bookId);
	}

}
