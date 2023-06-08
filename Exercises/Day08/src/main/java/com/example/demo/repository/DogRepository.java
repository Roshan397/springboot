package com.example.demo.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Dog;

@Repository
public interface DogRepository extends JpaRepository<Dog, Long> {
	@Query("FROM Dog d WHERE d.name LIKE :name%")
	List<Dog> findByNameStartsWith(String name);
	
	@Query("FROM Dog d WHERE d.name LIKE %:name")
	List<Dog> findByNameEndsWith(String name);
}
