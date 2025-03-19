package com.employee.app.service;

import java.util.List;

public interface CompanyMgmtService {
	
	public List<Object[]> fetchJoinsDataParentToChild();
	public List<Object[]> fetchJoinsDataChildToParent();

}
