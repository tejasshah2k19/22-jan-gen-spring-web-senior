package com.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.bean.UserBean;

@Controller
public class UserController {

	@RequestMapping(value = "/signup", method = RequestMethod.GET)
//	@RequestMapping("/signup")//GET 
	public String signup() {
		System.out.println("hello signup......");
		return "Signup";// jsp
	}

	@RequestMapping(value = "saveuser", method = RequestMethod.POST)
	public String saveUser(UserBean user, Model model) {
		// request
		// bean
		// bean.set
		// dao.insert(bean)
		System.out.println("Save user () ");
		System.out.println(user.getFirstName());
		System.out.println(user.getEmail());
		model.addAttribute("user", user);
		return "Home";
	}
}
