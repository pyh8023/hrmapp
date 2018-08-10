package com.pyh.test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import com.pyh.service.UserService;

import junit.framework.TestCase;

public class UserServiceTest extends TestCase{
	
	@Autowired
	@Qualifier("userService")
	private UserService userService;
	
	public void testFindUserById() {
		/*System.out.println(userService);
		 System.out.println(userService.findUserById(1));*/
	}

}
