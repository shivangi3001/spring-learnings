package com.springrest.app.entity;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MovieDetails {
	
	private String budget;
	private List<ActorEntity> actors;
	
	private ProductionHouse production_house;
	

}
