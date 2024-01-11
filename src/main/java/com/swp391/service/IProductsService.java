package com.swp391.service;

import java.util.List;


import com.swp391.model.Products;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

public interface IProductsService {
	
	// Ham add products
	public Products addProducts(Products products);
	
	// Ham edit products
	public Products updateProducts(String ID, Products products);
	
	// Ham delete products
	public boolean deleteProducts(String ID);
	
	// Ham select products
	public List<Products> getAllEProducts();
	
	// Ham select Top1 product
	public Products getOneProduct(String ID);

	public List<Products> getProducts();

	
}
