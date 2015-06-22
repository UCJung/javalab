package com.mykumi.springlab.chat01;

public abstract class UserBuilder {

	protected String id;
	protected String name;
	protected String password;
	protected Level level;
	protected int login;
	protected int recommend;
	protected String email;

	public UserBuilder id(String id) {
		this.id = id;
		return this;
	}	

	public UserBuilder name(String name) {
		this.name = name;
		return this;
	}

	public UserBuilder password(String password) {
		this.password = password;
		return this;
	}
	
	public UserBuilder email(String email) {
		this.email = email;
		return this;
	}

	abstract public UserBuilder level(Level level);
	abstract public UserBuilder login(int login);
	abstract public UserBuilder recommend(int recommend);
	
	public User build() {
		return new User(this);
	}
}