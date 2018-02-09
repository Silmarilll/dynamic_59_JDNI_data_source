package com.spring.web.dao;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import com.spring.web.validation.ValidEmail;

public class Offer {
	
	private int id;
	@Size(min=3, max=100, message="Name has to be between {min} and {max}")
	private String name;
	@NotEmpty(message="Please fill the email")
	@Pattern(regexp=".*\\@.*\\..*", message="Not valid email address")
	@ValidEmail(min=3, message = "Email should be more than {min}")
	private String email;
	@NotEmpty(message="Please fill the text")
	private String text;
	
	

	public Offer(int id, String name, String email, String text) {
		this.id = id;
		this.name = name;
		this.email = email;
		this.text = text;
	}
	
	public Offer(String name, String email, String text) {
		this.name = name;
		this.email = email;
		this.text = text;
	}
	
	public Offer() {
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	
	@Override
	public String toString() {
		return "Offer [id=" + id + ", name=" + name + ", email=" + email
				+ ", text=" + text + "]";
	}

}
