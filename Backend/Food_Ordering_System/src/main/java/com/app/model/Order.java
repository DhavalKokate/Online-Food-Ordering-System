package com.app.model;

import java.util.Arrays;

import com.app.pojos.OrderItems;
import com.app.pojos.ShippingAddress;

public class Order {
	private OrderItems[] orderItems;
	private ShippingAddress shippingAddress;
	private int user;

	public Order() {
		// TODO Auto-generated constructor stub
	}

	public Order(OrderItems[] orderItems, ShippingAddress shippingAddress, int user) {
		super();
		this.orderItems = orderItems;
		this.shippingAddress = shippingAddress;
		this.user = user;
	}

	public OrderItems[] getOrderItems() {
		return orderItems;
	}

	public void setOrderItems(OrderItems[] orderItems) {
		this.orderItems = orderItems;
	}

	public ShippingAddress getShippingAddress() {
		return shippingAddress;
	}

	public void setShippingAddress(ShippingAddress shippingAddress) {
		this.shippingAddress = shippingAddress;
	}

	public int getUser() {
		return user;
	}

	public void setUser(int user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return "Order [orderItems=" + Arrays.toString(orderItems) + ", shippingAddress=" + shippingAddress + ", user="
				+ user + "]";
	}

}
