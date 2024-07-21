package com.example.demo.entity;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
@Getter
@Setter
public class Hotel {
	@jakarta.persistence.Id
	private String Id;
	private String name;
	private String location;
	private String about;

}
