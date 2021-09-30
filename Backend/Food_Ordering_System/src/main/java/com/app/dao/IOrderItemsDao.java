package com.app.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.pojos.OrderItems;

public interface IOrderItemsDao extends JpaRepository<OrderItems, Integer> {

}
