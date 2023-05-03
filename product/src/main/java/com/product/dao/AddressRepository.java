package com.product.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.product.model.Address;

@Repository
public interface AddressRepository extends JpaRepository<Address, Long> {

}
