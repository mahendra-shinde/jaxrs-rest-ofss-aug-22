package com.mahendra.demo2;

import java.util.Map;

import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.PATCH;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;

@Path("/customer")
public class CustomerResource {
	
	private CustomerService service = CustomerService.getInstance();
	
	@GET
	@Produces("application/json")
	public Customer[] getAll() {
		return service.getAll();
	}
	
	
	@GET
	@Path("/{id}")
	@Produces({"application/xml","application/json"})
	public Customer findCustomer(@PathParam("id") int custId) {
		return service.findById(custId);
	}
	
	@POST
	@Consumes({"application/json","application/xml"})
	public String saveCustomer(Customer customer) {
		System.out.println("Creating customer "+customer.getLastName()+" "+customer.getFirstName());
		service.create(customer);
		return "Success";
	}
	
	@PATCH
	@Path("/{id}")
	@Consumes("application/json")
	public String updateLastName(@PathParam("id")Integer custId, Map<String, String> options) {
		System.out.println("YOu made request to update customer "+custId +" And property "+options.values());
		service.patch(custId, options);
		return "success";
	}
	
}
