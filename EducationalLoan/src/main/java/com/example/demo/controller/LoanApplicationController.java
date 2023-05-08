package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.LoanApplicationModel;
import com.example.demo.service.LoanApplicationService;

@RestController
@RequestMapping("/admin")
@CrossOrigin("http://localhost:3000")
public class LoanApplicationController {
	@Autowired
	LoanApplicationService laSer;
	@GetMapping(value="/getAllLoans")
	public List<LoanApplicationModel> get()
	{
		List<LoanApplicationModel> l=laSer.get();
		return l;
	}
	@PostMapping(value="/postadmin")
	public LoanApplicationModel saveUser(@RequestBody LoanApplicationModel l)
	{
		return laSer.saveUser(l);
	}
	@DeleteMapping(value="/deleteadmin/{id}")
	public void Del(@PathVariable int id)
	{
		laSer.Del(id);
	}
	@PutMapping(value="/postadmin")
	public LoanApplicationModel updateUser( LoanApplicationModel l)
	{
		return laSer.saveUser(l);
	}

}
