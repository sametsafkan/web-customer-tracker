package com.sametsafkan.service;

import java.util.List;

import com.sametsafkan.entity.Customer;

public interface CustomerService {

	List<Customer> getCustomers();

	void save(Customer customer);

	Customer findById(int customerId);

	void delete(int customerId);
}
