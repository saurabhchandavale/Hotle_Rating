package com.example.demo.service.external;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.demo.entity.Hotel;
@Service
@FeignClient(name = "HOTEL-SERVICE")
public interface HotelService {
	
	@GetMapping("/api/hotel/{hotelId}")
	Hotel getHotelById(@PathVariable("hotelId") String hotelId);

}
