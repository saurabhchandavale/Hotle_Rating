package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.Rating;

public interface RatingService {
	
	public Rating createRating(Rating rating);
	public List<Rating> getAllRatings();
	public List<Rating> getRatingsByUserId(String userID);
	public List<Rating> getRatingByHotelId(String hotelId);

}
