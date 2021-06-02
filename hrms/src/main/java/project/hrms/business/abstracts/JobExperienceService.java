package project.hrms.business.abstracts;

import java.util.List;

import project.hrms.core.utilities.results.DataResult;
import project.hrms.core.utilities.results.Result;
import project.hrms.entities.concretes.JobExperience;

public interface JobExperienceService {

	
	Result add(JobExperience jobExperience);
	
	DataResult<List<JobExperience>> getAll();
}
