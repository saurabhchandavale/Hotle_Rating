package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.User;
import com.example.demo.service.UserService;

@RestController
@RequestMapping("/api/user")
public class UserController {
	@Autowired
	private UserService userService;

	@PostMapping("/createUser")
	public ResponseEntity<User> craeteUser(@RequestBody User user) {
		User creatdUser = userService.createUser(user);
		return ResponseEntity.status(HttpStatus.CREATED).body(creatdUser);
	}
	//localhost:8001/api/user/6347d42f-ba5f-4c63-a937-9d9d4d6bc344
	@GetMapping("/{userId}")
	public ResponseEntity<User> getUserById(@PathVariable String userId) {
		User userById = userService.getUserById(userId);
		return ResponseEntity.status(HttpStatus.OK).body(userById);
	}

	@GetMapping("/")
	public ResponseEntity<List<User>> getAllUsers() {
		List<User> allUsers = userService.getAllUsers();
		return ResponseEntity.status(HttpStatus.OK).body(allUsers);
	}
}
