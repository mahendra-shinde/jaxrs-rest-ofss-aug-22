package com.mahendra.demo1;

import java.io.Serializable;

import jakarta.xml.bind.annotation.XmlRootElement;

/*
 * Model Class / POJO Must follow these rules:
 * 1. Class must be member of some package
 * 2. Class name must be in "TitleCase"
 * 3. Methods and Variables must be in "camelCase"
 * 4. Default Constructor (No Arg) is Must
 * 5. Getters and Setters for properties
 * 6. Implement "Serializable" interface
 */

@XmlRootElement
public class Customer  implements Serializable {
	private Integer custId;
	private String firstName;
	private String lastName;
	private String phone;
	
	public Integer getCustId() {
		return custId;
	}
	public void setCustId(Integer custId) {
		this.custId = custId;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	public Customer() {
	}
	public Customer(Integer custId, String firstName, String lastName, String phone) {
		super();
		this.custId = custId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.phone = phone;
	}
	
}
