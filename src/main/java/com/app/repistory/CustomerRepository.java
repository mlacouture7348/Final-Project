package com.app.repistory;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.model.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Integer>{
	
	public List<Customer> findAllByOrderByLastNameAsc();
	
}
