package com.springrest.app.controller;

import java.util.Arrays;
import java.util.Date;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springrest.app.entity.ActorEntity;
import com.springrest.app.entity.MovieDetails;
import com.springrest.app.entity.MovieEntity;
import com.springrest.app.entity.ProductionHouse;

@RestController
@RequestMapping("/movie")
public class MovieController {
	
	@GetMapping("get-movie")
	public MovieEntity getMovie() {
		MovieDetails movieDetails = new MovieDetails("600Cr.", 
										Arrays.asList(
												new ActorEntity("Shah Rukh Khan", 100000000.00),
												new ActorEntity("Nayanthara", 100000000.00),
												new ActorEntity("Deepika Padukone", 100000000.00)
											
										 ), 
										new ProductionHouse("Red Chillies Entertainment", "Shah Rukh Khan"));
		
				
				
				
				
				return new MovieEntity("JAWAAN", new Date(123, 11, 16), movieDetails);
	}
	
//	TODO :: Create a rest controller method that will return List of MovieEntity objects

}
