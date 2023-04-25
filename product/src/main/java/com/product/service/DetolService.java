package com.product.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.product.dao.DetolRepository;
import com.product.model.Detol;

@Service
public class DetolService {
	@Autowired
	DetolRepository c;
	public List<Detol> getAllValues()
	{
		List<Detol> d=c.findAll();
		return d;
	}
	public Detol saveFile(Detol s)
	{
		Detol f=c.save(s);
		return f;
	}
	public Detol updateFile(Detol s)
	{
		Detol f=c.save(s);
		return f;
	}
	public void del(int batno)
	{
		c.deleteById(batno);
	}

}
