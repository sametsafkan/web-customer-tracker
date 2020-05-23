package com.sametsafkan.dao;

import java.util.List;

import com.sametsafkan.entity.Customer;

public interface CustomerDAO {

	List<Customer> getCustomers();

	void save(Customer customer);

	Customer findById(int customerId);

	void delete(int customerId);
}
