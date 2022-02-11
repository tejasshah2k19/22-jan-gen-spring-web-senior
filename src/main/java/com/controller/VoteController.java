package com.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.bean.UserBean;
import com.dao.UserDao;

@Controller
public class VoteController {

	@Autowired
	UserDao userDao;

	@GetMapping("/givevote")
	public String giveVote(Model model) {

		ArrayList<UserBean> candidates = userDao.getAllCandidates();

		model.addAttribute("candidates", candidates);
		return "GiveVote";
	}

	@GetMapping("/savevote")
	public String saveVote(@RequestParam("vote") int candidateId,HttpSession session) {
		
		int userId = (Integer)session.getAttribute("userId");
		userDao.updateVoteStatus(userId);
		
		System.out.println("vote given to => " + candidateId);
		//
		return "";
	}

}
