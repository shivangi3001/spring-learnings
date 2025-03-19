package com.springrest.app;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import com.app.test.IService;

//this is the target class where IService is required
public class ExampleTest {
	
	@Test
	public void testing() {
		IService service = Mockito.mock(IService.class);
		System.out.println(service);
	}

}








