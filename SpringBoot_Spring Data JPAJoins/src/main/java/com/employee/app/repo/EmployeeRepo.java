package com.employee.app.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.employee.app.entity.EmployeeEntity;

@Repository("empRepo")
public interface EmployeeRepo extends JpaRepository<EmployeeEntity, Integer>{
  
	

	@Query("select e.id, e.name, d.name from EmployeeEntity e left join e.dept d")
	public List<Object[]> getJoinsDataChildToParent();
	
	
}
