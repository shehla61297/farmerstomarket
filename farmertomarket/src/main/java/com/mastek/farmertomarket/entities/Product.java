package com.mastek.farmertomarket.entities;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.ws.rs.FormParam;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

@XmlRootElement
@Entity 												// declares the class as entity, to be managed by JPA
@Table(name="ftom_product")
public class Product {
 
	
	
	@FormParam("productID")
	int productID;
	
	@FormParam("productName")
	String productName;
	
	@FormParam("productType")
	ProductType productType;
	
	@FormParam("productDescription")
	String productDescription;
	
	@FormParam("productPrice")
	double productPrice;
	
	@FormParam("productQuantity")
	int productQuantity;
	
	@FormParam("productWeightKG")
	double productWeightKG;
	
	Item Item;
	@OneToOne(mappedBy="product")
	@XmlTransient
	public Item getItem() {
		return Item;
	}

	public void setItem(Item item) {
		this.Item = item;
	}

	Set<Farmer> farmerProducts=  new HashSet<>();


	// Provide the property in Farmer with @ManyToMany and @JoinTable Configuration
	@ManyToMany(mappedBy="productsAssigned")
	@XmlTransient
	public Set<Farmer> getFarmerProducts() {
		return farmerProducts;
	}

	public void setFarmerProducts(Set<Farmer> farmerProducts) {
		this.farmerProducts = farmerProducts;
	}
	
	Set<Basket> basketProducts = new HashSet<>();

	@ManyToMany(mappedBy = "productAssignedToBasket")
	@XmlTransient
	public Set<Basket> getBasketProducts() {
		return basketProducts;
	}

	public void setBasketProducts(Set<Basket> basketProducts) {
		this.basketProducts = basketProducts;
	}

	@Id												    // Marking the property as primary key for the table 
	@Column(name="productID")							// using column to provide the default column name
	@GeneratedValue(strategy=GenerationType.AUTO)
	public int getProductID() {
		return productID;
	}


	public void setProductID(int productID) {
		this.productID = productID;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	@Enumerated(EnumType.STRING)
	public ProductType getProductType() {
		return productType;
	}

	public void setProductType(ProductType productType) {
		this.productType = productType;
	}

	public String getProductDescription() {
		return productDescription;
	}

	public void setProductDescription(String productDescription) {
		this.productDescription = productDescription;
	}

	public double getProductPrice() {
		return productPrice;
	}

	public void setProductPrice(double productPrice) {
		this.productPrice = productPrice;
	}

	public int getProductQuantity() {
		return productQuantity;
	}

	public void setProductQuantity(int productQuantity) {
		this.productQuantity = productQuantity;
	}

	public double getProductWeightKG() {
		return productWeightKG;
	}

	public void setProductWeightKG(double productWeightKG) {
		this.productWeightKG = productWeightKG;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((Item == null) ? 0 : Item.hashCode());
		result = prime * result + ((basketProducts == null) ? 0 : basketProducts.hashCode());
		result = prime * result + ((farmerProducts == null) ? 0 : farmerProducts.hashCode());
		result = prime * result + ((productDescription == null) ? 0 : productDescription.hashCode());
		result = prime * result + productID;
		result = prime * result + ((productName == null) ? 0 : productName.hashCode());
		long temp;
		temp = Double.doubleToLongBits(productPrice);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + productQuantity;
		result = prime * result + ((productType == null) ? 0 : productType.hashCode());
		temp = Double.doubleToLongBits(productWeightKG);
		result = prime * result + (int) (temp ^ (temp >>> 32));
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
		Product other = (Product) obj;
		if (Item == null) {
			if (other.Item != null)
				return false;
		} else if (!Item.equals(other.Item))
			return false;
		if (basketProducts == null) {
			if (other.basketProducts != null)
				return false;
		} else if (!basketProducts.equals(other.basketProducts))
			return false;
		if (farmerProducts == null) {
			if (other.farmerProducts != null)
				return false;
		} else if (!farmerProducts.equals(other.farmerProducts))
			return false;
		if (productDescription == null) {
			if (other.productDescription != null)
				return false;
		} else if (!productDescription.equals(other.productDescription))
			return false;
		if (productID != other.productID)
			return false;
		if (productName == null) {
			if (other.productName != null)
				return false;
		} else if (!productName.equals(other.productName))
			return false;
		if (Double.doubleToLongBits(productPrice) != Double.doubleToLongBits(other.productPrice))
			return false;
		if (productQuantity != other.productQuantity)
			return false;
		if (productType != other.productType)
			return false;
		if (Double.doubleToLongBits(productWeightKG) != Double.doubleToLongBits(other.productWeightKG))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Product [productID=" + productID + ", productName=" + productName + ", productType=" + productType
				+ ", productDescription=" + productDescription + ", productPrice=" + productPrice + ", productQuantity="
				+ productQuantity + ", productWeightKG=" + productWeightKG + ", Item=" + Item + ", farmerProducts="
				+ farmerProducts + ", basketProducts=" + basketProducts + "]";
	}

	
}
