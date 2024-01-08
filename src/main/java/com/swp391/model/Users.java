package com.swp391.model;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Users {
	 @Id
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
	 private int user_id;
	 private String full_name;
	 private String birth_date;
	 private String phone_number;
	 private String email;
	 private String passwords;
	 private String address;
	 private String user_role;
	 
	 public Users() {
		// TODO Auto-generated constructor stub
	}
	 
	public Users(int user_id, String full_name, String birth_date, String phone_number, String email, String passwords,
			String address, String user_role) {
		super();
		this.user_id = user_id;
		this.full_name = full_name;
		this.birth_date = birth_date;
		this.phone_number = phone_number;
		this.email = email;
		this.passwords = passwords;
		this.address = address;
		this.user_role = user_role;
	}

	public int getUserID() {
		return user_id;
	}
	public void setUserID(int userID) {
		user_id = userID;
	}
	public String getFull_name() {
		return full_name;
	}
	public void setFull_name(String full_name) {
		this.full_name = full_name;
	}
	public String getBirth_date() {
		return birth_date;
	}
	public void setBirth_date(String birth_date) {
		this.birth_date = birth_date;
	}
	public String getPhone_number() {
		return phone_number;
	}
	public void setPhone_number(String phone_number) {
		this.phone_number = phone_number;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPasswords() {
		return passwords;
	}
	public void setPasswords(String passwords) {
		this.passwords = passwords;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getUser_role() {
		return user_role;
	}
	public void setUser_role(String user_role) {
		this.user_role = user_role;
	}
	 
}
	