package com.mvcdemo.service;

import java.util.HashMap;

import com.mvcdemo.model.User;

public class LoginService {
	
	HashMap<String, String> users = new HashMap<>();
	
	public LoginService() {
		users.put("athul", "Athul Krishna");
		users.put("manu", "Akshay Manu");
		users.put("binu", "BinuBal");
		users.put("akhil", "Akhil Baby");
	}



	public boolean authenticate(String userId, String password) {
		
		if(users.containsKey(userId)) return true;
		
		return false;
	}
	
	public User getUserDetails(String userId) {
		User user = new User();
		user.setUserName(users.get(userId));
		user.setUserId(userId);
		
		return user;
	}
	
	
}
