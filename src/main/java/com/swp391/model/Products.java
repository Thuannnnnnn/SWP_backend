package com.swp391.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

/**
 * 
 */
@Entity
@Table(name= "Products")
public class Products {
	
	@Id
	@Column(name = "product_id", updatable = false, nullable = false)
	private String productId;
	
	@Column(name = "product_name") 
	private String productName;
	
	@Column(name = "description")
	private String description;
	
	@Column(name = "price") 
	private float price;
	
	@Column(name = "discount_percentage")
	private float discountPercentage;
	
	@Column(name = "image_url")
	private String imageUrl;
	
	@Column(name = "stock_quantity")
	private int stockQuantity;
	
	@Column(name = "category_id")
	private int categoryId;
	
	@Column(name = "author")
	private String author;
	
	@Column(name = "date_added")
	private String dateAdded;

	@OneToMany(mappedBy = "products",cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference
    private List<Feedbacks> Feedbacks;
	
	@OneToMany(mappedBy = "products",cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference
    private List<product_in_order> product_in_order;
	
	public Products() {
	}


	public Products(String product_id, String product_name, String description, float price, float discount_percentage,
			String image_url, int stock_quantity, int category_id, String author, String date_added) {
		this.productId = product_id;
		this.productName = product_name;
		this.description = description;
		this.price = price;
		this.discountPercentage = discount_percentage;
		this.imageUrl = image_url;
		this.stockQuantity = stock_quantity;
		this.categoryId = category_id;
		this.author = author;
		this.dateAdded = date_added;
	}



	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}


	public String getProduct_id() {
		return productId;
	}




	public void setProduct_id(String product_id) {
		this.productId = product_id;
	}




	public String getProduct_name() {
		return productName;
	}

	public void setProduct_name(String product_name) {
		this.productName = product_name;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public float getDiscount_percentage() {
		return discountPercentage;
	}

	public void setDiscount_percentage(float discount_percentage) {
		this.discountPercentage = discount_percentage;
	}

	public String getImage_url() {
		return imageUrl;
	}

	public void setImage_url(String image_url) {
		this.imageUrl = image_url;
	}

	public int getStock_quantity() {
		return stockQuantity;
	}

	public void setStock_quantity(int stock_quantity) {
		this.stockQuantity = stock_quantity;
	}

	public int getCategory_id() {
		return categoryId;
	}

	public void setCategory_id(int category_id) {
		this.categoryId = category_id;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getDate_added() {
		return dateAdded;
	}

	public void setDate_added(String date_added) {
		this.dateAdded = date_added;
	}


	@Override
	public String toString() {
		return "Products [product_id=" + productId + ", product_name=" + productName + ", price=" + price
				+ ", stock_quantity=" + stockQuantity + "]";
	}


	
	
	
	
	
	
	
}
