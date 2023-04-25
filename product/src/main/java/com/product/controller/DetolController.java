package com.product.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
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

}
