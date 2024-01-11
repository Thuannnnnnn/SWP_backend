package com.swp391.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import com.swp391.model.Products;
import com.swp391.service.IProductsService; 

@RestController
@RequestMapping("/Product")
public class ProductsController {
	
	@Autowired
	private IProductsService iProductsService;
	//test	
	@GetMapping("/a")
	public String test() {
		return "Hellotung stu"; 
	}
	
	// API add Products
	@PostMapping("/add")
	public Products addProducts(@RequestBody Products products) {
		return iProductsService.addProducts(products);
	}
	
	// API update Products
	@PutMapping("/update")
	public Products updateProducts(@RequestParam("id") String id, @RequestBody Products products) {
		return iProductsService.updateProducts(id, products);
	}

	//API detele Products
	@DeleteMapping("/detele/{id}")
	public boolean deleteProducts(@PathVariable("id") String id) {
		return iProductsService.deleteProducts(id);
	}
	
	//API lay danh sach
	@GetMapping("/list")
	public String getAllProduct() {
		return iProductsService.getAllEProducts().get(0).getProduct_id();
	}
	
	//API lay danh sach
	@GetMapping("/feedBack")
	public List<Products> getAllFeedback() {
		return iProductsService.getAllEProducts();
	}
}
