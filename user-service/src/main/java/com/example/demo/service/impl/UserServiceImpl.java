package com.example.demo.service.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.demo.entity.Hotel;
import com.example.demo.entity.Ratings;
import com.example.demo.entity.User;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.repoitory.UserRepository;
import com.example.demo.service.UserService;
import com.example.demo.service.external.HotelService;

@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private RestTemplate restTemplate;
	@Autowired
	private HotelService hotelService;
	private org.slf4j.Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

	@Override
	public User createUser(User user) {
		String userId = UUID.randomUUID().toString();
		user.setUserId(userId);
		return userRepository.save(user);
	}

	// implement service to get rating for all users
	@Override
	public List<User> getAllUsers() {
		return userRepository.findAll();
	}

	@Override
	public User getUserById(String Id) {
		User user = userRepository.findById(Id)
				.orElseThrow(() -> new ResourceNotFoundException("User not found with id : " + Id));
		// localhost:8003/api/rating/user/6347d42f-ba5f-4c63-a937-9d9d4d6bc344
		Ratings[] userRating = restTemplate
				.getForObject("http://HOTEL-RATING/api/rating/user/" + user.getUserId(), Ratings[].class);
		
		logger.info(userRating.toString());
		
		List<Ratings> list = Arrays.stream(userRating).toList();

		//api service to get hotel details
		List<Ratings> collect = list.stream().map(rating -> {
			/*ResponseEntity<Hotel> forEntity = restTemplate
					.getForEntity("http://HOTEL-SERVICE/api/hotel/" + rating.getHotelId(), Hotel.class);*/
			//Hotel hotel = forEntity.getBody();
			//logger.info("response status code " + forEntity.getStatusCode());
			Hotel hotel = hotelService.getHotelById(rating.getHotelId());
			rating.setHotel(hotel);
			return rating;
		}).collect(Collectors.toList());
		user.setRatings(collect);
		return user;

	}

}
