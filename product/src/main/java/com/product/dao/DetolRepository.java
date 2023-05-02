package com.product.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.product.model.Detol;

@Repository
public interface DetolRepository extends JpaRepository<Detol,Integer>{
	 //	positional parameter
		@Query("select s from Detol s where s.manarea=?1 and s.type=?2" )
		public List<Detol> getStudentsByManarea(String area,String type);
		List<Detol> findByManareaStartingWith(String prefix);
		List<Detol> findByManareaEndingWith(String suffix);
		List<Detol> findByManarea(String area);

}
