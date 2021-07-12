package project.hrms.business.abstracts;

import project.hrms.core.utilities.results.Result;

public interface ConfirmedEmployerUpdateByEmployeeService {

	
	
	Result confirmToEmployerUpdate(int employerId,int employeeId);
}
