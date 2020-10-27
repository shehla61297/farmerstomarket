package com.mastek.farmertomarket.dao;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.mastek.farmertomarket.entities.Customer;

@Repository
public interface CustomerJPADAO extends CrudRepository<Customer, Integer>{

	@Query("SELECT c FROM Customer c WHERE LOWER(c.customerEmail) = LOWER(:customerEmail) AND c.customerPassword = :customerPassword")
	public Customer findCustomerLogin(@Param("customerEmail") String customerEmail,
			@Param("customerPassword") String customerPassword);

}
