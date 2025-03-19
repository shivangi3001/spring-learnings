package com.employee.app.service;




import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.employee.app.dto.EmployeeDto;
import com.employee.app.entity.EmployeeEntity;
import com.employee.app.repo.EmployeeRepo;

import ch.qos.logback.core.joran.util.beans.BeanUtil;

@Service("empService")
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeRepo empRepo;
	
	
	@Override
	public List<EmployeeDto> getAllEmployees(String property, boolean ascendingOrder) {
		/*
		Sort sort = null;
		if(ascendingOrder) {
			sort = Sort.by(Sort.Direction.ASC, property);
		}
		else {
			sort = Sort.by(Sort.Direction.DESC, property);
		}
		*/
		
		
		 List<EmployeeEntity> entityList = (List<EmployeeEntity>)empRepo.findAll(
                  ascendingOrder?Sort.by(Sort.Direction.ASC, property):Sort.by(Sort.Direction.DESC, property)
				 );
		 
		 //convert the entity list to the dto list
		 List<EmployeeDto> dtoList = new ArrayList<EmployeeDto>();
		 
		 entityList.forEach(entity ->{
			 EmployeeDto dto = new EmployeeDto();
			 BeanUtils.copyProperties(entity, dto);
			 dtoList.add(dto);
		 });
		
		 return dtoList;
	}


	@Override
	public List<EmployeeDto> getAllEmployees(boolean ascendingOrder, String... properties) {

		 List<EmployeeEntity> entityList = (List<EmployeeEntity>)empRepo.findAll(
                 ascendingOrder?Sort.by(Sort.Direction.ASC, properties):Sort.by(Sort.Direction.DESC, properties)
				 );
		 
		 //convert the entity list to the dto list
		 List<EmployeeDto> dtoList = new ArrayList<EmployeeDto>();
		 
		 entityList.forEach(entity ->{
			 EmployeeDto dto = new EmployeeDto();
			 BeanUtils.copyProperties(entity, dto);
			 dtoList.add(dto);
		 });
		
		 return dtoList;
	}


	@Override
	public List<EmployeeDto> getPageRecords(int pageNo, int pageSize) {
		
		//create the pageable object having input of pageNo and pageSize
		
		Pageable pageable = PageRequest.of(pageNo, pageSize, Direction.DESC, "salary");
		
		//get the page object by calling findAll(--) method of PagingAndSortingRepository(I)
		
		Page<EmployeeEntity> page = empRepo.findAll(pageable);
		
		System.out.println("------other informations that a page has-----------------");
		
		System.out.println(page.getNumber() + " " + page.getNumberOfElements() + " " + page.getTotalPages());
	
		
	    System.out.println(page.isEmpty() + " " + page.isFirst() + " " + page.isLast());
	
	    
	    //get the entity list from the Page<T>
	    
	    List<EmployeeEntity> entityList = page.getContent();
	    
	    //convert the entity list to dto list
	    
	    List<EmployeeDto> dtoList = new ArrayList<EmployeeDto>();
	    
	    entityList.forEach(entity->{
	    	EmployeeDto dto = new EmployeeDto();
	    	BeanUtils.copyProperties(entity, dto);
	    	dtoList.add(dto);
	    });
	
	    return dtoList;
	
	
	}
 
	
	
	
	
	
	
	
	
	
	
	
	
}
