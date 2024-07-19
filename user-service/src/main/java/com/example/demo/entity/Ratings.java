package com.example.demo.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class Ratings {
	
	private String ratingId;
	private String userId;
	private String hotelId;
	private int rating;
	private String remark;
	private Hotel hotel;

}
