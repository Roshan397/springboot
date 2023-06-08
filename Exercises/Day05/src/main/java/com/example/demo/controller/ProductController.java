package com.example.demo.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Product;
import com.example.demo.service.ProductService;

@RestController
public class ProductController {
	@Autowired
	ProductService pService;

	@PostMapping("/")
	public boolean save(@RequestBody Product p) {
		boolean result = pService.save(p);
		return result;
	}

	@GetMapping("/{id}")
	public Product getById(@PathVariable int id) {
		Product p = pService.getById(id);
		return p;
	}

	@GetMapping("/")
	public List<Product> getAll() {
		List<Product> pList = pService.getAll();
		return pList;
	}

	@PutMapping("/{id}")
	public Product update(@PathVariable int id, @RequestBody Product p) {
		Product prod = pService.update(id, p);
		return prod;
	}

	@DeleteMapping("/{id}")
	public boolean delete(@PathVariable int id) {
		boolean result = pService.delete(id);
		return result;
	}
}
