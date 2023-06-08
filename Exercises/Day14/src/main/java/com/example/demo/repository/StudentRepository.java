package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student,Integer>{
	
	//positional parameter
	@Query("select s from Student s where s.dep=?1 and s.name=?2")
	public List<Student> getStudentsByDepartment(String dep,String name);
	
	//named parameter
	@Query("select s from Student s where s.dep=:dep")
	public List<Student> getStudentsByDepartment(String dep);
	
	//DML
	@Modifying
	@Query("delete from Student s where s.name=?1")
	public int deleteStudentByName(String name);
	
	@Modifying
	@Query("update Student s set s.dep=?1 where s.name=?2")
	public int updateStudentByName(String dep,String name);
	
	//MySql Query
	@Query(value="select * from Student s where s.email=?1",nativeQuery=true)
	public List<Student> fetchStudentsByEmail(String email);

	List<Student> findBynameStartingWith(String prefix);
	List<Student> findBynameEndingWith(String suffix);
	List<Student> findBydep(String dep);
}
