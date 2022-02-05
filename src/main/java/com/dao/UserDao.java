package com.dao;

import java.util.ArrayList;

import org.springframework.stereotype.Repository;

import com.bean.UserBean;

//spring bean 
//spring.xml --> singleton 
@Repository // developer --> database
public class UserDao {

	ArrayList<UserBean> users = new ArrayList<UserBean>();
	// 0
	// 1
	// 2

	public UserDao() {

		UserBean user1 = new UserBean();
		user1.setUserId(12345);
		user1.setCandidate(true);
		user1.setEmail("ram@gmail.com");
		user1.setFirstName("ram");
		user1.setPassword("ram");

		UserBean user2 = new UserBean();
		user2.setUserId(12343);
		user2.setCandidate(false);
		user2.setEmail("sita@gmail.com");
		user2.setFirstName("sita");
		user2.setPassword("sita");

		UserBean user3 = new UserBean();
		user3.setUserId(12443);
		user3.setCandidate(false);
		user3.setEmail("ravan@gmail.com");
		user3.setFirstName("ravan");
		user3.setPassword("ravan");



		UserBean user4 = new UserBean();
		user4.setUserId(12945);
		user4.setCandidate(true);
		user4.setEmail("superman@gmail.com");
		user4.setFirstName("superman");
		user4.setPassword("superman");

		
		
		users.add(user1);
		users.add(user2);
		users.add(user3);
		users.add(user4);
		
		
	}

	public void insertUser(UserBean user) {
		// db insert -- inMemory
		users.add(user);
	}

	// email,password --> users --> user [ UserBean ] no match --> null
	public UserBean authenticate(String email, String password) {
		for (UserBean u : users) {
			if (u.getEmail().equalsIgnoreCase(email) && u.getPassword().equals(password)) {
				return u;
			}
		}

		return null;
	}



	public ArrayList<UserBean> getAllCandidates(){
		ArrayList<UserBean> candidates = new ArrayList<UserBean>();
		
		for(UserBean u:users) {
			if(u.isCandidate() == true ) {
				candidates.add(u); 
			}
		}
		
		
		return candidates;
	}

}
