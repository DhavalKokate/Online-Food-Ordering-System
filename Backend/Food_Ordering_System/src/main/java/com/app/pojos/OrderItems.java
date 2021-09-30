package com.app.pojos;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.ManyToAny;

@Entity
@Table(name="orderItems_tbl")
public class OrderItems extends BaseEntity{
     @Column(length = 50,nullable = false)
	 private String name;
	 private int qty;
     @Column(length = 50)
	 private String images;
	 private double price;	 
	 private int product;

	 
	 @ManyToOne
	 @JoinColumn(name="user_id")
	 private User user;
	 
	 public OrderItems() {
		// TODO Auto-generated constructor stub
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getQty() {
		return qty;
	}
	public void setQty(int qty) {
		this.qty = qty;
	}
	public String getImages() {
		return images;
	}
	public void setImages(String images) {
		this.images = images;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public int getProduct() {
		return product;
	}
	public void setProduct(int product) {
		this.product = product;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	@Override
	public String toString() {
		return "OrderItems [name=" + name + ", qty=" + qty + ", images=" + images + ", price=" + price + ", product="
				+ product + ", user=" + user + "]";
	}

	
	 
}
