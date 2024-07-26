package com.example.demo.controller;

import java.util.List;

import org.slf4j.LoggerFactory;
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
import com.example.demo.service.impl.UserServiceImpl;

import ch.qos.logback.classic.Logger;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.ratelimiter.annotation.RateLimiter;
import io.github.resilience4j.retry.annotation.Retry;

@RestController
@RequestMapping("/api/user")
public class UserController {
	@Autowired
	private UserService userService;
	private org.slf4j.Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);
	@PostMapping("/createUser")
	public ResponseEntity<User> craeteUser(@RequestBody User user) {
		User creatdUser = userService.createUser(user);
		return ResponseEntity.status(HttpStatus.CREATED).body(creatdUser);
	}
	
	int retryCount = 0;
	//localhost:8001/api/user/6347d42f-ba5f-4c63-a937-9d9d4d6bc344
	@GetMapping("/{userId}")
	//@CircuitBreaker(name="userCircuitBreaker", fallbackMethod = "ratingHotelFallbackMethod")
	//@Retry(name="ratingHotelService", fallbackMethod = "ratingHotelFallbackMethod")
	@RateLimiter(name="userRateLimeter", fallbackMethod = "ratingHotelFallbackMethod")
	public ResponseEntity<User> getUserById(@PathVariable String userId) {
		 logger.info("Retry Count {}  ", retryCount);
		 retryCount++;
		User userById = userService.getUserById(userId);
		return ResponseEntity.status(HttpStatus.OK).body(userById);
	}
	
	//create fallback method 
	public ResponseEntity<User> ratingHotelFallbackMethod(String userId, Exception ex){
		
		 
		 
		 User user = User.builder().email("dummy@gmail.com").about("This is dummry user").userId("1234").build();
		 return new ResponseEntity<User>(user,HttpStatus.OK);
	}

	@GetMapping("/")
	public ResponseEntity<List<User>> getAllUsers() {
		List<User> allUsers = userService.getAllUsers();
		return ResponseEntity.status(HttpStatus.OK).body(allUsers);
	}
}
