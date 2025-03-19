package com.employee.app.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.employee.app.entity.EmployeeEntity;

@Repository("empRepo")
public interface EmployeeRepo extends PagingAndSortingRepository<EmployeeEntity, Integer>{

}
