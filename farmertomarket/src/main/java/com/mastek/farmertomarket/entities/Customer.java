package com.mastek.farmertomarket.entities;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.ws.rs.FormParam;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

@XmlRootElement
@Entity 												// declares the class as entity, to be managed by JPA
@Table(name="ftom_customer")
public class Customer {
	
	
	


	int customerID;
	
	@FormParam("customerEmail")
	String customerEmail;

	@FormParam("customerForename")
	String customerForename;
	
	@FormParam("customerSurname")
	String customerSurname;
	
	@FormParam("customerAddress")
	String customerAddress;
	
	@FormParam("customerBalance")
	double customerBalance;
	
	@FormParam("customerDOB")
	String customerDOB;
	
	@FormParam("customerUsername")
	String customerUsername;
	
	@FormParam("customerPassword")
	String customerPassword;

	Set<Checkout> customerCheckouts = new HashSet<>();

	@OneToMany(mappedBy = "currentCustomer", cascade = CascadeType.ALL)
	@XmlTransient
	public Set<Checkout> getCustomerCheckouts() {
		return customerCheckouts;
	}

	public void setCustomerCheckouts(Set<Checkout> customerCheckouts) {
		this.customerCheckouts = customerCheckouts;
	}

	Set<Item> itemsCustomers = new HashSet<>();

	@ManyToMany(mappedBy = "customersAssigned")
	@XmlTransient
	public Set<Item> getItemsCustomers() {
		return itemsCustomers;
	}

	public void setItemsCustomers(Set<Item> ItemsCustomers) {
		this.itemsCustomers = ItemsCustomers;
	}
	@Id												    // Marking the property as primary key for the table 
	@Column(name="customerID")							// using column to provide the default column name
	@GeneratedValue(strategy=GenerationType.AUTO)
	public int getCustomerID() {
		return customerID;
	}


	public void setCustomerID(int customerID) {
		this.customerID = customerID;
	}

	public String getCustomerForename() {
		return customerForename;
	}

	public void setCustomerForename(String customerForename) {
		this.customerForename = customerForename;
	}

	public String getCustomerSurname() {
		return customerSurname;
	}

	public void setCustomerSurname(String customerSurname) {
		this.customerSurname = customerSurname;
	}

	public String getCustomerAddress() {
		return customerAddress;
	}

	public void setCustomerAddress(String customerAddress) {
		this.customerAddress = customerAddress;
	}

	public double getCustomerBalance() {
		return customerBalance;
	}

	public void setCustomerBalance(double customerBalance) {
		this.customerBalance = customerBalance;
	}

	public String getCustomerDOB() {
		return customerDOB;
	}

	public void setCustomerDOB(String customerDOB) {
		this.customerDOB = customerDOB;
	}

	public String getCustomerUsername() {
		return customerUsername;
	}

	public void setCustomerUsername(String customerUsername) {
		this.customerUsername = customerUsername;
	}

	public String getCustomerPassword() {
		return customerPassword;
	}

	public void setCustomerPassword(String customerPassword) {
		this.customerPassword = customerPassword;
	}



	public String getCustomerEmail() {
		return customerEmail;
	}

	public void setCustomerEmail(String customerEmail) {
		this.customerEmail = customerEmail;
	}

	public Checkout setCheckout(Checkout check) {
		// TODO Auto-generated method stub
		return check;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((customerAddress == null) ? 0 : customerAddress.hashCode());
		long temp;
		temp = Double.doubleToLongBits(customerBalance);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((customerCheckouts == null) ? 0 : customerCheckouts.hashCode());
		result = prime * result + ((customerDOB == null) ? 0 : customerDOB.hashCode());
		result = prime * result + ((customerEmail == null) ? 0 : customerEmail.hashCode());
		result = prime * result + ((customerForename == null) ? 0 : customerForename.hashCode());
		result = prime * result + customerID;
		result = prime * result + ((customerPassword == null) ? 0 : customerPassword.hashCode());
		result = prime * result + ((customerSurname == null) ? 0 : customerSurname.hashCode());
		result = prime * result + ((customerUsername == null) ? 0 : customerUsername.hashCode());
		result = prime * result + ((itemsCustomers == null) ? 0 : itemsCustomers.hashCode());
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
		Customer other = (Customer) obj;
		if (customerAddress == null) {
			if (other.customerAddress != null)
				return false;
		} else if (!customerAddress.equals(other.customerAddress))
			return false;
		if (Double.doubleToLongBits(customerBalance) != Double.doubleToLongBits(other.customerBalance))
			return false;
		if (customerCheckouts == null) {
			if (other.customerCheckouts != null)
				return false;
		} else if (!customerCheckouts.equals(other.customerCheckouts))
			return false;
		if (customerDOB == null) {
			if (other.customerDOB != null)
				return false;
		} else if (!customerDOB.equals(other.customerDOB))
			return false;
		if (customerEmail == null) {
			if (other.customerEmail != null)
				return false;
		} else if (!customerEmail.equals(other.customerEmail))
			return false;
		if (customerForename == null) {
			if (other.customerForename != null)
				return false;
		} else if (!customerForename.equals(other.customerForename))
			return false;
		if (customerID != other.customerID)
			return false;
		if (customerPassword == null) {
			if (other.customerPassword != null)
				return false;
		} else if (!customerPassword.equals(other.customerPassword))
			return false;
		if (customerSurname == null) {
			if (other.customerSurname != null)
				return false;
		} else if (!customerSurname.equals(other.customerSurname))
			return false;
		if (customerUsername == null) {
			if (other.customerUsername != null)
				return false;
		} else if (!customerUsername.equals(other.customerUsername))
			return false;
		if (itemsCustomers == null) {
			if (other.itemsCustomers != null)
				return false;
		} else if (!itemsCustomers.equals(other.itemsCustomers))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Customer [customerID=" + customerID + ", customerEmail=" + customerEmail + ", customerForename="
				+ customerForename + ", customerSurname=" + customerSurname + ", customerAddress=" + customerAddress
				+ ", customerBalance=" + customerBalance + ", customerDOB=" + customerDOB + ", customerUsername="
				+ customerUsername + ", customerPassword=" + customerPassword + ", customerCheckouts="
				+ customerCheckouts + ", itemsCustomers=" + itemsCustomers + "]";
	}

}
