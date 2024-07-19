package com.example.demo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Configuration;

import com.example.demo.entity.Ratings;
import com.example.demo.service.external.RatingService;
@Configuration
@SpringBootTest(classes = UserServiceApplication.class)
class UserServiceApplicationTests {
	
	@Autowired
	private RatingService ratingService;

	@Test
	void contextLoads() {
	}
	

	
	@Test
	void createRating() {
		Ratings rating = Ratings.builder().rating(10).userId("").hotelId("").remark("This is ").build();
		Ratings rating2 = ratingService.createRating(rating);
		System.out.println("New rating created ");
	}

}
