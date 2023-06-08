package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Student;
import com.example.demo.repository.StudentRepository;

@Service
public class StudentService {
	@Autowired
	StudentRepository stdRepo;

	public Student getCourse(int studentId) {
		return stdRepo.findById(studentId).get();
	}

	public Student getCoursewithId(int studentId, String courseId) {
		return stdRepo.findByCourseId(courseId);
	}

}
