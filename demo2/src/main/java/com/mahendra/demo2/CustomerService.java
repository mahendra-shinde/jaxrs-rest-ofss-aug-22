package com.mahendra.demo2;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class CustomerService {

	private static CustomerService instance = new CustomerService();

	private CustomerService() {
	   customers.add(new Customer(101,"Ajay","Deol","5676734"));
	}

	public static CustomerService getInstance() {
		return instance;
	}

	List<Customer> customers = new LinkedList<>();

	public Customer findById(Integer custId) {
		Optional<Customer> cust= customers.stream().filter(c -> c.getCustId() == custId).findFirst();
		if(!cust.isPresent()) {
			throw new CustomerException("Customer id "+ custId+ " does not exists!");
		}
		return cust.get();
	}

	public Customer[] getAll() {
		return customers.toArray(new Customer[customers.size()]);
	}

	public void create(Customer customer) {
		Optional<Customer> cust = customers.stream().filter(c -> c.getCustId() == customer.getCustId()).findFirst();
		if (cust.isPresent()) {
			throw new CustomerException("Customer with id " + customer.getCustId() + " already exist");
		}
		customers.add(customer);
	}

	public void update(Customer customer) {
		Optional<Customer> cust = customers.stream().filter(c -> c.getCustId() == customer.getCustId()).findFirst();
		if (!cust.isPresent()) {
			throw new CustomerException("Customer with id " + customer.getCustId() + " doesn't exist");
		}
		Customer original = cust.get();
		original.setFirstName(customer.getFirstName());
		original.setLastName(customer.getLastName());
		original.setPhone(customer.getPhone());
	}

	public void delete(int custId) {
		Optional<Customer> cust = customers.stream().filter(c -> c.getCustId() == custId).findFirst();
		if (!cust.isPresent()) {
			throw new CustomerException("Customer with id " + custId + " doesn't exist");
		}
		customers.remove(cust.get());
	}

	public void patch(int custId, Map<String, String> options) {
		Optional<Customer> cust = customers.stream().filter(c -> c.getCustId() == custId).findFirst();
		if (!cust.isPresent()) {
			throw new CustomerException("Customer with id " + custId + " doesn't exist");
		}
		Customer original = cust.get();
		for (String key : options.keySet()) {
			switch (key) {
			case "firstName":
				original.setFirstName(options.get(key));
				break;
			case "lastName":
				original.setLastName(options.get(key));
				break;
			case "phone":
				original.setPhone(options.get(key));
				break;
			default:
				System.err.println("Invalid property: " + key);
			}
		}
	}

}
