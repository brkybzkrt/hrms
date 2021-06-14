package project.hrms.business.abstracts;

import java.util.List;

import project.hrms.core.utilities.results.DataResult;
import project.hrms.core.utilities.results.Result;
import project.hrms.entities.concretes.JobAdvertisementActivationByEmployee;

public interface JobAdvertisementActivationByEmployeeService {

	Result add(JobAdvertisementActivationByEmployee jobAdvertisementActivationByEmployee);
	
	DataResult<List<JobAdvertisementActivationByEmployee>> getAll();
	
	DataResult<JobAdvertisementActivationByEmployee> getByJobAdvertisementId(int id);
	
	Result confirmToJobAdvertisement(int jobAdvertisementId,int employeeId);
}
