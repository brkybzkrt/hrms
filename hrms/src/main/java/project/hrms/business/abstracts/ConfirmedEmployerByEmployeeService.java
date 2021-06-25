package project.hrms.business.abstracts;

import project.hrms.core.utilities.results.Result;


public interface ConfirmedEmployerByEmployeeService {

	
	Result confirmEmployer(int employeeId,int employerId);
}
