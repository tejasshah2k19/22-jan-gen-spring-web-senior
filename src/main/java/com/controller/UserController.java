package com.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class UserController {

	
	@RequestMapping("/login")
	void login() {
		System.out.println("login");
	}

	@RequestMapping("/signup")	
	void signup() {

	}

	
	
	void logout() {

	}

	void forgetPassword() {

	}
}
