package com.hackerproject.controller;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="users")
public class Users {
	@Id
	@Column(name="username")
	private String username;
	@Column(name="password")
	private String Password;
	@Column(name="role")
	private String Role;
	public String getusername() {
		return username;
	}
	public void setusername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return Password;
	}
	public void setPassword(String password) {
		Password = password;
	}
	public String getRole() {
		return Role;
	}
	public void setRole(String role) {
		Role = role;
		
	
	}
	public Users()
	{
		
	}
	public Users(String username, String password, String role) {
		super();
		this.username = username;
		Password = password;
		Role = role;
	}
	
	
	

}
