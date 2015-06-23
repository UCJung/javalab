package com.mykumi.springlab.exam;

public class UserBuilderTypeA extends UserBuilder {

	@Override
	public UserBuilder level(Level level) {
		this.level = level;
		return this;
	}
	
	@Override
	public UserBuilder login(int login) {
		this.login = login;
		return this;
	}
	
	@Override
	public UserBuilder recommend(int recommend) {
		this.recommend = recommend;
		return this;
	}
}