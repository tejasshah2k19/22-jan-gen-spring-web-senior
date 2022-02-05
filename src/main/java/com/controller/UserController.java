package com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.bean.UserBean;
import com.dao.UserDao;

@Controller
public class UserController {

	@Autowired
	UserDao userDao;
	// delete

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

		int userId = (int) (Math.random() * 100000);
		user.setUserId(userId);

		userDao.insertUser(user);
		System.out.println("Save user () ");
		System.out.println(user.getFirstName());
		System.out.println(user.getEmail());
		System.out.println(user.isCandidate());
		return "Login";
	}

	@PostMapping("/authenticate")
	public String authenticate(UserBean user, Model model) {
		// email
		// password

		// candidate --> status
		// citizen --> vote | check Vote

		UserBean loginUser = userDao.authenticate(user.getEmail(), user.getPassword());

		if (loginUser == null) {
			// inValid

			model.addAttribute("error", "Invalid credentials..");
			return "Login";// forward
		} else {
			// valid

			model.addAttribute("user", loginUser); // request.setAttribute()
			if (loginUser.isCandidate()) {
				return "CandidateHome";
			} else {
				return "CitizenHome";
			}

		}
	}

	@GetMapping("/logout")
	public String logout() {
//		return "Login";//forward -> data sent 
		return "redirect:/login";  // destroy the current request 
	}
	
	@GetMapping("/login")
	public String login() {
		return "Login";
	}
	
}
