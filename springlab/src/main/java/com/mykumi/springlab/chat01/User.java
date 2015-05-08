package com.mykumi.springlab.chat01;

public class User {
	private String id;
	private String name;
	private String password;
	private Level level;
	private int login;
	private int recommend;
	
	public User() {
		
	}
	
	@Deprecated
	public User(String id, 
			String name, 
			String password,
			Level level,
			int login,
			int recommend) {
		this.id = id;
		this.name = name;
		this.password = password;
		this.level = level;
		this.login = login;
		this.recommend = recommend;
	}
	
	public User(UserBuilder builder) {
		this.id = builder.id;
		this.name = builder.name;
		this.password = builder.password;
		this.level = builder.level;
		this.login = builder.login;
		this.recommend = builder.recommend;
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

	public Level getLevel() {
		return level;
	}

	public void setLevel(Level level) {
		this.level = level;
	}

	public int getLogin() {
		return login;
	}

	public void setLogin(int login) {
		this.login = login;
	}

	public int getRecommend() {
		return recommend;
	}

	public void setRecommend(int recommend) {
		this.recommend = recommend;
	}
	
	public static class UserBuilder {
		private final String id;
		private String name;
		private String password;
		private Level level;
		private int login;
		private int recommend;
		
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
		
		public UserBuilder password(int login) {
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
}
