package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Student;
import com.example.demo.service.StudentService;

@RestController
public class StudentController {
	@Autowired
	StudentService stdService;

	@GetMapping("/students/{studentId}/courses")
	public Student getCourse(@PathVariable int studentId) {
		return stdService.getCourse(studentId);
	}

	@GetMapping("/students/{studentId}/courses/{courseId}")
	public Student getCoursewithId(@PathVariable int studentId, @PathVariable String courseId) {
		return stdService.getCoursewithId(studentId, courseId);
	}
}
