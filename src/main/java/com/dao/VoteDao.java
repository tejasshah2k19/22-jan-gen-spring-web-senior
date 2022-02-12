package com.dao;

import java.util.HashMap;

import org.springframework.stereotype.Component;

@Component
public class VoteDao {

	public   HashMap<Integer, Integer> voteCounter = new HashMap<Integer, Integer>();
	// 123[ram] => 10
	// 456 => 0
	//

	//userId --> candidateId 
	public void addVote(int userId) {
		if (voteCounter.get(userId) == null) {
			voteCounter.put(userId, 0);//first time 
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
