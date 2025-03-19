package com.springrest.app.entity;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MovieEntity {
	
	private String movieName;
	private Date releaseDate;
	
	private MovieDetails movie_details;
	

}
