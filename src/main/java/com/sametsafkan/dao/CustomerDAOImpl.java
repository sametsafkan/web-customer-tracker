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
		session.saveOrUpdate(customer);
	}

	@Override
	public Customer findById(int customerId) {
		Session session = factory.getCurrentSession();
		return session.get(Customer.class, customerId);
	}

	@Override
	public void delete(int customerId) {
		Session session = factory.getCurrentSession();
		session.createQuery("delete Customer c where c.id = :customerId").setParameter("customerId", customerId).executeUpdate();
	}
}
