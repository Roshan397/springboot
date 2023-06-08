package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Student;
import com.example.demo.repository.StudentRepository;

@Service
public class StudentService {
	@Autowired
	StudentRepository stdRepo;

	public List<Student> getStudentByCourse(String cname) {
		return stdRepo.getStudentByCourse(cname);
	}

	public int updateNameById(String name, int id) {
		return stdRepo.updateNameById(name, id);
	}

	public int deletebyId(int id) {
		return stdRepo.deletebyId(id);
	}
	
}
