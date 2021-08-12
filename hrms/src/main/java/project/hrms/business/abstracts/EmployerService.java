package project.hrms.business.abstracts;

import java.util.List;

import project.hrms.core.utilities.results.DataResult;
import project.hrms.core.utilities.results.Result;
import project.hrms.entities.concretes.Employer;
import project.hrms.entities.concretes.EmployerUpdate;


public interface EmployerService {

	
	
	DataResult<List<Employer>>  getAll();
	Result add(Employer employer);
	Result update(int employerId,EmployerUpdate updateEmployer);
	
	
	
	DataResult<Employer> getById(int id);
	
}
