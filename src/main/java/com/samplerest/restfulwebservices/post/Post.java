package com.samplerest.restfulwebservices.post;

import java.util.Date;
import java.util.List;

public class Post {
	private Integer id;
	private String message;
	private Integer likes;
	private Integer userid;
	private Date postdate;
	
	public Integer getUserid() {
		return userid;
	}
	public void setUserid(Integer userid) {
		this.userid = userid;
	}
	public Date getPostdate() {
		return postdate;
	}
	public void setPostdate(Date postdate) {
		this.postdate = postdate;
	}
	public Integer getUserID() {
		return userid;
	}
	public void setUserID(Integer userID) {
		userid = userID;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public Integer getLikes() {
		return likes;
	}
	public void setLikes(Integer likes) {
		this.likes = likes;
	}
	protected Post() {}
	
	public Post(Integer id, String message, Integer likes,  Integer userid, Date date) {
		super();
		this.id = id;
		this.message = message;
		this.likes = likes;
		this.postdate = date;
		this.userid = userid;
	}
	
}
