package project.hrms.business.abstracts;

import java.util.List;

import project.hrms.core.utilities.results.DataResult;
import project.hrms.entities.concretes.EmployerUpdate;

public interface EmployerUpdateService {

	
	DataResult<List<EmployerUpdate>> getAllActiveOfStatus(boolean status);
}
