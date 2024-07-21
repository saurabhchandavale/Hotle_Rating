package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.Hotel;

public interface HotelService {
	
	public Hotel createHotel(Hotel hotel);
	
	public Hotel getHotelById(String hotelId);
	
	public List<Hotel> getAllHotels();

}
