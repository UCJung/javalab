package com.mykumi.springlab.chat01;

public class User {
	private String id;
	private String name;
	private String password;
	
	public User(String id, String name) {
		// TODO Auto-generated constructor stub
		this.id = id;
		this.name = name;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}
