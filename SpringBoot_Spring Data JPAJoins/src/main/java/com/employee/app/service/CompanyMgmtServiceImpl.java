package com.employee.app.service;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.employee.app.entity.DepartmentEntity;
import com.employee.app.entity.EmployeeEntity;
import com.employee.app.repo.DepartmentRepo;
import com.employee.app.repo.EmployeeRepo;

import ch.qos.logback.core.recovery.ResilientSyslogOutputStream;

@Service("service")
public class CompanyMgmtServiceImpl implements CompanyMgmtService {

	@Autowired
	private EmployeeRepo empRepo;
	
	@Autowired
	@Qualifier("departmentRepo")
	private DepartmentRepo departmentRepo;

	@Override
	public List<Object[]> fetchJoinsDataParentToChild() {
		List<Object[]> list = departmentRepo.getJoinsDataParentToChild();
		return list;
	}

	@Override
	public List<Object[]> fetchJoinsDataChildToParent() {
		return empRepo.getJoinsDataChildToParent();
	}
	
	
}
