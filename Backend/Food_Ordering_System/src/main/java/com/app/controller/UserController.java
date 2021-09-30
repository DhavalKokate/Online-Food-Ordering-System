package com.app.controller;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.el.ArrayELResolver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.config.ConfigDataResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.app.custom_exceptions.UserHandlingException;
import com.app.dao.IOrderItemsDao;
import com.app.dto.ErrorResponse;
import com.app.model.Order;
import com.app.pojos.OrderItems;
import com.app.pojos.Products;
import com.app.pojos.ShippingAddress;
import com.app.pojos.User;
import com.app.service.IAddressService;
import com.app.service.IUserService;

@RestController
@RequestMapping("/user")
@CrossOrigin
public class UserController {
  @Autowired
  private IUserService userService;
  
  @Autowired
  private IAddressService addressService;
  
  @Autowired
  private IOrderItemsDao orderDao;

  
    @PostMapping
	public ResponseEntity<?> saveUser(@RequestBody User user)
	{
		System.out.println("in save products " + user);
		return new ResponseEntity<>(userService.saveUserDetails(user), HttpStatus.CREATED);
	}
    
    
    @GetMapping
	public List<User> fetchAllUser() {
		System.out.println("in get all users");
		return userService.getAllUser();
	}
    
    @GetMapping("/{id}")
    public ResponseEntity<?> fetchUserById(@PathVariable int id)
    {
    	return new ResponseEntity<>(userService.getUserDetailsById(id),HttpStatus.OK);
    }
    
    @PostMapping("/signin")
    public ResponseEntity<?> authenticateUser(@RequestBody User user) 
    {
		
			Optional<User> validateuser=userService.signIn(user);
			if(validateuser.isEmpty())
			{
				ErrorResponse resp=new ErrorResponse("Enter Valid Email or Password", LocalDateTime.now());
				return new ResponseEntity<>(resp, HttpStatus.CONFLICT);
			}
			return new ResponseEntity<>(validateuser.get(),HttpStatus.OK);
    }
    
    @PostMapping("/forgetPassword")
    public ResponseEntity<?> forgetUserPassword(@RequestBody User user) 
    {
			
			try {
				User validateuser=userService.forgetPassword(user);
				validateuser.setPassword(user.getPassword());
				userService.save(validateuser);
				return new ResponseEntity<>(validateuser,HttpStatus.OK);
			} catch (Exception e) {
				ErrorResponse resp=new ErrorResponse("Enter Valid Mobile Number", LocalDateTime.now());
				return new ResponseEntity<>(resp, HttpStatus.CONFLICT);
			}
    }
    
    
    @PutMapping()
	public ResponseEntity<?> updateUserDetails(@RequestBody User user)
	{
    	fetchUserById(user.get_id());
		return new ResponseEntity<>(userService.updateProfile(user),HttpStatus.OK);
	}
    
    @PostMapping("/order")
    public ResponseEntity<?> placeOrder(@RequestBody Order order) 
    {
    	try {
    		OrderItems[] orderItems= order.getOrderItems();
    		ShippingAddress shippingAddress=order.getShippingAddress();
    		int userId=order.getUser();
    		User user=userService.getUserDetailsById(userId).get();
    		ShippingAddress persistAddress=addressService.saveShippingAddress(shippingAddress);
    		user.setShippingAddress(persistAddress);
    		userService.saveUserDetails(user);
    		for(OrderItems o:orderItems) {
    			o.setUser(user);
    			orderDao.save(o);
    		}
    		  		
    	}catch(Exception e) {
    		
    	}
			
    	return null;
    }
}
