package com.springrest.app.writer;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;

import org.springframework.batch.item.Chunk;
import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;

import com.springrest.app.entity.PinCode;
import com.springrest.app.repository.PincodeRepository;

public class PinCodeWriter implements ItemWriter<PinCode>{

	@Autowired
	private PincodeRepository repo;

	
	@Override
	public void write(Chunk<? extends PinCode> chunk) throws Exception {
		
	  repo.saveAll(chunk);
		
	}

	

}
