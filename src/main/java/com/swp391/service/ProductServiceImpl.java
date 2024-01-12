package com.swp391.service;

import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.swp391.model.Products;
import com.swp391.repository.ProductsRepository;


@Service
public class ProductServiceImpl implements IProductsService{
	@Autowired
	private ProductsRepository productsRepository;
	
	
	public ProductServiceImpl() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public Products addProducts(Products products) {
		if(products != null) {
			return productsRepository.save(products);
		}
		return null;
	}
	
	@Override
	public Products updateProducts(String id, Products products) {
		if(products != null) {
			Products products1 = productsRepository.getById(id);
			if(products1 != null) {
				products1.setProduct_name(products.getProduct_name());
				products1.setDescription(products.getDescription());
				products1.setPrice(products.getPrice());
				products1.setDiscount_percentage(products.getDiscount_percentage());
				products1.setImage_url(products.getImage_url());
				products1.setStock_quantity(products1.getStock_quantity());
				products1.setCategory_id(products.getCategory_id());
				products1.setAuthor(products.getAuthor());
				products1.setDate_added(products.getDate_added());		
				return productsRepository.save(products1);
			}
		}
		return null;
	}
	@Override
	public boolean deleteProducts(String product_id) {
		if(product_id != null) {
			Products products = productsRepository.getById(product_id);
			if(products != null) {
				 productsRepository.deleteProductAndRelatedData(product_id);
				 return true;
			}
			return false;
		}
		return false;
		
	}

	@Override
	public List<Products> getAllEProducts() {
		return productsRepository.findAll();
	}
	

	@Override
	public Products getOneProduct(String id) {
		
		return productsRepository.getById(id);
	}

	@Override
	public List<Products> getProducts() {
		return productsRepository.findAll();
	}
	
}
