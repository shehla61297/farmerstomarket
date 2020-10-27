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

import com.mastek.farmertomarket.entities.Farmer;
import com.mastek.farmertomarket.entities.Product;


@Path("/farmertomarket/")
public interface FarmerAPI {
	
	@GET
	@Path("/farmer/list")
	@Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML}) // formats which the method supports
	public Iterable<Farmer> listAllFarmers();
	
	@GET //http method
	@Path("/farmer/find/{farmerID}") //url with parameter format
	@Produces({MediaType.APPLICATION_JSON})
	public Farmer findFarmerID(@PathParam("farmerID") int farmerID);

	@POST // http method Post used to send data in requests
	@Path("/farmer/register")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Produces(MediaType.APPLICATION_JSON)
	public Farmer registerNewFarmer(@BeanParam Farmer newFarmer);
	

	// POST http://localhost:8080/farmers2home/farmers/login
	@POST
	@Path("/farmer/login")
	@Produces(MediaType.APPLICATION_JSON)
	public Farmer getFarmerLogin(@FormParam("farmerEmail") String farmerEmail, @FormParam("farmerPassword") String farmerPassword);
	
	@GET
	@Path("/farmerProducts/find/{farmerID}")
	@Produces({ MediaType.APPLICATION_JSON })
	public Set<Product> getFarmerProducts(@PathParam("farmerID") int farmerID);


	@POST
	@Path("/farmerProducts/register")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Produces(MediaType.APPLICATION_JSON)
	public Product registerProductsForFarmers(@FormParam("farmerID") int farmerID, @BeanParam Product newProduct);
}



	

