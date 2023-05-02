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

import com.example.demo.dao.Day6Repository;
import com.example.demo.model.Day6;

@Service
public class Day6Service {
	@Autowired
	Day6Repository R6;
	public List<Day6> getAllValues()
	{
		List<Day6> d=R6.findAll();
		return d;
	}
	public Day6 saveFile(Day6 s)
	{
		Day6 f=R6.save(s);
		return f;
	}
	public Day6 updateFile(Day6 s)
	{
		Day6 f=R6.save(s);
		return f;
	}
	public void del(int id)
	{
		R6.deleteById(id);
	}
	public Day6 find(int id)
	{
		return R6.findById(id).get();
	}
	public boolean deleteStudent(int id) {
		boolean result=false;
		R6.deleteById(id);
		Optional<Day6> s= R6.findById(id);
		if(s.isEmpty())
		{
			result=true;
		}
		return result;
	}
	
	public List<Day6> sortStudent(String field) {
		return R6.findAll(Sort.by(Direction.DESC,field));
//		return R6.findAll(Sort.by(field));
		
	}

	public List<Day6> pagingStudents(int offset, int pageSize) {
		Pageable paging=PageRequest.of(offset,pageSize);
		Page<Day6> studData=R6.findAll(paging);
		List<Day6> studList=studData.getContent();
		return studList;
	}
	
//	public Page<Day6> pagingStudents(int offset, int pageSize) {
//		Pageable paging=PageRequest.of(offset,pageSize);
//		Page<Day6> studData=Day6.findAll(paging);
//		return studData;
//	}
	
	public List<Day6> pagingAndSortingStudents(int offset, int pageSize,String field) {
		Pageable paging=PageRequest.of(offset,pageSize).withSort(Sort.by(field));
		Page<Day6> studData=R6.findAll(paging);
		List<Day6> studList=studData.getContent();
		return studList;
	}
	
	public List<Day6> fetchStudentsByNamePrefix(String prefix){
		return R6.findBynameStartingWith(prefix);
	}
	public List<Day6> getStudentsByDepartment(String dept,String name)
	  {
		  return R6.getStudentsByDepartment(dept, name);
	  }

}
