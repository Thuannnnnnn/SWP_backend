package com.swp391.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "feedbacks")
public class Feedbacks {


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	@Column(name = "feedback_id")
	private int feedback_id;

	@Column(name = "user_id", insertable = false, updatable = false)
	private long user_id;
	
	@Column(name = "product_id")
	private String product_id;

	@Column(name = "comments")
	private String comments;

	@Column(name = "rating")
	private int rating;

	@Column(name = "date_posted")
	private String date_posted;

	@ManyToOne
    @JoinColumn(name = "user_id", nullable = false, insertable = false, updatable = false)
    @JsonManagedReference
    private Users users;
	
	@OneToMany(mappedBy = "reply_id",cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference
    private List<ReplyComment> replycomments;
	
	public Feedbacks() {

	}

	public Feedbacks(int feedback_id, long user_id, String product_id, String comments, int rating,
			String date_posted) {
		this.feedback_id = feedback_id;
		this.user_id = user_id;
		this.product_id = product_id;
		this.comments = comments;
		this.rating = rating;
		this.date_posted = date_posted;
	}

	public int getFeedback_id() {
		return feedback_id;
	}

	public void setFeedback_id(int feedback_id) {
		this.feedback_id = feedback_id;
	}

	public long getUser_id() {
		return user_id;
	}

	public void setUser_id(long user_id) {
		this.user_id = user_id;
	}

	public String getProduct_id() {
		return product_id;
	}

	public void setProduct_id(String product_id) {
		this.product_id = product_id;
	}

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}

	public String getData_posted() {
		return date_posted;
	}

	public void setData_posted(String data_posted) {
		this.date_posted = data_posted;
	}

}
