package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.Rating;

public interface HotelRatingRepository extends JpaRepository<Rating, String> {
	
	public List<Rating> findByUserId(String userId);
	public List<Rating> findByHotelId(String hotelId);

}
