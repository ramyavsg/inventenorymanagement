package com.edu.SpringBootCustomerApp.Service;

import java.util.List;

import com.edu.SpringBootCustomerApp.Entity.Customer;

public interface CustomerService {
	Customer saveCustomer(Customer customer);
	List<Customer>getAllCustomer();
	Customer getCustomerById(long id);
	Customer updateCustomer(Customer customer,long id);
	
	//Customer deleteCustomer(Customer customer,long id);
	void deleteCustomer(long id);
	List<Customer> getCustomerByFirstName(String firstName);
	List<Customer> getCustomerByLastName(String lastName);
	List<Customer> getcustomerByFirstNameAndLastName(String firstName, String lastName);
	List<Customer> getcustomerByFirstNameOrLastName(String firstName, String lastName);
	Customer getCustomerFullNameById(long id);
	
	
	
	
	
	
	
	
	
}
