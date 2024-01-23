package com.swp391.service;
import java.util.List;
import com.swp391.model.Products;
public interface IProductsService {
	
	// Ham add products
	public Products addProducts(Products products);
	
	// Ham edit products
	public Products updateProducts(String ID, Products products);
	
	// Ham delete products
	public boolean deleteProducts(String ID);
	
	// Ham select products
	public List<Products> getAllEProducts();
	

	
	// Ham sort Asc price
		public List<Products> getAllProductsSortedByPriceAsc();
		
		// Ham sort Desc price
		public List<Products> getAllProductsSortedByPriceDesc();
		
		// Ham sort Asc StockQuantity
		public List<Products> getAllProductsSortedByStockQuantityAsc();
		
		// Ham sort Desc StockQuantity
		public List<Products> getAllProductsSortedByStockQuantityDesc();
		
		// Ham sort Asc StockQuantity
		public List<Products> getAllProductsSortedByNameAsc();
		
		// Ham sort Desc StockQuantity
		public List<Products> getAllProductsSortedByNameDesc();

	
}
