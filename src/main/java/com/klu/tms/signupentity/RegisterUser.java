package com.klu.tms.signupentity;

import java.io.Serializable;

import javax.persistence.*;
import javax.persistence.Table;

@Entity
@Table(name = "Register")
public class RegisterUser implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	private String username;
	private String email;
	@Column(name = "mobile")
	private String phone;
	private String password;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
