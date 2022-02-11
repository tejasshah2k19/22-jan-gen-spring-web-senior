package com.dao;

import java.util.HashMap;

import org.springframework.stereotype.Component;

@Component
public class VoteDao {

	public   HashMap<Integer, Integer> voteCounter = new HashMap<Integer, Integer>();
	// 123 => 0
	// 456 => 0

	public void addVote(int userId) {
		if (voteCounter.get(userId) == null) {
			voteCounter.put(userId, 0);
		} else {
			int oldVote = voteCounter.get(userId);
			int newVote = oldVote + 1;
			voteCounter.put(userId, newVote);
		}
	}

	public Integer getVotes(int userId) {
		return voteCounter.get(userId);
	}
}
