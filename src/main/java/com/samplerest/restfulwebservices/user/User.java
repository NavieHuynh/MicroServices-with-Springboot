package com.samplerest.restfulwebservices.user;

import java.util.Date;
import java.util.List;

import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

import com.samplerest.restfulwebservices.post.Post;

public class User {
	
	@Size(min=2)
	private String FirstName;
	@Size(min=2)
	private String LastName;
	private Integer id;
	
	@Past
	private Date birthDate;
	private List<Post> posts;
	
	public List<Post> getPosts() {
		return posts;
	}
	public void addPost(Post post) {
		this.posts.add(post);
		
	}
	public String getFirstName() {
		return FirstName;
	}
	public void setFirstName(String firstName) {
		FirstName = firstName;
	}
	public String getLastName() {
		return LastName;
	}
	public void setLastName(String lastName) {
		LastName = lastName;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Date getBirthDate() {
		return birthDate;
	}
	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}
	
	@Override
	public String toString() {
		return "User [FirstName=" + FirstName + ", LastName=" + LastName + ", id=" + id + ", birthDate=" + birthDate
				+ "]";
	}
	protected User() {};
	
	public User(String firstName, String lastName, Integer id, Date birthDate) {
		super();
		FirstName = firstName;
		LastName = lastName;
		this.id = id;
		this.birthDate = birthDate;
	}
	
	public User(String firstName, String lastName, Integer id, Date birthDate, List<Post> posts) {
		super();
		FirstName = firstName;
		LastName = lastName;
		this.id = id;
		this.birthDate = birthDate;
		this.posts = posts;
	}
	
	
	
}
