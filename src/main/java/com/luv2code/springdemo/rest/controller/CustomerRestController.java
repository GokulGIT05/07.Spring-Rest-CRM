package com.luv2code.springdemo.rest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.luv2code.springdemo.entity.Customer;
import com.luv2code.springdemo.rest.exception.CustomerNotFoundException;
import com.luv2code.springdemo.service.CustomerService;

@RestController
@RequestMapping("/api")
public class CustomerRestController {

	@Autowired
	CustomerService customerService;
	
	@GetMapping("/customers")
	public List<Customer> getAllCustomer(){
		return customerService.getCustomers();
	}
	

	@GetMapping("/customers/{customerId}")
	public Customer getCustomer(@PathVariable("customerId") int id){
		
		Customer customer = customerService.getCustomer(id);
		
		if(customer == null) {
			throw new CustomerNotFoundException("Customer Not Found");
		}
		return customer;
	}
	
	@PostMapping("/customers")
	public String saveCustomer(@RequestBody Customer customer) {
		// In Repo, Layer we using Save/Update method, It will look for 0 or null for creating a new row.
		// Even, by mistakenly someone send id, we are manually update that to 0.
		customer.setId(0);
		customerService.saveCustomer(customer);
		
		return "Successfull Saved";
	}
	
	@PutMapping("/customers")
	public String updateCustomer(@RequestBody Customer customer) {
		
		customerService.saveCustomer(customer);
		
		return "Successfull Saved or Updated";
	}
	
	
	@DeleteMapping("/customers/{customerId}")
	public String deleteCustomer(@PathVariable("customerId") int id) {
		
		// Cross Checking whether id is present or not.
		Customer customer = customerService.getCustomer(id);
		
		if(customer == null) {
			throw new CustomerNotFoundException("Customer Not Found");
		}
		
		customerService.deleteCustomer(id);
		
		return "Successfull Deleted for the ID: "+id;
	}
}
