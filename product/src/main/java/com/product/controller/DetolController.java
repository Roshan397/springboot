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
	@DeleteMapping("/deleteCustomer/{id}")
	public boolean deleteCustomer(@PathVariable int id)
	{
		boolean result=f.deleteCust(id);
		return result;
	}

	
	 @GetMapping("/sortCustomer/{field}")
	 public List<Detol> sortCustomer(@PathVariable("field") String field)
	 {
		 return f.sortCust(field);
	 }
	 
	 @GetMapping("/pagingCustomers/{offset}/{pageSize}")
	 public List<Detol> pagingCustomers(@PathVariable int offset,@PathVariable int pageSize){
		 return f.pagingCustomers(offset,pageSize);
	 }

	 
	 @GetMapping("/pagingCustomers/{offset}/{pageSize}/{field}")
	 public List<Detol> pagingAndSortingCustomers(@PathVariable int offset,@PathVariable int pageSize,@PathVariable String field){
		 return f.pagingAndSortingCustomers(offset,pageSize,field);
	 }
	 
	 @GetMapping("/fetchCustomersByAreaPrefix")
	 public List<Detol> fetchStudentsByAreaPrefix(@RequestParam String prefix){
		return f.fetchCustomersByAreaPrefix(prefix);
	}
	 @GetMapping("/fetchCustomersByArea/{area}/{type}")
	 public List<Detol> fetchCustomersByArea(@PathVariable String area,@PathVariable String type)
	 {
	 	return f.getCustomersByArea(area, type);
	 }
	 @DeleteMapping("/deleteCustomerByName/{name}")
	 public String deleteCustomerByName(@PathVariable String name) {
		 int result=f.deleteCustomerByname(name);
		 if(result>0)
			 return "Customer record deleted";
		 else
			 return "Problem occured while deleting";
	 }
	 
	 @PutMapping("/updateCustomerByName/{area}/{name}")
	 public String updateCustomerByName(@PathVariable String area,@PathVariable String name) {
		 int result=f.updateCustomerByname(area,name);
		 if(result>0)
			 return "Customer record updated";
		 else
			 return "Problem occured while updating";
	 }


}
