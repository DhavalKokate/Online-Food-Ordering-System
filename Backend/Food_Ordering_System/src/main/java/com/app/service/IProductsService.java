package com.app.service;

import java.util.List;

import com.app.pojos.Products;
import com.app.pojos.User;

public interface IProductsService {
    List<Products> getAllProducts();
    
    Products saveProductsDetails(Products transientProducts);
    
    Products getProductsDetailsById(int productId);
    
    String deleteProduct(int userId);
    
    Products updateProductDetails(Products detachedProduct);
    
    
    
    
    
    
}
