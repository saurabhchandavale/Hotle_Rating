package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

import com.example.demo.entity.Ratings;
import com.example.demo.service.external.RatingService;


@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
public class UserServiceApplication {
	/*@Bean
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}*/


	public static void main(String[] args) {
		SpringApplication.run(UserServiceApplication.class, args);
	}

	
	
	


}
