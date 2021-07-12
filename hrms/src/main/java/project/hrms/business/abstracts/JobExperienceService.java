package project.hrms.business.abstracts;

import java.util.List;

import project.hrms.core.utilities.results.DataResult;
import project.hrms.core.utilities.results.Result;
import project.hrms.entities.concretes.JobExperience;
import project.hrms.entities.dtos.JobExperienceDto;

public interface JobExperienceService {

	
	Result add(JobExperienceDto jobExperienceDto);
	
	DataResult<List<JobExperience>> getByCvId(int cvId);
	
	Result update(int id, JobExperience jobExperience);
}
