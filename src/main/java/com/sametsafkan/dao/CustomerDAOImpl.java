package com.sametsafkan.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import com.sametsafkan.entity.Customer;

import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class CustomerDAOImpl implements CustomerDAO{

	private final SessionFactory factory;
	
	@Override
	public List<Customer> getCustomers() {
		Session session = factory.getCurrentSession();
		return session.createQuery("from Customer", Customer.class).getResultList();
	}

	@Override
	public void save(Customer customer) {
		Session session = factory.getCurrentSession();
		session.save(customer);
	}

}
