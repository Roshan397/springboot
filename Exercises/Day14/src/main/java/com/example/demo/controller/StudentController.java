package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Student;
import com.example.demo.service.StudentService;

@RestController
public class StudentController {
	@Autowired
	StudentService studService;
	
	@GetMapping("/fetchStudent")
	public List<Student> getAllStudents() {
		List<Student> studList=studService.getAllStudents();
		return studList;
	}
	
	@PostMapping("/saveStudent")
	public Student savestudent(@RequestBody Student s)
	{
		return studService.saveStudent(s);
	}
	
	@PutMapping("/updateStudent/{regno}")
	public Student updateStudent(@RequestBody Student s,@PathVariable int regno)
	{
		return studService.updateStudent(s,regno);
	}
	
	@DeleteMapping("/deleteStudent/{regno}")
	public boolean deleteStudent(@PathVariable int regno)
	{
		boolean result=studService.deleteStudent(regno);
		return result;
	}
	
	@GetMapping("/getStudent/{regno}")
	public Student getStudent(@PathVariable int regno)
	{
		return studService.getStudent(regno);
	}
	
	 @GetMapping("/sortStudent/{field}")
	 public List<Student> sortStudent(@PathVariable String field)
	 {
		 return studService.sortStudent(field);
	 }
	 
	 @GetMapping("/pagingStudents/{offset}/{pageSize}")
	 public List<Student> pagingStudents(@PathVariable int offset,@PathVariable int pageSize){
		 return studService.pagingStudents(offset,pageSize);
	 }
	 
//	 @GetMapping("pagingStudents/{offset}/{pageSize}")
//	 public Page<student> pagingStudents(@PathVariable int offset,@PathVariable int pageSize){
//		 return studService.pagingStudents(offset,pageSize);
//	 }
	 
	 @GetMapping("/pagingStudents/{offset}/{pageSize}/{field}")
	 public List<Student> pagingAndSortingStudents(@PathVariable int offset,@PathVariable int pageSize,@PathVariable String field){
		 return studService.pagingAndSortingStudents(offset,pageSize,field);
	 }
	 
	 @GetMapping("/fetchStudentsByNamePrefix")
	 public List<Student> fetchStudentsByNamePrefix(@RequestParam String prefix){
		return studService.fetchStudentsByNamePrefix(prefix);
	 }
	 
	 @GetMapping("/fetchStudentsByDepartment/{dep}/{name}")
	 public List<Student> fetchStudentsByDepartment(@PathVariable String dep,@PathVariable String name) {
		 return studService.getStudentsByDepartment(dep, name);
	 }
	 
	 @DeleteMapping("/deleteStudentByName/{name}")
	 public String deleteStudentByName(@PathVariable String name) {
		 int result=studService.deleteStudentByname(name);
		 if(result>0)
			 return "Student record deleted";
		 else
			 return "Problem occured while deleting";
	 }
	 
	 @PutMapping("/updateStudentByName/{dep}/{name}")
	 public String updateStudentByName(@PathVariable String dep,@PathVariable String name) {
		 int result=studService.updateStudentByName(dep,name);
		 if(result>0)
			 return "Student record updated";
		 else
			 return "Problem occured while updating";
	 }

}
