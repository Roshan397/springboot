package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.Books;

public interface BooksRepository extends JpaRepository<Books, Integer>{

}
