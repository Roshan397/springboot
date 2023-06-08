package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Product;
import com.example.demo.repository.ProductRepository;

@Service
public class ProductService {
	@Autowired
	ProductRepository pRepo;

	public boolean save(Product p) {
		pRepo.save(p);
		return true;
	}

	public Product getById(int id) {
		Product p = pRepo.findById(id).get();
		return p;
	}

	public List<Product> getAll() {
		List<Product> pList = pRepo.findAll();
		return pList;
	}

	public Product update(int id, Product p) {
		Optional<Product> optional = pRepo.findById(id);
		Product prod = null;
		if (optional.isPresent()) {
			prod = optional.get();
			pRepo.saveAndFlush(p);
		}
		return prod;
	}

	public boolean delete(int id) {
		boolean result = false;
		pRepo.deleteById(id);
		Optional<Product> p = pRepo.findById(id);
		if (p.isEmpty()) {
			result = true;
		}
		return result;
	}

}
