package com.tricon.webstore.user;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.tricon.vo.User;

@Controller
public class UserController {
	
	@RequestMapping(value = "/userLogin", method = RequestMethod.GET)
	public String user(Locale locale, Model model){
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		System.out.println("this is user controller action called"+date);
		User user =  new User();
		user.setPassword("password");
		model.addAttribute("messageFromController", new Date());
		model.addAttribute("user", user);
		return "user";
		
	}
	
	

}
