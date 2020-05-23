package com.sametsafkan.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.sametsafkan.dao.CustomerDAO;
import com.sametsafkan.entity.Customer;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CustomerServiceImpl implements CustomerService {

	private final CustomerDAO customerDao;

	@Override
	@Transactional
	public List<Customer> getCustomers() {
		return customerDao.getCustomers();
	}

	@Override
	@Transactional
	public void save(Customer customer) {
		customerDao.save(customer);
	}

	@Override
	@Transactional
	public Customer findById(int customerId) {
		return customerDao.findById(customerId);
	}

	@Override
	@Transactional
	public void delete(int customerId) {
		customerDao.delete(customerId);
	}
}
