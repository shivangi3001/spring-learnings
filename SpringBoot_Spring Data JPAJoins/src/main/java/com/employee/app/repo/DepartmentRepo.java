package com.employee.app.repo;

import java.util.List;

import org.aspectj.weaver.ast.Literal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.employee.app.entity.DepartmentEntity;

@Repository("departmentRepo")
public interface DepartmentRepo extends JpaRepository<DepartmentEntity, Integer> {
      
	
	@Query("select d.deptId, d.name, d.deptLocation, e.eid, e.name, e.email, e.salary, e.city from DepartmentEntity d inner join d.employees e ")
	public List<Object[]> getJoinsDataParentToChild();
	
	
}
