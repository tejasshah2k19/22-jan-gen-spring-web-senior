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
	public String giveVote(Model model, HttpSession session) {

		int userId = (Integer) session.getAttribute("userId");// user-->vote
		if (userDao.isVoted(userId)) {
			model.addAttribute("msg", "You have already registered your vote...");
			if (userDao.isCandidate(userId)) {
				return "CandidateHome";
			} else {
				return "CitizenHome";
			}
		} else {

			ArrayList<UserBean> candidates = userDao.getAllCandidates();

			model.addAttribute("candidates", candidates);
			return "GiveVote";
		}
	}

	@GetMapping("/savevote")
	public String saveVote(@RequestParam("vote") int candidateId, HttpSession session, Model model) {

		int userId = (Integer) session.getAttribute("userId");// user-->vote
		userDao.updateVoteStatus(userId);// change vote status --> true
		userDao.voteDao.addVote(candidateId);

		System.out.println("vote given to => " + candidateId);
		//
		model.addAttribute("msg", "vote successfully registered..");
		//
		//
		if (userDao.isCandidate(userId)) {
			return "CandidateHome";
		} else {
			return "CitizenHome";
		}
	}

	@GetMapping("/votecount")
	public String voteCount(Model model) {
		model.addAttribute("voteCounter", userDao.voteDao.voteCounter);
		model.addAttribute("candidates", userDao.getAllCandidates());
		return "VoteCounter";
	}

}
