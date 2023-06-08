package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.example.demo.model.Student;
import com.example.demo.repository.StudentRepository;

import jakarta.transaction.Transactional;


@Service
public class StudentService {
	@Autowired
	StudentRepository studRepository;
	public List<Student>  getAllStudents() {
		List<Student> studList=studRepository.findAll();
		return studList;
	}

	public Student saveStudent(Student s) {
		Student obj=studRepository.save(s);
		return obj;
		//return studRepository.save(s);
	}
	
	public  Student updateStudent(Student s,int rno) {
		Optional<Student> optional=studRepository.findById(rno);
		Student obj=null;
		if(optional.isPresent())
		{
			obj=optional.get();
			studRepository.save(s);
		}
		return obj;
	}
	
	public boolean deleteStudent(int regno) {
		boolean result=false;
		studRepository.deleteById(regno);
		Optional<Student> s= studRepository.findById(regno);
		if(s.isEmpty())
		{
			result=true;
		}
		return result;
	}
	
	public Student getStudent(int regno)
	{
		Student s=studRepository.findById(regno).get();
		return s;
	}
	
	public List<Student> sortStudent(String field) {
		return studRepository.findAll(Sort.by(Direction.DESC,field));
//		return studRepository.findAll(Sort.by(field));
		
	}

	public List<Student> pagingStudents(int offset, int pageSize) {
		Pageable paging=PageRequest.of(offset,pageSize);
		Page<Student> studData=studRepository.findAll(paging);
		List<Student> studList=studData.getContent();
		return studList;
	}
	
//	public Page<student> pagingStudents(int offset, int pageSize) {
//		Pageable paging=PageRequest.of(offset,pageSize);
//		Page<student> studData=studRepository.findAll(paging);
//		return studData;
//	}
	
	public List<Student> pagingAndSortingStudents(int offset, int pageSize,String field) {
		Pageable paging=PageRequest.of(offset,pageSize).withSort(Sort.by(field));
		Page<Student> studData=studRepository.findAll(paging);
		List<Student> studList=studData.getContent();
		return studList;
	}
	
	public List<Student> fetchStudentsByNamePrefix(String prefix){
		return studRepository.findBynameStartingWith(prefix);
	}
	
	public List<Student> getStudentsByDepartment(String dep,String name) {
		return studRepository.getStudentsByDepartment(dep, name);
	}
	
	//DML
	@Transactional
	public int deleteStudentByname(String name) {
		return studRepository.deleteStudentByName(name);
	}
	
	@Transactional
	public int updateStudentByName(String dep,String name) {
		return studRepository.updateStudentByName(dep, name);
	}
	
}
 