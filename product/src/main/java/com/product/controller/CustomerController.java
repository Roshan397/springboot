package com.product.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.product.model.Customer;
import com.product.service.CustomerService;

@RestController
public class CustomerController {
	@Autowired
	CustomerService custSer;
	
	@GetMapping("/getAllCustomers")
	public List<Customer> fetchAllCustomers() {
		List<Customer> pList=custSer.fetchAllCustomers();
		return pList;
	}
	
	@PostMapping("/saveCustomers") 
	public Customer saveCustomers(@RequestBody Customer p) {
		return custSer.saveCustomers(p);
	}

}
