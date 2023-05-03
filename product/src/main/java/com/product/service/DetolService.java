package com.product.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.product.dao.DetolRepository;
import com.product.model.Detol;

import jakarta.transaction.Transactional;

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
	public Detol find(int id)
	{
		return c.findById(id).get();
	}
	public boolean deleteCust(int id) {
		boolean result=false;
		c.deleteById(id);
		Optional<Detol> s= c.findById(id);
		if(s.isEmpty())
		{
			result=true;
		}
		return result;
	}
	
	public List<Detol> sortCust(String field) {
		return c.findAll(Sort.by(Direction.DESC,field));
//		return c.findAll(Sort.by(field));
		
	}

	public List<Detol> pagingCustomers(int offset, int pageSize) {
		Pageable paging=PageRequest.of(offset,pageSize);
		Page<Detol> custData=c.findAll(paging);
		List<Detol> custList=custData.getContent();
		return custList;
	}

	
	public List<Detol> pagingAndSortingCustomers(int offset, int pageSize,String field) {
		Pageable paging=PageRequest.of(offset,pageSize).withSort(Sort.by(field));
		Page<Detol> custData=c.findAll(paging);
		List<Detol> custList=custData.getContent();
		return custList;
	}
	
	public List<Detol> fetchCustomersByAreaPrefix(String prefix){
		return c.findByManareaStartingWith(prefix);
	}
	public List<Detol> getCustomersByArea(String area,String type)
	  {
		  return c.getCustomersByManarea(area, type);
	  }

	//DML
	@Transactional
	public int deleteCustomerByname(String name) {
		return c.deleteCustomersByCustname(name);
	}
	
	@Transactional
	public int updateCustomerByname(String area,String name) {
		return c.updateCustomersByCustname(area, name);
	}
}



