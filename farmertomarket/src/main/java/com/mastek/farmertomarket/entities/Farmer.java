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
		result = prime * result + ((FarmType == null) ? 0 : FarmType.hashCode());
		result = prime * result + ((farmLocation == null) ? 0 : farmLocation.hashCode());
		result = prime * result + ((farmName == null) ? 0 : farmName.hashCode());
		result = prime * result + ((farmerEmail == null) ? 0 : farmerEmail.hashCode());
		result = prime * result + ((farmerForename == null) ? 0 : farmerForename.hashCode());
		result = prime * result + farmerID;
		result = prime * result + ((farmerPassword == null) ? 0 : farmerPassword.hashCode());
		result = prime * result + ((farmerSurname == null) ? 0 : farmerSurname.hashCode());
		result = prime * result + ((farmerUsername == null) ? 0 : farmerUsername.hashCode());
		result = prime * result + ((productsAssigned == null) ? 0 : productsAssigned.hashCode());
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
		if (FarmType != other.FarmType)
			return false;
		if (farmLocation == null) {
			if (other.farmLocation != null)
				return false;
		} else if (!farmLocation.equals(other.farmLocation))
			return false;
		if (farmName == null) {
			if (other.farmName != null)
				return false;
		} else if (!farmName.equals(other.farmName))
			return false;
		if (farmerEmail == null) {
			if (other.farmerEmail != null)
				return false;
		} else if (!farmerEmail.equals(other.farmerEmail))
			return false;
		if (farmerForename == null) {
			if (other.farmerForename != null)
				return false;
		} else if (!farmerForename.equals(other.farmerForename))
			return false;
		if (farmerID != other.farmerID)
			return false;
		if (farmerPassword == null) {
			if (other.farmerPassword != null)
				return false;
		} else if (!farmerPassword.equals(other.farmerPassword))
			return false;
		if (farmerSurname == null) {
			if (other.farmerSurname != null)
				return false;
		} else if (!farmerSurname.equals(other.farmerSurname))
			return false;
		if (farmerUsername == null) {
			if (other.farmerUsername != null)
				return false;
		} else if (!farmerUsername.equals(other.farmerUsername))
			return false;
		if (productsAssigned == null) {
			if (other.productsAssigned != null)
				return false;
		} else if (!productsAssigned.equals(other.productsAssigned))
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
	
