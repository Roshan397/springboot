package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.example.demo.model.Child;
import com.example.demo.repository.ChildRepository;

@Service
public class ChildService {
	@Autowired
	ChildRepository cRepo;

	public boolean save(Child c) {
		cRepo.save(c);
		return true;
	}

	public List<Child> sort(String field) {
		return cRepo.findAll(Sort.by(field));
	}

	public List<Child> paging(int offset, int pagesize) {
		Pageable pag = PageRequest.of(offset, pagesize);
		Page<Child> cData = cRepo.findAll(pag);
		List<Child> cList = cData.getContent();
		return cList;
	}

	public List<Child> pagingAndSorting(int offset, int pagesize, String field) {
		Pageable pag = PageRequest.of(offset, pagesize).withSort(Sort.by(field));
		Page<Child> cData = cRepo.findAll(pag);
		List<Child> cList = cData.getContent();
		return cList;
	}
}
