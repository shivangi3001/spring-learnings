package com.employee.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.employee.app.service.CompanyMgmtService;

@Controller("controller")
public class CompanyController {
	
	@Autowired
	private CompanyMgmtService service;
	
	public void getJoinsDataParentToChild() {
	List<Object[]> list = service.fetchJoinsDataParentToChild();
	
	list.forEach(row->{
		for(Object val : row) {
			System.out.println(val + "     ");
		}
		System.out.println();
	});
	}
	
	public void getJoinsDataChildToParent() {
		List<Object[]> list = service.fetchJoinsDataChildToParent();
		list.forEach(row->{
			for(Object val : row) {
				System.out.println(val  +  "     ");
				
			}
			System.out.println();
		});
	}

}
