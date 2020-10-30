package com.mastek.farmertomarket.services;

import java.util.Set;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.mastek.farmertomarket.apis.BasketAPI;
import com.mastek.farmertomarket.apis.CheckoutAPI;
import com.mastek.farmertomarket.apis.CustomerAPI;
import com.mastek.farmertomarket.apis.FarmerAPI;
import com.mastek.farmertomarket.apis.ItemAPI;
import com.mastek.farmertomarket.apis.ProductAPI;
import com.mastek.farmertomarket.apis.TransactionAPI;
import com.mastek.farmertomarket.dao.BasketJPADAO;
import com.mastek.farmertomarket.dao.CheckoutJPADAO;
import com.mastek.farmertomarket.dao.CustomerJPADAO;
import com.mastek.farmertomarket.dao.FarmerJPADAO;
import com.mastek.farmertomarket.dao.ItemJPADAO;
import com.mastek.farmertomarket.dao.ProductJPADAO;
import com.mastek.farmertomarket.dao.TransactionJPADAO;
import com.mastek.farmertomarket.entities.Basket;
import com.mastek.farmertomarket.entities.Checkout;
import com.mastek.farmertomarket.entities.Customer;
import com.mastek.farmertomarket.entities.Farmer;
import com.mastek.farmertomarket.entities.Item;
import com.mastek.farmertomarket.entities.Product;
import com.mastek.farmertomarket.entities.Transaction;



@Component									 // marking class as bean to be created
@Scope("singleton")	// singleton: One object used across test cases, prototype: one object per request
public class FarmerToMarketService
		implements BasketAPI, CheckoutAPI, CustomerAPI, FarmerAPI, ItemAPI, ProductAPI, TransactionAPI {

@Autowired
BasketJPADAO baskDAO;

@Autowired
CheckoutJPADAO checkDAO;

@Autowired
CustomerJPADAO custDAO;

@Autowired
FarmerJPADAO farmDAO;

@Autowired
ItemJPADAO itemDAO;

@Autowired
ProductJPADAO prodDAO;

@Autowired
TransactionJPADAO tranDAO;


@Override
public Iterable<Transaction> listAllTransactions() {
	// TODO Auto-generated method stub
	return tranDAO.findAll();
}

@Override
public Transaction findTransactionID(int transactionID) {
	// TODO Auto-generated method stub
	return tranDAO.findById(transactionID).get();
}

@Override
public Transaction registerNewTransaction(Transaction newTransaction) {
	newTransaction = tranDAO.save(newTransaction);
	return newTransaction;
}

@Override
public Iterable<Product> listAllProducts() {
	// TODO Auto-generated method stub
	return prodDAO.findAll();
}

@Override
public Product findProductID(int productID) {
	// TODO Auto-generated method stub
	return prodDAO.findById(productID).get();
}

@Override
public Product registerNewProduct(Product newProduct) {
	newProduct=prodDAO.save(newProduct);
	return newProduct;
}

@Override
public Iterable<Item> listAllItems() {
	// TODO Auto-generated method stub
	return itemDAO.findAll();
}

@Override
public Item finditemID(int itemID) {
	// TODO Auto-generated method stub
	return itemDAO.findById(itemID).get();
}

//


	@Override
public Item registerNewItem(Item newItem) {
	newItem = itemDAO.save(newItem);
	return newItem;
}




@Override
public Iterable<Customer> listAllCustomers() {

	return custDAO.findAll();
}

@Override
public Customer findCustomerID(int customerID) {
	// TODO Auto-generated method stub
	return custDAO.findById(customerID).get();
}

@Override
public Customer registerNewCustomer(Customer newCustomer) {
	newCustomer = custDAO.save(newCustomer);
	return newCustomer;
}

@Override
public Iterable<Checkout> listAllCheckouts() {
	System.out.println("List all checkouts");
	return checkDAO.findAll();
}

@Override
public Checkout findCheckoutID(int checkoutID) {
	// TODO Auto-generated method stub
	return checkDAO.findById(checkoutID).get();
}

@Override
public Checkout registerNewCheckout(Checkout newCheckout) {
	newCheckout = checkDAO.save(newCheckout);
	return newCheckout;
}

@Override
public Iterable<Basket> listAllBaskets() {
	// TODO Auto-generated method stub
	return baskDAO.findAll();
}

@Override
public Basket findBasketID(int basketID) {
	// TODO Auto-generated method stub
	return baskDAO.findById(basketID).get();
}

@Override
public Basket registerNewBasket(Basket newBasket) {
	newBasket = baskDAO.save(newBasket);
	return newBasket;
}

@Override
public Farmer registerNewFarmer(Farmer newFarmer) {
	newFarmer = farmDAO.save(newFarmer);
	return newFarmer;
}

@Override
public Iterable<Farmer> listAllFarmers() {
	
	return farmDAO.findAll();
}

@Override
public Farmer findFarmerID(int farmerID) {
	
	return farmDAO.findById(farmerID).get();
}
@Transactional
	public Checkout assignCheckoutToCustomers(int checkoutID, int customerID) {
	// TODO Auto-generated method stub
	
	Checkout check = checkDAO.findById(checkoutID).get();
	Customer cust = custDAO.findById(customerID).get();
	
		check.setCurrentCustomer(cust);
		cust.getCustomerCheckouts().add(check);
	
		check = checkDAO.save(check);
		cust = custDAO.save(cust);
	
		return check;
	}

	@Transactional
	public Transaction assignTransactionToCheckout(int transactionID, int checkoutID) {
	
		Transaction tran = tranDAO.findById(transactionID).get();
		Checkout check = checkDAO.findById(checkoutID).get();
	
		tran.setCheckout(check);
		check.setTransaction(tran);
	
		tran = tranDAO.save(tran);
		check = checkDAO.save(check);

		return tran;

	}


	@Transactional
	public Basket assignBasketsToItems( int basketID, int itemID) {

		Basket bask = baskDAO.findById(basketID).get();
		Item newItem = itemDAO.findById(itemID).get();

		bask.getItemsAssigned().add(newItem);
		baskDAO.save(bask);

		System.out.println(bask);
		return bask;


	}

	@Transactional
	public Basket assignProductsToBasket(int basketID, int productID) {

		Basket bask = baskDAO.findById(basketID).get();
		Product newProd = prodDAO.findById(productID).get();

		bask.getProductAssignedToBasket().add(newProd);

		System.out.println(bask);

		return bask;
	}

	// @Override
	// @Transactional
//	public Iterable<Item> findByName(String itemName) {
//		Iterable<Item> list = itemDAO.findByItemName(itemName);
//		return list;
//	}


	@Transactional
	public Item assignItemsToCustomers(int itemID, int customerID) {

		Item it = itemDAO.findById(itemID).get();
		Customer newCustomer = custDAO.findById(customerID).get();

		it.getCustomersAssigned().add(newCustomer);
		itemDAO.save(it);

		return it;

	}


	@Transactional
	public Farmer assignFarmersToProducts(int farmerID, int productID) {

		Farmer farm = farmDAO.findById(farmerID).get();
		Product newProduct = prodDAO.findById(productID).get();

		farm.getProductsAssigned().add(newProduct);
		farmDAO.save(farm);

		return farm;

	}

	@Transactional
	public Product assignProductToItem(int productID, int itemID) {

		Item it = itemDAO.findById(itemID).get();
		Product newProduct = prodDAO.findById(productID).get();

		newProduct.setItem(it);
		it.setProduct(newProduct);

		newProduct = prodDAO.save(newProduct);
		it = itemDAO.save(it);

		return newProduct;

	}



	@Override
	public Customer getCustomerLogin(String customerEmail, String customerPassword) {
		// TODO Auto-generated method stub
		return custDAO.findCustomerLogin(customerEmail, customerPassword);
	}

	@Override
	public Farmer getFarmerLogin(String farmerEmail, String farmerPassword) {
		// TODO Auto-generated method stub
		return farmDAO.findFarmerLogin(farmerEmail, farmerPassword);
	}

	@Override
	@Transactional
	public Set<Item> getItemsCustomers(int customerID) {
		Customer currentCustomer = custDAO.findById(customerID).get();
		int count = currentCustomer.getItemsCustomers().size();
		System.out.println("Customer ID: " + currentCustomer.getCustomerID() + "Customer Forename:"
				+ currentCustomer.getCustomerForename() + "Customer Surname:" + currentCustomer.getCustomerSurname()
				+ "customer Items" + count);

		Set<Item> Item = currentCustomer.getItemsCustomers();
		return Item;
	}
//
//	@Override
//	public Set<Item> getItemsCustomer(int customerID) {
//		// TODO Auto-generated method stub
//		return null;
//	}
//	

	@Override
	public Set<Checkout> getCustomerCheckouts(int customerID) {

		Customer currentCustomer = custDAO.findById(customerID).get();
		Checkout currentCustomerCheckouts = checkDAO.findById(customerID).get();
		System.out.println("customer ID: " + currentCustomer.getCustomerID() + "Checkout ID"
				+ currentCustomerCheckouts.getCheckoutID() + "Checkout Date: "
				+ currentCustomerCheckouts.getDeliveryDate() + "Checkout Total: "
				+ currentCustomerCheckouts.getTotalCost());

		Set<Checkout> Checkout = currentCustomer.getCustomerCheckouts();
		return Checkout;
	}

	@Override
	public Set<Product> getFarmerProducts(int farmerID) {
//		Product currentFarmerProducts = prodDAO.findById(farmerID).get();
		Farmer currentFarmer = farmDAO.findById(farmerID).get();
//		System.out.println("Farmer ID: " + currentFarmer.getFarmerID() + "Farmer Forename: "
//				+ currentFarmer.getFarmerForename() + "Farmer Surname: " + currentFarmer.getFarmerSurname()
//				+ "Products ID" + currentFarmerProducts.getProductID() + "Product Name"
//				+ currentFarmerProducts.getProductName() + "Product Description"
//				+ currentFarmerProducts.getProductDescription() + "Product Quantity: "
//				+ currentFarmerProducts.getProductQuantity() + "Product Price Per Unit "
//				+ currentFarmerProducts.getProductPrice());

		System.out.println(
				"Farmer ID: " + currentFarmer.getFarmerID() + "Product ID: " + currentFarmer.getProductsAssigned());
		Set<Product> Product = currentFarmer.getProductsAssigned();
		return Product;
	}



	@Override
	@Transactional
	public Product registerProductsForFarmers(int farmerID, Product newProduct) {
		newProduct = prodDAO.save(newProduct);
		assignFarmersToProducts(farmerID, newProduct.getProductID());
		return newProduct;
	}

	@Override
	@Transactional
	public Customer registerItemsForCustomers(int itemID, Customer newCustomer) {
		newCustomer = custDAO.save(newCustomer);
		assignItemsToCustomers(itemID, newCustomer.getCustomerID());
		return newCustomer;
	}

	@Override
	public Product registerProductAsItem(int itemID, Product newProduct) {
		return null;
	}

	@Override
	public Product getProductItem(int itemID) {


		return null;
	}

	@Override
	public Customer registerCheckoutsForCustomer(int customerID) {

		return null;
	}

	@Override
	@Transactional
	public Item registerItemsForBasket(int basketID, Item newItem) {
		newItem = itemDAO.save(newItem);
		assignBasketsToItems(basketID, newItem.getItemID());

		return newItem;
	}

	@Override
	@Transactional
	public Iterable<Item> findBasketItems(int basketID) {
		Basket currentBask = baskDAO.findById(basketID).get();
		int count = currentBask.getItemsAssigned().size();
		System.out.println("Basket found: " + currentBask.getBasketID() + " Items in Basket = " + count);

		Set<Item> Item = currentBask.getItemsAssigned();
		return Item;
	}

	@Override
	@Transactional
	public Set<Product> getBasketProducts(int basketID) {
		Basket currentBask = baskDAO.findById(basketID).get();
		int count = currentBask.getProductAssignedToBasket().size();
		System.out.println("Basket found: " + currentBask.getBasketID() + " Products in Basket =" + count);

		Set<Product> Product = currentBask.getProductAssignedToBasket();
		return Product;
	}

	@Override
	@Transactional
	public Product registerProductsForBasket(int basketID, Product newProd) {
		newProd = prodDAO.save(newProd);
		assignProductsToBasket(basketID, newProd.getProductID());
		return newProd;
	}

}
