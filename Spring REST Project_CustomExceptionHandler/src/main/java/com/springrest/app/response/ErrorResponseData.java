package com.springrest.app.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ErrorResponseData {

	private String status;
	private String message;
	private String datetime;
	
	
}
