package com.example.demo.service.external;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.demo.entity.Ratings;





@Service
@FeignClient(name = "HOTEL-RATING")
public interface RatingService {
	@PostMapping("/api/rating/create")
	public Ratings createRating(@RequestBody Ratings rating);
	
	//@PutMapping
	//public Ratings updateRating(@PathVariable String ratingId)

}

