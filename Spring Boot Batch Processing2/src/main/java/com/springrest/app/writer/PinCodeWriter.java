package com.springrest.app.writer;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;

import org.springframework.batch.item.Chunk;
import org.springframework.batch.item.ItemWriter;

import com.springrest.app.entity.PinCode;

public class PinCodeWriter implements ItemWriter<PinCode>{

	private BufferedWriter writer;
	
	public PinCodeWriter(String filePath) throws Exception {
		File file = new File("output.txt");
		this.writer = new BufferedWriter(new FileWriter(file));
		System.out.println(writer);
	}
	
	@Override
	public void write(Chunk<? extends PinCode> chunk) throws Exception {
		
		for(PinCode pinCode : chunk) {
			writer.write(pinCode.toString());
			writer.newLine();
			System.out.println("writing" + pinCode);
		}
		writer.flush();
		
	}

	

}
