package com.swp391.model;

import java.util.List;

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
	private String product_id;
	
	@Column(name = "product_name") 
	private String product_name;
	
	@Column(name = "description")
	private String description;
	
	@Column(name = "price") 
	private float price;
	
	@Column(name = "discount_percentage")
	private float discount_percentage;
	
	@Column(name = "image_url")
	private String image_url;
	
	@Column(name = "stock_quantity")
	private int stock_quantity;
	
	@Column(name = "category_id")
	private int category_id;
	
	@Column(name = "author")
	private String author;
	
	@Column(name = "date_added")
	private String date_added;

	public Products() {
	}


	public Products(String product_id, String product_name, String description, float price, float discount_percentage,
			String image_url, int stock_quantity, int category_id, String author, String date_added) {
		this.product_id = product_id;
		this.product_name = product_name;
		this.description = description;
		this.price = price;
		this.discount_percentage = discount_percentage;
		this.image_url = image_url;
		this.stock_quantity = stock_quantity;
		this.category_id = category_id;
		this.author = author;
		this.date_added = date_added;
	}



	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}


	public String getProduct_id() {
		return product_id;
	}




	public void setProduct_id(String product_id) {
		this.product_id = product_id;
	}




	public String getProduct_name() {
		return product_name;
	}

	public void setProduct_name(String product_name) {
		this.product_name = product_name;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public float getDiscount_percentage() {
		return discount_percentage;
	}

	public void setDiscount_percentage(float discount_percentage) {
		this.discount_percentage = discount_percentage;
	}

	public String getImage_url() {
		return image_url;
	}

	public void setImage_url(String image_url) {
		this.image_url = image_url;
	}

	public int getStock_quantity() {
		return stock_quantity;
	}

	public void setStock_quantity(int stock_quantity) {
		this.stock_quantity = stock_quantity;
	}

	public int getCategory_id() {
		return category_id;
	}

	public void setCategory_id(int category_id) {
		this.category_id = category_id;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getDate_added() {
		return date_added;
	}

	public void setDate_added(String date_added) {
		this.date_added = date_added;
	}
	
	
	
	
	
}
