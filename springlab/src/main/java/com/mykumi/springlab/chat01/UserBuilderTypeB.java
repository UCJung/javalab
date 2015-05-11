package com.mykumi.springlab.chat01;

public class UserBuilderTypeB extends UserBuilder {

	@Override
	public UserBuilder level(Level level) {
		this.level = level;
		return this;
	}

	@Override
	public UserBuilder login(int login) {
		this.login = login + 5;
		return this;
	}

	@Override
	public UserBuilder recommend(int recommend) {
		this.recommend = recommend + 10;
		return this;
	}
}
