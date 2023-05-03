package com.product.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.product.dao.CustomerRepository;
import com.product.model.Customer;

@Service
public class CustomerService {
	@Autowired
	CustomerRepository custRepo;
	
	public List<Customer> fetchAllCustomers(){
		List<Customer> c=custRepo.findAll();
		return c;
	}
	
	public Customer saveCustomers(Customer p) {
		Customer s=custRepo.save(p);
		return s;
	}

}
