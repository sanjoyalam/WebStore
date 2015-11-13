package com.tricon.services;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.tricon.dao.UserDAO;

public class UserServices {
	
	public void login(){
		System.out.println("service.login called");
		ApplicationContext context =
			    new ClassPathXmlApplicationContext(new String[] {"daos.xml"});
		
		UserDAO userDao = (UserDAO)context.getBean("userDao");
		userDao.login();
	}

}
