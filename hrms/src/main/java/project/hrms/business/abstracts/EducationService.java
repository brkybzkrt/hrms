package project.hrms.business.abstracts;

import java.util.List;

import project.hrms.core.utilities.results.DataResult;
import project.hrms.core.utilities.results.Result;
import project.hrms.entities.concretes.Education;

public interface EducationService {

	Result add(Education education);
	
	DataResult< List<Education>> getAll();
}
