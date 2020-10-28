package com.mastek.farmertomarket;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.mastek.farmertomarket.dao.BasketJPADAO;
import com.mastek.farmertomarket.dao.CheckoutJPADAO;
import com.mastek.farmertomarket.dao.CustomerJPADAO;
import com.mastek.farmertomarket.dao.FarmerJPADAO;
import com.mastek.farmertomarket.dao.ItemJPADAO;
import com.mastek.farmertomarket.dao.ProductJPADAO;
import com.mastek.farmertomarket.dao.TransactionJPADAO;
import com.mastek.farmertomarket.services.FarmerToMarketService;

//Initialize the JUnit Test with Spring Boot Application Environment
//Spring Boot Test: used to test Spring APplicationContext 
//with all the test cases idenitfied
@SpringBootTest
class FarmertomarketApplicationTests {
	
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
	
	@Autowired
	FarmerToMarketService ftomSvc;
}
	
//	@Test
//	void testCheckoutDAOAdd() {
//		Checkout check = new Checkout();
//		check.setDeliveryDate("21/09/2020");
//		check.setTotalCost(22.29);
//		
//		check = checkDAO.save(check);
//	}
//	@Test
//	void testBasketDAOAdd() {
//		Basket bask = new Basket();
//		bask.setBasketAmount(25);
//
//		bask = baskDAO.save(bask);
//	}
//
//	@Test
//	void testCustomerDAOAdd() {
//		Customer cust = new Customer();
//		cust.setCustomerForename("Marienne");
//		cust.setCustomerSurname("Goldsmith");
//		cust.setCustomerDOB("19/01/1994");
//		cust.setCustomerUsername("m.smith");
//		cust.setCustomerAddress("22 Lune Street, Leeds, LS11PA");
//		cust.setCustomerPassword("786786");
//		cust.setCustomerEmail("mgoldsmith94@gmail.com");
//		cust = custDAO.save(cust);
//		
//	}
//	
//	@Test
//	void testFarmerDAOAdd() {
//		Farmer farm = new Farmer();
//		farm.setFarmerForename("Harry");
//		farm.setFarmerSurname("Prince");
//		farm.setFarmLocation("Ormskirk");
//		farm.setFarmName("Berry Knot Farm");
//		farm.setFarmType(FarmType.MIXED);
//		farm.setFarmerUsername("BerryKnotFarm");
//		farm.setFarmerPassword("BKnot123");
//		farm.setFarmerEmail("HPrince123@example.com");
//		
//		farm = farmDAO.save(farm);
//	}
//	@Test
//	void testItemDAOAdd() {
//		Item it = new Item();
//		it.setItemName("Potatoes");
//		it.setItemPrice(0.59);
//		it.setItemQuantity(10.00);
//		
//		it = itemDAO.save(it);
//		
//	}
//	@Test
//	void testProductDAOAdd() {
//		Product prod = new Product();
//		prod.setProductName("Potatoes");
//		prod.setProductType(ProductType.VEGETABLES);
//		prod.setProductDescription("White potatoes");
//		prod.setProductPrice(0.59);
//		prod.setProductQuantity(100);
//		prod.setProductWeightKG(5.00);
//		
//		prod = prodDAO.save(prod);
//	}
//	
//	@Test
//	void testTransactionDAOAdd() {
//		Transaction tran = new Transaction();
//		tran.setTransactionDate("22/09/2020");
//		tran.setTransactionAmount(10.00);
//		
//		tran = tranDAO.save(tran);
//	}
//	
//	@Test
//	void testAssignCheckoutToCustomers() {
//		Checkout check = ftomSvc.assignCheckoutToCustomers(25, 6);
//		 
//		assertNotNull(check.getCurrentCustomer(), "Checkout Not Assigned");
//		
//		 
//		System.out.println("Checkout assigned to customer");
//	}
//	
//
//
//	@Test
//	void testAssignProductToBasket() {
//		Basket bask = ftomSvc.assignProductsToBasket(24, 70);
//
//		assertNotNull(bask.getProductAssignedToBasket(), "Basket Not Assigned");
//
//		System.out.println("Product Assigned to basket");
//	}
//}
//
//	@Test
//	void testAssignTransactionToCheckout() {
//
//		Transaction tran = ftomSvc.assignTransactionToCheckout(19, 73);
//		assertNotNull(tran.getTransactionID(), "Transaction Not Assigned");
//
//		System.out.println("Transaction assigned to checkout");
//	}
//
//	@Test
//	void testAssignBasketsToItems() {
//
//		Basket bask = ftomSvc.assignBasketsToItems(10, 35);
//
//		assertNotNull(bask.getItemsAssigned(), "Basket Not Assigned");
//
//		System.out.println("Basket assigned to items");
//	}
//
//	@Test
//	void testAssignItemsToCustomers() {
//
//		Item it = ftomSvc.assignItemsToCustomers(76, 6);
//
//		assertNotNull(it.getCustomersAssigned(), "Customer  Not Assigned");
//		System.out.println("Customer assigned to items");
//	}
//
//	@Test
//	void testAssignFarmersToProducts() {
//
//		Farmer farm = ftomSvc.assignFarmersToProducts(46, 1);
//
//		assertNotNull(farm.getProductsAssigned(), "Farmer  Not Assigned");
//
//		System.out.println("Farmer assigned to Products");
//	}
//
//	@Test
//	void testAssignProductToItem() {
//
//		Product prod = ftomSvc.assignProductToItem(48, 99);
//
//		assertNotNull(prod.getItem(), "Product  Not Assigned");
//
//
//	}
//
//	@Test
//	void testUpdateItemDAO() {
//		Item it = itemDAO.findById(14).get();
//		System.out.println("Item Details Fetched");
//		it.setItemName("Pears");
//		it.setItemPrice(0.33);
//		it.setItemQuantity(50);
//
//		System.out.println("Item Details Updated.");
//
//		it = itemDAO.save(it);
//
//	}
//
//	@Test
//	void testUpdateFarmerDAO() {
//		Farmer farm = farmDAO.findById(9).get();
//		System.out.println("Farmer Details Fetched");
//		farm.setFarmName("Silversage Acres");
//		farm.setFarmerForename("Hermione");
//		farm.setFarmerSurname("Granger");
//		farm.setFarmLocation("Lancashire");
//		farm.setFarmerUsername("SAcresFarm12");
//		farm.setFarmerPassword("SAcres111");
//
//		System.out.println("Farm information updated");
//
//		farm = farmDAO.save(farm);
//	}
//
//	@Test
//	void testUpdateProductDAO() {
//		Product prod = prodDAO.findById(8).get();
//		System.out.println("Product Details Fetched");
//		prod.setProductName("Apples");
//		prod.setProductDescription("Granny Smith, green apples!");
//		prod.setProductType(ProductType.FRUIT);
//		prod.setProductPrice(0.35);
//		prod.setProductQuantity(10);
//		prod.setProductWeightKG(2);
//
//		System.out.println("Product Details Updated");
//
//		prod = prodDAO.save(prod);
//}
//
//	@Test
//	void testUpdateTransactionDAO() {
//		Transaction tran = tranDAO.findById(12).get();
//		System.out.println("Transaction Details Fetched");
//
//		tran.setTransactionDate("11/09/2020");
//		tran.setTransactionAmount(55.55);
//
//		System.out.println("Transaction Details Updated.");
//		tran = tranDAO.save(tran);
//	}
//
//	@Test
//	void testUpdateCustomerDAO() {
//		Customer cust = custDAO.findById(6).get();
//		System.out.println("Customer Details Fetched");
//		cust.setCustomerAddress("25 Wellington Street, Dewsbury, WF131HF");
//		cust.setCustomerBalance(25.00);
//		cust.setCustomerUsername("DAdams91");
//		cust.setCustomerForename("Daisy");
//		cust.setCustomerSurname("Adams");
//		cust.setCustomerDOB("11/11/1991");
//
//		System.out.println("Customers forename, surname and DOB updated.");
//		cust = custDAO.save(cust);
//	}
//
//	@Test
//	void testUpdateCheckoutDAO() {
//		Checkout check = checkDAO.findById(4).get();
//		System.out.println("Checkout Details Fetched");
//		check.setDeliveryDate("19/09/2020");
//		check.setTotalCost(20.00);
//
//		System.out.println("Checkout details updated.");
//
//		check = checkDAO.save(check);
//
//	}
//
//}