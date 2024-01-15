package com.swp391.model;

import java.util.List;

import org.apache.catalina.User;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

@Entity(name = "Orders")
@JsonIgnoreProperties({"users"})
public class Orders {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long order_id;
	private long user_id;
	private String delivery_address;
	private String phone_number;
	private String recipient_name;
	private String payment_method;
	private Double total_price;
	private String order_status;
	private String time_buy;
	
	@ManyToOne
    @JoinColumn(name = "user_id", nullable = false, insertable = false, updatable = false)
    private Users users;
	
	@OneToMany(mappedBy = "orders",cascade = CascadeType.ALL, orphanRemoval = true)
    private List<product_in_order> product_in_order;

	public Orders() {

	}

	public Orders(long order_id, long user_id, String delivery_address, String phone_number, String recipient_name,
			String payment_method, Double total_price, String order_status, String time_buy) {
		this.order_id = order_id;
		this.user_id = user_id;
		this.delivery_address = delivery_address;
		this.phone_number = phone_number;
		this.recipient_name = recipient_name;
		this.payment_method = payment_method;
		this.total_price = total_price;
		this.order_status = order_status;
		this.time_buy = time_buy;
	}

	public long getOrder_id() {
		return order_id;
	}

	public void setOrder_id(long order_id) {
		this.order_id = order_id;
	}

	public long getUser_id() {
		return user_id;
	}

	public void setUser_id(long user_id) {
		this.user_id = user_id;
	}

	public String getDelivery_address() {
		return delivery_address;
	}

	public void setDelivery_address(String delivery_address) {
		this.delivery_address = delivery_address;
	}

	public String getPhone_number() {
		return phone_number;
	}

	public Users getUsers() {
		return users;
	}

	public void setUsers(Users users) {
		this.users = users;
	}

	public void setPhone_number(String phone_number) {
		this.phone_number = phone_number;
	}

	public String getRecipient_name() {
		return recipient_name;
	}

	public void setRecipient_name(String recipient_name) {
		this.recipient_name = recipient_name;
	}

	public String getPayment_method() {
		return payment_method;
	}

	public void setPayment_method(String payment_method) {
		this.payment_method = payment_method;
	}

	public Double getTotal_price() {
		return total_price;
	}

	public void setTotal_price(Double total_price) {
		this.total_price = total_price;
	}

	public String getOrder_status() {
		return order_status;
	}

	public void setOrder_status(String order_status) {
		this.order_status = order_status;
	}

	public String getTime_buy() {
		return time_buy;
	}

	public void setTime_buy(String time_buy) {
		this.time_buy = time_buy;
	}

}
