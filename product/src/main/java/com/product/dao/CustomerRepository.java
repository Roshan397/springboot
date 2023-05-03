package com.product.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.product.model.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {

}
