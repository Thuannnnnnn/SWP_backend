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
		return "Hello thuan khung, tung stu"; 
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
	
	public List<Products> getAllProduct() {
		return iProductsService.getAllEProducts();
	}
	
	//API lay danh sach
	@GetMapping("/feedBack")
	public List<Products> getAllFeedback() {
		return iProductsService.getAllEProducts();
	}
	
	@GetMapping("/sortAscPrice")
	public String getSortAscPrice() {
	    List<Products> sortedProducts = iProductsService.getAllProductsSortedByPriceAsc();

	    StringBuilder result = new StringBuilder();
	    for (Products product : sortedProducts) {
	        result.append(product.toString()).append("<br>");
	    }

	    return result.toString();
	}
	
	@GetMapping("/sortDescPrice")
	public String getSortDescPrice() {
	    List<Products> sortedProducts = iProductsService.getAllProductsSortedByPriceDesc();

	    StringBuilder result = new StringBuilder();
	    for (Products product : sortedProducts) {
	        result.append(product.toString()).append("<br>");
	    }

	    return result.toString();
	}
	
	@GetMapping("/sortAscName")
	public String getSortName() {
	    List<Products> sortedProducts = iProductsService.getAllProductsSortedByNameAsc();

	    StringBuilder result = new StringBuilder();
	    for (Products product : sortedProducts) {
	        result.append(product.toString()).append("<br>");
	    }

	    return result.toString();
	}
	
	@GetMapping("/sortDescName")
	public String getSortDescName() {
	    List<Products> sortedProducts = iProductsService.getAllProductsSortedByNameDesc();

	    StringBuilder result = new StringBuilder();
	    for (Products product : sortedProducts) {
	        result.append(product.toString()).append("<br>");
	    }

	    return result.toString();
	}
	
	@GetMapping("/sortAscStockQuantity")
	public String getSortAscStockQuantity() {
	    List<Products> sortedProducts = iProductsService.getAllProductsSortedByStockQuantityAsc();

	    StringBuilder result = new StringBuilder();
	    for (Products product : sortedProducts) {
	        result.append(product.toString()).append("<br>");
	    }

	    return result.toString();
	}
	
	@GetMapping("/sortDescStockQuantity")
	public String getSortDescStockQuantity() {
	    List<Products> sortedProducts = iProductsService.getAllProductsSortedByStockQuantityDesc();

	    StringBuilder result = new StringBuilder();
	    for (Products product : sortedProducts) {
	        result.append(product.toString()).append("<br>");
	    }

	    return result.toString();
	}
	

}
