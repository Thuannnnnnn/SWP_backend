package com.swp391.model;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name= "product_in_order")
public class product_in_order {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "record_id")
    private int record_id;
	
	@Column(name = "order_id")
	private int order_id;
	
	
	@Column(name = "product_id")
	private String product_id;
	
	@Column(name = "quantity")
	private String quantity;	
	
	@ManyToOne
    @JoinColumn(name = "product_id", nullable = false, insertable = false, updatable = false)
    @JsonManagedReference
    private Products products;  	
	
	public product_in_order() {
		
	}


	public product_in_order(int record_id, int order_id, String product_id, String quantity) {
		this.record_id = record_id;
		this.order_id = order_id;
		this.product_id = product_id;
		this.quantity = quantity;
	}


	public int getRecord_id() {
		return record_id;
	}


	public void setRecord_id(int record_id) {
		this.record_id = record_id;
	}


	public int getOrder_id() {
		return order_id;
	}


	public void setOrder_id(int order_id) {
		this.order_id = order_id;
	}


	public String getProduct_id() {
		return product_id;
	}


	public void setProduct_id(String product_id) {
		this.product_id = product_id;
	}


	public String getQuantity() {
		return quantity;
	}


	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}
	
	


	
	
	

}
