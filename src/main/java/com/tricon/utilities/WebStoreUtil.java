package com.tricon.utilities;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class WebStoreUtil {
	
	public static Object getBean(){
		ApplicationContext context =
			    new ClassPathXmlApplicationContext(new String[] {"services.xml"});

			// retrieve configured instance
			Object bean = context.getBean("userServices");
			return bean;

	}

}
