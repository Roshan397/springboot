package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Student;
import com.example.demo.service.StudentService;

@RestController
public class StudentController {
	@Autowired
	StudentService stdService;

	@GetMapping("/getStudentByCourse/{cname}")
	public List<Student> getStudentByCourse(@PathVariable String cname) {
		return stdService.getStudentByCourse(cname);
	}
	
	@PutMapping("/updateNameById/{name}/{id}")
	public int updateNameById(@PathVariable String name,@PathVariable int id) {
		return stdService.updateNameById(name,id);
	}
	
	@DeleteMapping("/deletebyId/{id}")
	public int deletebyId(@PathVariable int id) {
		return stdService.deletebyId(id);
	}
}
