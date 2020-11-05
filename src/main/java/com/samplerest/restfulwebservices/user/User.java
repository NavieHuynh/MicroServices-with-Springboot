package com.samplerest.restfulwebservices.user;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description="All details about user.")
@Entity
public class User {
	
	@Id
	@GeneratedValue
	private Integer id;
	@Size(min=2)
	@ApiModelProperty(notes="First Name should have at least 2 characters")
	private String FirstName;
	
	@Size(min=2)
	@ApiModelProperty(notes="Last Name should have at least 2 characters")
	private String LastName;
	
	
	@Past
	@ApiModelProperty(notes="Birth date should be in the past")
	private Date birthDate;

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

	
	
	
}
