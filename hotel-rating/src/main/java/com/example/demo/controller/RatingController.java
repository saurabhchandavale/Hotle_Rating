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

import com.example.demo.entity.Rating;
import com.example.demo.service.RatingService;

@RestController
@RequestMapping("/api/rating")
public class RatingController {
	@Autowired
	private RatingService ratingService;
	
	
	@PostMapping("/create")
	public ResponseEntity<Rating> createRating(@RequestBody Rating rating){
		Rating createdRating = ratingService.createRating(rating);
		return ResponseEntity.status(HttpStatus.CREATED).body(createdRating);
	}
	@GetMapping("/")
	public ResponseEntity<List<Rating>> getAllRatings(){
		List<Rating> allRatings = ratingService.getAllRatings();
		return new ResponseEntity<List<Rating>>(allRatings,HttpStatus.OK);
	}
	@GetMapping("/user/{userId}")
	public ResponseEntity<List<Rating>> getRatingsByUserId(@PathVariable String userId){
		List<Rating> ratingsByUserId = ratingService.getRatingsByUserId(userId);
		return new ResponseEntity<List<Rating>>(ratingsByUserId,HttpStatus.OK);
	}
	@GetMapping("/hotel/{hotelId}")
	public ResponseEntity<List<Rating>> getRatingsByHotelId(@PathVariable String hotelId){
		List<Rating> ratingByHotelId = ratingService.getRatingByHotelId(hotelId);
		return new ResponseEntity<List<Rating>>(ratingByHotelId,HttpStatus.OK);

	}
	
}
