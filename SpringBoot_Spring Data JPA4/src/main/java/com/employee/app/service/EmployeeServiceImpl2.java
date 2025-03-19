package com.employee.app.service;

import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.employee.app.repo.EmployeeRepository3;
import com.employee.app.repo.ResultView;

@Service("empService2")
public class EmployeeServiceImpl2  implements EmployeeService{
    
	@Autowired
	@Qualifier("empRepo3")
	private EmployeeRepository3 empRepo;

	@Override
	public List<ResultView> getEmployeesDataByCities(Collection<String> cities) {
	
		return empRepo.findByCityIn(cities);
		
	}
	
	

	
}
