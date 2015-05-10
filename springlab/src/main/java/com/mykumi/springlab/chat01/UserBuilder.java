package com.mykumi.springlab.chat01;

public class UserBuilder {
	final String id;
	String name;
	String password;
	Level level;
	int login;
	int recommend;
	
	public UserBuilder(String id) {
		this.id = id;
	}

	public UserBuilder name(String name) {
		this.name = name;
		return this;
	}
	
	public UserBuilder password(String password) {
		this.password = password;
		return this;
	}
	
	public UserBuilder level(Level level) {
		this.level = level;
		return this;
	}
	
	public UserBuilder login(int login) {
		this.login = login;
		return this;
	}
	
	public UserBuilder recommend(int recommend) {
		this.recommend = recommend;
		return this;
	}	
	
	public User build() {
		return new User(this);
	}
}