package com.product.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.product.model.Detol;

@Repository
public interface DetolRepository extends JpaRepository<Detol,Integer>{
	 //	positional parameter
		@Query("select s from Detol s where s.manarea=?1 and s.type=?2" )
		public List<Detol> getCustomersByManarea(String area,String type);
		
		//named parameter
		@Query("select s from Detol s where s.manarea=:area")
		public List<Detol> getCustomersByManarea(String area);
		
		//DML
		@Modifying
		@Query("delete from Detol s where s.custname=?1")
		public int deleteCustomersByCustname(String name);
		
		@Modifying
		@Query("update Detol s set s.manarea=?1 where s.custname=?2")
		public int updateCustomersByCustname(String area,String name);
		
		//MySql Query
		@Query(value="select * from Detol s where s.shipping=?1",nativeQuery=true)
		public List<Detol> fetchStudentsByEmail(String shipping);
		
		List<Detol> findByManareaStartingWith(String prefix);
		List<Detol> findByManareaEndingWith(String suffix);
		List<Detol> findByManarea(String area);

}
