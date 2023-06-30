package com.klu.tms.signupcontroller;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import com.klu.tms.signupbean.RegisterUserBean;
import com.klu.tms.signupentity.RegisterUser;

@ManagedBean(name = "register", eager = true)
@RequestScoped
public class RegisterUserData {
	private String username;
	private String email;
	private String phone;
	private String pass;
	private String res_message;

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

	public String getRes_message() {
		return res_message;
	}

	public void setRes_message(String res_message) {
		this.res_message = res_message;
	}

	@EJB(lookup = "java:global/TMS/RegisterUserBeanImpl!com.klu.tms.signupbean.RegisterUserBean")
	private RegisterUserBean eb;

	public void insert() {
		try {
			RegisterUser e = new RegisterUser();
			e.setUsername(username);
			e.setEmail(email);
			e.setPhone(phone);
			e.setPassword(pass);
			System.out.println("password" + pass + "..........");
			res_message = eb.insertData(e);
		} catch (Exception e1) {
			res_message = e1.getMessage();
		}
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

}
