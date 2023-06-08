package com.example.demo.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {
	@RequestMapping("/")
	public String requestparam(@RequestParam String var) {
		return var;
	}

	@RequestMapping("/{var}")
	public String pathvariable(@PathVariable String var) {
		return var;
	}
}
