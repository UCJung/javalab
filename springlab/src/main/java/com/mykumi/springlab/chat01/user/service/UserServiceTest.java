package com.mykumi.springlab.chat01.user.service;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="/com/mykumi/springlab/chat01/user/service/applicationContext.xml")
public class UserServiceTest {
	@Autowired
	UserService userService;
	
	@Test
	public void bean() {
		assertThat(this.userService, is(notNullValue()));
	}
}
