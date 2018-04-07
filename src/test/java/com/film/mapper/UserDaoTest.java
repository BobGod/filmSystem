package com.film.mapper;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.film.entity.User;

public class UserDaoTest {

	ApplicationContext context;
	
	@Before
	public void setUp() throws Exception {
		context = new ClassPathXmlApplicationContext("classpath:spring-context.xml");
	}

	@Test
	public void testSave() {
		UserMapper userMapper = (UserMapper) context.getBean("userMapper");
		
		User user = new User("tom", "123456");
		
		userMapper.save(user);
	}

	@Test
	public void testQueryUserByName() {
		UserMapper userMapper = (UserMapper) context.getBean("userMapper");
		
		User user = userMapper.queryUserByName("tom");
		
		System.out.println(user);
	}

}
