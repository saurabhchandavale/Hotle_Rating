package com.example.demo.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hotel")
public class StaffController {
	@GetMapping("/staff")
	public ResponseEntity<List<String>> getAllStaff(){
		List<String> list = Arrays.asList("Ram", "Sham", "Suresh");
		return new ResponseEntity<List<String>>(list,HttpStatus.OK);
	}

}
