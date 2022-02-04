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

}
