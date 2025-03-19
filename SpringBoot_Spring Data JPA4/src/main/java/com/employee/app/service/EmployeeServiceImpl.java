package com.employee.app.service;




import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.employee.app.dto.EmployeeDto;
import com.employee.app.entity.EmployeeEntity;
import com.employee.app.repo.EmployeeRepo;
import com.employee.app.repo.EmployeeRepository;

import ch.qos.logback.core.joran.util.beans.BeanUtil;

//@Service("empService")
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	@Qualifier("employeeRepository")
	private EmployeeRepository empRepo;
	
	
	
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


	@Override
	public void getRecordsByPagination(int pageSize) {
		
		
		//get the total no of records
		long totalRecords = empRepo.count();
		
		//get the total no of pages
		int pagesCount = (int)(totalRecords / pageSize);
		
		if(totalRecords % pageSize != 0)
			pagesCount++;
		
		//displaying records by page
		
		for(int i=0; i<pagesCount; i++) {
			Pageable pageable = PageRequest.of(i, pageSize);
			Page<EmployeeEntity> page = empRepo.findAll(pageable);
			List<EmployeeEntity> entityList = page.getContent();
			entityList.forEach(System.out::println);
			System.out.println(page.getNumber() + 1 + "  of " + page.getTotalPages());
			System.out.println("--------------------------------");
		}
		
		
		
	}


	@Override
	@Transactional
	public EmployeeDto fetchEmployeeById(int eid) {
		EmployeeEntity entity = empRepo.getReferenceById(eid);
		
		//convert the entity to dto
		EmployeeDto dto = new EmployeeDto();
		BeanUtils.copyProperties(entity, dto);
		return dto;
	}


	@Override
	public void removeEmployeesInBatch(List<EmployeeDto> listDto) {
		//convert the dto to entity list
		
		List<EmployeeEntity> listEntity = new ArrayList<EmployeeEntity>();
		
		listDto.forEach(dto->{
			EmployeeEntity entity = new EmployeeEntity();
			BeanUtils.copyProperties(dto, entity);
			listEntity.add(entity);
		});
		
		empRepo.deleteAllInBatch(listEntity);
		
	}


	@Override
	public List<EmployeeDto> fetchEmployeesBySomeData(EmployeeDto dto, 
				String property, boolean ascendingOrder) {
		//convert the dto to entity
		
		EmployeeEntity entity = new EmployeeEntity();
		BeanUtils.copyProperties(dto, entity);
		
		//prepare the Example object
		Example<EmployeeEntity> ex = Example.of(entity);
		
		//use repository
		List<EmployeeEntity> entityList = empRepo.findAll(ex, ascendingOrder?Sort.by(Direction.ASC, property):Sort.by(Direction.DESC));
	    List<EmployeeDto> empListDto = new ArrayList<EmployeeDto>();
	    entityList.forEach(empEntity->{
	    	EmployeeDto empDto = new EmployeeDto();
	    	BeanUtils.copyProperties(empEntity, empDto);
	    	empListDto.add(empDto);
	    });
		
	    return empListDto;
	}


	@Override
	public List<EmployeeDto> getEmployeesBySalary(Float salary) {
		List<EmployeeEntity> entityList = empRepo.findBySalary(salary);
	
	//convert entity list to dto list
		
		List<EmployeeDto> dtoList = new ArrayList<EmployeeDto>();
		
		entityList.forEach(entity->{
			EmployeeDto dto = new EmployeeDto();
			BeanUtils.copyProperties(entity, dto);
			dtoList.add(dto);
		});
		
		return dtoList;
	}


	@Override
	public List<EmployeeDto> getEmployeesByName(String name) {
		List<EmployeeEntity> listEntity = empRepo.findByName(name);
		
		List<EmployeeDto> dtoList = new ArrayList<EmployeeDto>();
		listEntity.forEach(entity->{
			EmployeeDto dto = new EmployeeDto();
			BeanUtils.copyProperties(entity, dto);
			dtoList.add(dto);
		});
		
		return dtoList;
	}


	@Override
	public List<EmployeeDto> getEmployeesBySalaryLessThanOrEqual(Float salary) {
		List<EmployeeEntity> entityList =  empRepo.findBySalaryLessThanEqual(salary);
	
		List<EmployeeDto> dtoList = new ArrayList<EmployeeDto>();
		entityList.forEach(entity->{
			EmployeeDto dto = new EmployeeDto();
			BeanUtils.copyProperties(entity, dto);
			dtoList.add(dto);
		});
		
		return dtoList;
	
	}


	@Override
	public List<EmployeeDto> getEmployeesBySalaryGreaterThanOrEqual(Float salary) {
		List<EmployeeEntity> entityList = empRepo.findBySalaryGreaterThanEqual(salary);
	
		List<EmployeeDto> dtoList = new ArrayList<EmployeeDto>();
		entityList.forEach(entity->{
			EmployeeDto dto = new EmployeeDto();
			BeanUtils.copyProperties(entity, dto);
			dtoList.add(dto);
		});
		
		return dtoList;
	}


	@Override
	public List<EmployeeDto> getEmployeesThatContainsInName(String chars) {
		List<EmployeeEntity> entityList = empRepo.findByNameContaining(chars);
		
		List<EmployeeDto> dtoList = new ArrayList<EmployeeDto>();
		entityList.forEach(entity->{
			EmployeeDto dto = new EmployeeDto();
			BeanUtils.copyProperties(entity, dto);
			dtoList.add(dto);
		});
		
		return dtoList;
	}


	@Override
	public List<EmployeeDto> getEmployeesByNameIgnoringCase(String name) {
		List<EmployeeEntity> entityList = empRepo.findByNameIgnoreCase(name);
		
		List<EmployeeDto> dtoList = new ArrayList<EmployeeDto>();
		entityList.forEach(entity->{
			EmployeeDto dto = new EmployeeDto();
			BeanUtils.copyProperties(entity, dto);
			dtoList.add(dto);
		});
		
		return dtoList;
	}


	@Override
	public List<EmployeeDto> getEmployeesBySalaryOrderByNameDesc(Float salary) {
		Iterable<EmployeeEntity> entityList = empRepo.findBySalaryOrderByNameDesc(salary);
		
		List<EmployeeDto> dtoList = new ArrayList<EmployeeDto>();
		
		entityList.forEach(entity->{
			EmployeeDto dto = new EmployeeDto();
			BeanUtils.copyProperties(entity, dto);
			dtoList.add(dto);
		});
		
		return dtoList;
	}


	@Override
	public List<EmployeeDto> getEmployeesByNameAndCity(String name, String city) {
		
		List<EmployeeDto> dtoList = new ArrayList<EmployeeDto>();
		
		empRepo.findByNameAndCity(name, city).forEach(entity->{
			EmployeeDto dto = new EmployeeDto();
			BeanUtils.copyProperties(entity, dto);
			dtoList.add(dto);
		});
		
		return dtoList;
	}


	@Override
	public List<EmployeeDto> getEmployeesByCityAndSalary(String city, Float salary) {
		List<EmployeeDto> dtoList = new ArrayList<EmployeeDto>();
		
		empRepo.findByCityAndSalary(city, salary).forEach(entity->{
			EmployeeDto dto = new EmployeeDto();
			BeanUtils.copyProperties(entity, dto);
			dtoList.add(dto);
		});
		
		return dtoList;
	}


	@Override
	public List<EmployeeDto> getEmployeesBySalaryGreaterThanEqualAndNameContainingOrCity(Float salary, String chars, String city) {
			List<EmployeeDto> dtoList = new ArrayList<EmployeeDto>();
	
	empRepo.findBySalaryGreaterThanEqualAndNameContainingOrCity(salary, chars, city).forEach(entity->{
		EmployeeDto dto = new EmployeeDto();
		BeanUtils.copyProperties(entity, dto);
		dtoList.add(dto);
	});
	
	return dtoList;
		
	}


	@Override
	public List<EmployeeDto> getEmployeesByNamesAndCities(Collection<String> names, Collection<String> cities) {
		
		List<EmployeeDto> dtoList = new ArrayList<EmployeeDto>();
		
		empRepo.findByNameInOrCityIn(names, cities).forEach(entity->{
			EmployeeDto dto = new EmployeeDto();
			BeanUtils.copyProperties(entity, dto);
			dtoList.add(dto);
		});
		
		return dtoList;
		
		
	}
 
	
	
	
	
	
	
	
	
	
	
	
	
}
