package com.mastek.farmertomarket.entities;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.ws.rs.FormParam;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

import org.springframework.data.annotation.Transient;

@XmlRootElement
@Entity 												// declares the class as entity, to be managed by JPA
@Table(name="ftom_item")
@NamedQueries({
		@NamedQuery(name = "basket.findBasketID", query = "select b from Basket b where b.basketID=:basketID") })
public class Item {
	
		

	int itemID;
	
	@FormParam("itemName")
	String itemName;
	
	@FormParam("itemQuantity")
	double itemQuantity;
	
	@FormParam("itemPrice")
	double itemPrice;
	
	Set<Basket> basketItems= new HashSet<>();
	
	//provide the property in Item with @ManyToMany and @JoinTable configurations
	@ManyToMany(mappedBy="itemsAssigned")
	@XmlTransient
	public Set<Basket> getBasketItems() {
		return basketItems;
	}

	public void setBasketItems(Set<Basket> basketItems) {
		this.basketItems = basketItems;
	}

	Set<Customer> customersAssigned = new HashSet<>();
	// provide the property in Item with @ManyToMany and @JoinTable configurations
	@ManyToMany(cascade = CascadeType.ALL) // configure many to many association for entities
	@JoinTable(name = "ftom_items_customers", // provide the join table name
			joinColumns = { @JoinColumn(name = "fk_customerID") }, inverseJoinColumns = {
					@JoinColumn(name = "fk_itemID") }) // foreign key column for collection type
	@Transient
	@XmlTransient
	public Set<Customer> getCustomersAssigned() {
		return customersAssigned;
	}

	public void setCustomersAssigned(Set<Customer> customersAssigned) {
		this.customersAssigned = customersAssigned;
	}

	Product Product;


	@OneToOne(fetch=FetchType.EAGER)
	@XmlTransient
	@JoinColumn(name="productID")
	public Product getProduct() {
		return Product;
	}

	public void setProduct(Product product) {
		this.Product = product;
	}
	
	@Id												    // Marking the property as primary key for the table 
	@Column(name="itemID")							// using column to provide the default column name
	@GeneratedValue(strategy=GenerationType.AUTO)
	public int getItemID() {
		return itemID;
	}


	public void setItemID(int itemID) {
		this.itemID = itemID;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public double getItemQuantity() {
		return itemQuantity;
	}

	public void setItemQuantity(double itemQuantity) {
		this.itemQuantity = itemQuantity;
	}

	public double getItemPrice() {
		return itemPrice;
	}

	public void setItemPrice(double itemPrice) {
		this.itemPrice = itemPrice;
	}

	@Override
	public String toString() {
		return "Item [itemID=" + itemID + ", itemName=" + itemName + ", itemQuantity=" + itemQuantity + ", itemPrice="
				+ itemPrice + ", basketItems=" + basketItems + ", customersAssigned=" + customersAssigned + ", Product="
				+ Product + "]";
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + itemID;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Item other = (Item) obj;
		if (itemID != other.itemID)
			return false;
		return true;
	}

	

}
