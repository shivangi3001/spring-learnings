package com.springrest.app.processor;

import org.springframework.batch.item.ItemProcessor;

public class ItemProcessorImpl implements ItemProcessor<String, String>{

	@Override
	public String process(String item) throws Exception {
	System.out.println("Processing Item");
	return	"Processed Item";
	}

}
