package com.springrest.app.reader;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.*;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.NonTransientResourceException;
import org.springframework.batch.item.ParseException;
import org.springframework.batch.item.UnexpectedInputException;
import org.springframework.core.io.ClassPathResource;

import com.springrest.app.entity.PinCode;

public class ExcelItemReader implements ItemReader<PinCode> {
	
	private Iterator<Row> rowIterator;
	
	public ExcelItemReader(String excelFilePath) throws Exception {
		InputStream fis = new ClassPathResource(excelFilePath).getInputStream();
		Workbook workbook = WorkbookFactory.create(fis);
		Sheet sheet =workbook.getSheetAt(0);
		this.rowIterator = sheet.rowIterator();
		this.rowIterator.next();
		
	}

	@Override
	public PinCode read() throws Exception, UnexpectedInputException, ParseException, NonTransientResourceException {
	
		if(!rowIterator.hasNext()) {
			return null;
		}
		
		Row row = rowIterator.next();
		DataFormatter dataFormatter = new DataFormatter();
		String pinCode = dataFormatter.formatCellValue(row.getCell(0));
		String city = dataFormatter.formatCellValue(row.getCell(1));
		String state = dataFormatter.formatCellValue(row.getCell(2));
		
		
		//now return the read pincode item
		PinCode pincodeEntity = new PinCode();
		pincodeEntity.setPinCode(pinCode);
		pincodeEntity.setCity(city);
		pincodeEntity.setState(state);
		
		System.out.println("reader" + "   " + pincodeEntity);
		
		
		return pincodeEntity;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
