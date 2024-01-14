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
@Table(name= "replycomments")
public class ReplyComment {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "reply_id")
    private int reply_id;
	
	@Column(name = "feedback_id")
	private int feedback_id;
	
	@Column(name = "user_id")
	private long userid;
	
	@Column(name = "reply_text")
	private String rely_text;
	
	@Column(name = "date_replied")
	private String dateReplied;	
	
	@ManyToOne
    @JoinColumn(name = "feedback_id", nullable = false, insertable = false, updatable = false)
    @JsonManagedReference
    private Feedbacks Feedbacks;
	
	
	public ReplyComment() {
		
	}
	
	public ReplyComment(int feedback_id, long userid, String rely_text, String dateReplied) {
		this.feedback_id = feedback_id;
		this.userid = userid;
		this.rely_text = rely_text;
		this.dateReplied = dateReplied;
	}

	
	
	public int getFeedback_id() {
		return feedback_id;
	}

	public void setFeedback_id(int feedback_id) {
		this.feedback_id = feedback_id;
	}

	public int getReply_id() {
		return reply_id;
	}

	public void setReply_id(int reply_id) {
		this.reply_id = reply_id;
	}
	

	public long getUserid() {
		return userid;
	}

	public void setUserid(long userid) {
		this.userid = userid;
	}

	public String getRely_text() {
		return rely_text;
	}

	public void setRely_text(String rely_text) {
		this.rely_text = rely_text;
	}

	public String getDateReplied() {
		return dateReplied;
	}

	public void setDateReplied(String dateReplied) {
		this.dateReplied = dateReplied;
	}
	

}
