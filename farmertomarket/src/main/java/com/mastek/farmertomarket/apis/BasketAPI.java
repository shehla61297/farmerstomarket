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

import com.mastek.farmertomarket.entities.Basket;
import com.mastek.farmertomarket.entities.Item;
import com.mastek.farmertomarket.entities.Product;

@Path("/farmertomarket/")
public interface BasketAPI {

	@GET
	@Path("basket/list")
	@Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML}) //formats which the method supports
	public Iterable<Basket> listAllBaskets();
	
	@GET //http method
	@Path("/basket/find/{basketID}") // url with parameter format
	@Produces({MediaType.APPLICATION_JSON})
	public Basket findBasketID(@PathParam("basketID") int basketID);

	@POST // http method Post used to send data in requests
	@Path("basket/register")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Produces(MediaType.APPLICATION_JSON)
	public Basket registerNewBasket(@BeanParam Basket newBasket);
	
	@GET
	@Path("/basketItems/{basketID}")
	@Produces({ MediaType.APPLICATION_JSON })
	public Iterable<Item> findBasketItems(@PathParam("basketID") int basketID);
	
	@POST // http method Post used to send data in requests
	@Path("/basketItems/register")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Produces(MediaType.APPLICATION_JSON)
	public Item registerItemsForBasket(@FormParam("basketID") int basketID, @BeanParam Item newItem);

	@GET
	@Path("/basketProducts/{basketID}")
	@Produces({ MediaType.APPLICATION_JSON })
	public Set<Product> getBasketProducts(@PathParam("basketID") int basketID);

	@POST // http method Post used to send data in requests
	@Path("/basketProduct/register")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Produces(MediaType.APPLICATION_JSON)
	public Product registerProductsForBasket(@FormParam("basketID") int basketID, @BeanParam Product newProd);

}

