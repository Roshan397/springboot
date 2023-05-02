package com.product.controller;

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

import com.product.model.Detol;
import com.product.service.DetolService;

@RestController
public class DetolController {
	@Autowired
	DetolService f;
	@GetMapping(value="/fetch")
	public List<Detol> getAllValues()
	{
		List<Detol> d=f.getAllValues();
		return d;
	}
	@PostMapping(value="/post")
	public Detol saveFile(@RequestBody Detol s)
	{
		return f.saveFile(s);
		
	}
	@PutMapping(value="/put")
	public Detol updateFile(@RequestBody Detol s)
	{
		return f.updateFile(s);
		
	}
	@DeleteMapping(value="/delete/{b}")
	public void del(@PathVariable("b") Integer batno)
	{
		f.del(batno);
	}
	@GetMapping(value="/findById/{id}")
	public Detol find(@PathVariable int id)
	{
		return f.find(id);
	}
	@DeleteMapping("/deleteStudent/{id}")
	public boolean deleteStudent(@PathVariable int id)
	{
		boolean result=f.deleteStudent(id);
		return result;
	}

	
	 @GetMapping("/sortStudent/{field}")
	 public List<Detol> sortStudent(@PathVariable("field") String field)
	 {
		 return f.sortStudent(field);
	 }
	 
	 @GetMapping("/pagingStudents/{offset}/{pageSize}")
	 public List<Detol> pagingStudents(@PathVariable int offset,@PathVariable int pageSize){
		 return f.pagingStudents(offset,pageSize);
	 }
	 
//	 @GetMapping("pagingStudents/{offset}/{pageSize}")
//	 public Page<Detol> pagingStudents(@PathVariable int offset,@PathVariable int pageSize){
//		 return f.pagingStudents(offset,pageSize);
//	 }
	 
	 @GetMapping("/pagingStudents/{offset}/{pageSize}/{field}")
	 public List<Detol> pagingAndSortingStudents(@PathVariable int offset,@PathVariable int pageSize,@PathVariable String field){
		 return f.pagingAndSortingStudents(offset,pageSize,field);
	 }
	 
	 @GetMapping("/fetchStudentsByNamePrefix")
	 public List<Detol> fetchStudentsByAreaPrefix(@RequestParam String prefix){
		return f.fetchStudentsByNamePrefix(prefix);
	}
	 @GetMapping("/fetchStudentsByDepartment/{area}/{type}")
	 public List<Detol> fetchStudentsByArea(@PathVariable String area,@PathVariable String type)
	 {
	 	return f.getStudentsByDepartment(area, type);
	 }

}
