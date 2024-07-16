package com.example.demo.service.impl;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Rating;
import com.example.demo.repository.HotelRatingRepository;
import com.example.demo.service.RatingService;
@Service
public class RatingServiceImpl implements RatingService {
	@Autowired
	private HotelRatingRepository hotelRating;

	@Override
	public Rating createRating(Rating rating) {
		String ratingId = UUID.randomUUID().toString();
		rating.setRatingId(ratingId);
		Rating save = hotelRating.save(rating);
		return save;
	}

	@Override
	public List<Rating> getAllRatings() {
		return hotelRating.findAll();
	}

	@Override
	public List<Rating> getRatingsByUserId(String userID) {
		List<Rating> byUserId = hotelRating.findByUserId(userID);
		
		return byUserId;
	}

	@Override
	public List<Rating> getRatingByHotelId(String hotelId) {
		return hotelRating.findByHotelId(hotelId);
	}

}
