package com.makersharks.component;

import org.springframework.stereotype.Component;
import java.util.Map;
import java.util.HashMap;

import com.makersharks.model.User;

@Component
public class UserComponent {

	private final Map<String,User> users = new HashMap<>();
	
	public void addUser(User user) {
		users.put(user.getUsername(), user);
	}
	
	public User getUser(String username) {
		return users.get(username);
	}
	
	public boolean isUserExists(String username) {
		return users.containsKey(username);
	}
}
