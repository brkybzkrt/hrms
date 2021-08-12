package project.hrms.business.abstracts;

import java.util.List;

import project.hrms.core.utilities.results.DataResult;
import project.hrms.core.utilities.results.Result;
import project.hrms.entities.concretes.Education;
import project.hrms.entities.dtos.EducationDto;

public interface EducationService {

	Result add(EducationDto educationDto);
	
	Result update(int id,EducationDto educationDto);
	
	DataResult<EducationDto> getById(int educationId);
	
	DataResult<List<Education>> getAllByCvId(int cvId);
}
