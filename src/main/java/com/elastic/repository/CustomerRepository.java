package com.elastic.repository;

import java.util.List;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import com.elastic.domain.Customer;

public interface CustomerRepository extends ElasticsearchRepository<Customer,String> {

	public Customer findByFirstName(String firstName);
	
	public List<Customer> findByLastName(String lastName);
}
