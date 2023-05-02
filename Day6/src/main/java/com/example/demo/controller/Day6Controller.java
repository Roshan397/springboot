package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Day6;
import com.example.demo.service.Day6Service;

@RestController
public class Day6Controller {
	@Autowired
	Day6Service S6;
	@GetMapping(value="/fetch")
	public List<Day6> getAllValues()
	{
		List<Day6> d=S6.getAllValues();
		return d;
	}
	@PostMapping(value="/post")
	public Day6 saveFile(@RequestBody Day6 s)
	{
		return S6.saveFile(s);
		
	}
	@PutMapping(value="/put")
	public Day6 updateFile(@RequestBody Day6 s)
	{
		return S6.updateFile(s);
		
	}
	@DeleteMapping(value="/delete/{b}")
	public void del(@PathVariable("b") Integer id)
	{
		S6.del(id);
	}
	@GetMapping(value="/findById/{id}")
	public Day6 find(@PathVariable int id)
	{
		return S6.find(id);
	}
	@DeleteMapping("/deleteStudent/{id}")
	public boolean deleteStudent(@PathVariable int id)
	{
		boolean result=S6.deleteStudent(id);
		return result;
	}

	
	 @GetMapping("/sortStudent/{field}")
	 public List<Day6> sortStudent(@PathVariable("field") String field)
	 {
		 return S6.sortStudent(field);
	 }
	 
	 @GetMapping("/pagingStudents/{offset}/{pageSize}")
	 public List<Day6> pagingStudents(@PathVariable int offset,@PathVariable int pageSize){
		 return S6.pagingStudents(offset,pageSize);
	 }
	 
//	 @GetMapping("pagingStudents/{offset}/{pageSize}")
//	 public Page<Day6> pagingStudents(@PathVariable int offset,@PathVariable int pageSize){
//		 return S6.pagingStudents(offset,pageSize);
//	 }
	 
	 @GetMapping("/pagingStudents/{offset}/{pageSize}/{field}")
	 public List<Day6> pagingAndSortingStudents(@PathVariable int offset,@PathVariable int pageSize,@PathVariable String field){
		 return S6.pagingAndSortingStudents(offset,pageSize,field);
	 }
	 
	 @GetMapping("/fetchStudentsByNamePrefix")
	 public List<Day6> fetchStudentsByNamePrefix(@RequestParam String prefix){
		return S6.fetchStudentsByNamePrefix(prefix);
	}
	 @GetMapping("/fetchStudentsByDepartment/{dept}/{name}")
	 public List<Day6> fetchStudentsByDepartment(@PathVariable String dept,@PathVariable String name)
	 {
	 	return S6.getStudentsByDepartment(dept, name);
	 }

}
