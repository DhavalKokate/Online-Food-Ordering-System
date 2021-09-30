package com.app.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.custom_exceptions.UserHandlingException;
import com.app.dao.IProductDao;
import com.app.pojos.Products;


@Service
@Transactional
public class ProductsServiceImpl implements IProductsService {

	@Autowired
	private IProductDao productDao;
	
	
	@Override
	public List<Products> getAllProducts() {
		  return productDao.findAll();
	}


	@Override
	public Products saveProductsDetails(Products transientProducts) {
		
		return productDao.save(transientProducts);
	}


	@Override
	public Products getProductsDetailsById(int productId) {
		return productDao.findById(productId).get();
	}


	@Override
	public String deleteProduct(int userId) {
		productDao.deleteById(userId);
		return "Product Details Deleted";
	
	}


	@Override
	public Products updateProductDetails(Products detachedProduct) {
		return productDao.save(detachedProduct);
	}

}
