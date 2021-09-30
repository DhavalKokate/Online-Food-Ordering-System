package com.app.dao;


import org.springframework.data.jpa.repository.JpaRepository;

import com.app.pojos.ShippingAddress;

public interface IAddressDao extends JpaRepository<ShippingAddress, Integer> {

}
