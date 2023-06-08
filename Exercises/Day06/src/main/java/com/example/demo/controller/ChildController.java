package com.example.demo.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Child;
import com.example.demo.service.ChildService;

@RestController
public class ChildController {
	@Autowired
	ChildService cService;

	@PostMapping("/")
	public void save(@RequestBody Child c) {
		cService.save(c);
	}

	@GetMapping("/{field}")
	public List<Child> sort(@PathVariable String field) {
		return cService.sort(field);
	}

	@GetMapping("/{offset}/{pagesize}")
	public List<Child> paging(@PathVariable int offset, @PathVariable int pagesize) {
		return cService.paging(offset, pagesize);
	}

	@GetMapping("/{offset}/{pagesize}/{field}")
	public List<Child> pagingAndSorting(@PathVariable int offset, @PathVariable int pagesize,
			@PathVariable String field) {
		return cService.pagingAndSorting(offset, pagesize, field);
	}
}
