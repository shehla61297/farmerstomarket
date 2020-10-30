package com.mastek.farmertomarket.entities;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.ws.rs.FormParam;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

import org.springframework.data.annotation.Transient;

@XmlRootElement
@Entity 												// declares the class as entity, to be managed by JPA
@Table(name="ftom_farmer")	
public class Farmer {
	

	int farmerID;
	
	@FormParam("farmerEmail")
	String farmerEmail;

	@FormParam("farmLocation")
	String farmLocation;
	
	@FormParam("farmerForename")
	String farmerForename;
	
	@FormParam("farmerSurname")
	String farmerSurname;
	
	@FormParam("farmName")
	String farmName;
	
	@FormParam("farmType")
	FarmType FarmType;
	
	@FormParam("farmerUsername")
	String farmerUsername;
	
	@FormParam("farmerPassword")
	String farmerPassword;

	Set<Product> productsAssigned = new HashSet<>();
	
	@ManyToMany(cascade=CascadeType.ALL) // configure many to many association for entities
	@JoinTable(name="ftom_Farmer_Products",  // provide the join table name
			joinColumns= {@JoinColumn(name="fk_farmerID")}, 
			inverseJoinColumns = {@JoinColumn(name="fk_productId")} // foreign key column for collection type
			)
	@Transient // ignore this property when storing employee data in MongoDB
	@XmlTransient // ignore the association property when shared via Service
	public Set<Product> getProductsAssigned() {
		return productsAssigned;
	}

	public void setProductsAssigned(Set<Product> productsAssigned) {
		this.productsAssigned = productsAssigned;
	}

	
	@Id												    // Marking the property as primary key for the table 
	@Column(name="farmerID")							// using column to provide the default column name
	@GeneratedValue(strategy=GenerationType.AUTO)	
	public int getFarmerID() {
		return farmerID;
	}

	public void setFarmerID(int farmerID) {
		this.farmerID = farmerID;
	}

	public String getFarmLocation() {
		return farmLocation;
	}

	public void setFarmLocation(String farmLocation) {
		this.farmLocation = farmLocation;
	}

	public String getFarmerForename() {
		return farmerForename;
	}

	public void setFarmerForename(String farmerForename) {
		this.farmerForename = farmerForename;
	}

	public String getFarmerSurname() {
		return farmerSurname;
	}

	public void setFarmerSurname(String farmerSurname) {
		this.farmerSurname = farmerSurname;
	}

	public String getFarmName() {
		return farmName;
	}

	public void setFarmName(String farmName) {
		this.farmName = farmName;
	}

	@Enumerated(EnumType.STRING)
	public FarmType getFarmType() {
		return FarmType;
	}

	public void setFarmType(FarmType farmType) {
		this.FarmType = farmType;
	}

	public String getFarmerUsername() {
		return farmerUsername;
	}

	public void setFarmerUsername(String farmerUsername) {
		this.farmerUsername = farmerUsername;
	}

	public String getFarmerPassword() {
		return farmerPassword;
	}

	public void setFarmerPassword(String farmerPassword) {
		this.farmerPassword = farmerPassword;
	}

	public String getFarmerEmail() {
		return farmerEmail;
	}

	public void setFarmerEmail(String farmerEmail) {
		this.farmerEmail = farmerEmail;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + farmerID;
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
		Farmer other = (Farmer) obj;
		if (farmerID != other.farmerID)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Farmer [farmerID=" + farmerID + ", farmerEmail=" + farmerEmail + ", farmLocation=" + farmLocation
				+ ", farmerForename=" + farmerForename + ", farmerSurname=" + farmerSurname + ", farmName=" + farmName
				+ ", FarmType=" + FarmType + ", farmerUsername=" + farmerUsername + ", farmerPassword=" + farmerPassword
				+ ", productsAssigned=" + productsAssigned + "]";
	}
	
}
	
