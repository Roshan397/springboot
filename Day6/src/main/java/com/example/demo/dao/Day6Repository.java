package com.example.demo.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Day6;

@Repository
public interface Day6Repository extends JpaRepository<Day6, Integer>{
    //	positional parameter
	@Query("select s from Student s where s.department=?1 and s.name=?2" )
	public List<Day6> getStudentsByDepartment(String dept,String name);
	List<Day6> findBynameStartingWith(String prefix);
	List<Day6> findBynameEndingWith(String suffix);
	List<Day6> findBydept(String dep);

}
