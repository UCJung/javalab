package com.mykumi.springlab.chat01;

import java.util.List;

import org.springframework.dao.DuplicateKeyException;

public interface UserDao {

	public void add(User user) throws DuplicateKeyException;

	public User get(String id);

	public void deleteAll();

	public int getCount();

	public List<User> getAll();

	public void update(User user);

}