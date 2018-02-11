package com.spring.web.dao;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class User {
	@NotBlank(message="Username cannot be blank")
	@Size(min=3, max=15)
	@Pattern(regexp="^\\w{3,}$")
	private String username;
	
	@NotBlank
	@Pattern(regexp="^\\S+$")
	@Size(min=3, max=15, message="Paasword should be between {min} and {max}")
	private String password;
	private boolean enabled;
	private String authority;
	@Email
	private String email;
	
	public User() {}
	
	
	
	public User(String username, String email, String password, boolean enabled, String authority) {
		this.username = username;
		this.password = password;
		this.enabled = enabled;
		this.authority = authority;
		this.email = email;
	}


	

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public boolean isEnabled() {
		return enabled;
	}
	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}
	public String getAuthority() {
		return authority;
	}
	public void setAuthority(String authority) {
		this.authority = authority;
	}
	
	
	

}
