package com.app.pojos;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="shippingAddress_tbl")
public class ShippingAddress extends BaseEntity {
	private String fullName;
	@Column(length = 50)
	private String address;
	@Column(length = 50)
	private String city;
	@Column(length = 50)
	private String postalCode;
	@Column(length = 50)
	private String country;
	
	public ShippingAddress() {
		// TODO Auto-generated constructor stub
	}

	public ShippingAddress(String fullName, String address, String city, String postalCode, String country) {
		super();
		this.fullName = fullName;
		this.address = address;
		this.city = city;
		this.postalCode = postalCode;
		this.country = country;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getPostalCode() {
		return postalCode;
	}

	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	@Override
	public String toString() {
		return "ShippingAddress [fullName=" + fullName + ", address=" + address + ", city=" + city + ", postalCode="
				+ postalCode + ", country=" + country + "]";
	}
	
}
