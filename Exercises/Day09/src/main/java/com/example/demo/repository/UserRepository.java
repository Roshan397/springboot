package com.example.demo.repository;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer>{
	
	@Query("select u from User u where u.emailAddress=?1")
	public User findByEmailAddress(String emailAddress);
	
	@Query("select u from User u where u.name like %?1")
	public List<User> findByNameEndsWith(String name);
}
