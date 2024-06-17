package com.makersharks.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.makersharks.component.UserComponent;
import com.makersharks.model.User;

@RestController
@RequestMapping("/api/user")
@Validated
public class UserController {

	private final UserComponent userComponent;
	private final BCryptPasswordEncoder bCryptPasswordEncoder;

	@Autowired
	public UserController(UserComponent userComponent, BCryptPasswordEncoder bCryptPasswordEncoder) {
		this.userComponent = userComponent;
		this.bCryptPasswordEncoder = bCryptPasswordEncoder;
	}

	@PostMapping("/register")
	public ResponseEntity<String> registerUser(@RequestBody User user) {
		if (userComponent.isUserExists(user.getUsername())) {
			return ResponseEntity.status(HttpStatus.CONFLICT).body("User Already Exists!!!");
		}
		user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
		userComponent.addUser(user);
		return ResponseEntity.status(HttpStatus.CREATED).body("User Registration Successful");
	}

	@GetMapping("/fetch")
	public ResponseEntity<Object> fetch(@RequestParam String username) {
		User user = userComponent.getUser(username);
		if (user == null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User Not Found");
		}
		return ResponseEntity.ok(user);
	}
}
