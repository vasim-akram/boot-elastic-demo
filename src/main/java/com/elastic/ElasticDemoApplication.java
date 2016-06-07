package com.elastic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.elastic.domain.Customer;
import com.elastic.repository.CustomerRepository;

@SpringBootApplication
public class ElasticDemoApplication implements CommandLineRunner {

	@Autowired
	private CustomerRepository customerRepository;

	@Override
	public void run(String... args) throws Exception {
		this.customerRepository.deleteAll();
		saveCustomers();
		fetchAllCustomers();
		fetchIndividualCustomers();
	}

	private void saveCustomers() {
		this.customerRepository.save(new Customer("Vasim", "Ansari"));
		this.customerRepository.save(new Customer("Sadia", "Ansari"));
	}
	private void fetchAllCustomers() {
		System.out.println("Customer found with findAll():");
		System.out.println("------------------------------");
		this.customerRepository.findAll().forEach(customer -> System.out.println(customer));
		System.out.println();
	}

	private void fetchIndividualCustomers() {
		System.out.println("Customer found with findByFirstName(Vasim):");
		System.out.println("------------------------------");
		System.out.println(this.customerRepository.findByFirstName("Vasim"));
		System.out.println("Customer found with findByLastName(Ansari):");
		System.out.println("------------------------------");
		this.customerRepository.findByLastName("Ansari").forEach(customer -> System.out.println(customer));
	}

	public static void main(String[] args) {
		SpringApplication.run(ElasticDemoApplication.class,args);
	}
}
