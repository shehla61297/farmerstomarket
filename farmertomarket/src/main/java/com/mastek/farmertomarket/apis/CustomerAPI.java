package com.mastek.farmertomarket.apis;

import java.util.Set;

import javax.ws.rs.BeanParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.mastek.farmertomarket.entities.Checkout;
import com.mastek.farmertomarket.entities.Customer;

@Path("/farmerstomarket/")
public interface CustomerAPI {




		@GET
		@Path("/customer/list")
		@Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML}) // formats which the method supports
		public Iterable<Customer> listAllCustomers();
		
		@GET //http method
		@Path("/customer/find/{customerID}") //url with parameter format
		@Produces({MediaType.APPLICATION_JSON})
		public Customer findCustomerID(@PathParam("customerID") int customerID);

//		@GET
//		@Path("/customer/find/{email}")
//		@Produces({ MediaType.APPLICATION_JSON })
//		public Iterable<Customer> findCustomerEmail(@PathParam("customerEmail") String customerEmail);

	@POST
	@Path("/customer/login")
	@Produces({ MediaType.APPLICATION_JSON })
	public Customer getCustomerLogin(@FormParam("customerEmail") String customerEmail,
			@FormParam("customerPassword") String customerPassword);

		@POST // http method Post used to send data in requests
		@Path("/customer/register")
		@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
		@Produces(MediaType.APPLICATION_JSON)
		public Customer registerNewCustomer(@BeanParam Customer newCustomer);
		
		@GET
		@Path("/checkout/{customerID}")
		@Produces({ MediaType.APPLICATION_JSON })
		public Set<Checkout> getCustomerCheckouts(@PathParam("customerID") int customerID);
		

}
