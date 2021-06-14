package project.hrms.business.abstracts;

import java.util.List;

import project.hrms.core.utilities.results.DataResult;
import project.hrms.entities.concretes.JobType;

public interface JobTypeService {
	DataResult<List<JobType>> getAll();
}
