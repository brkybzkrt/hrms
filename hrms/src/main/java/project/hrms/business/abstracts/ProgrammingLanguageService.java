package project.hrms.business.abstracts;

import java.util.List;

import project.hrms.core.utilities.results.DataResult;
import project.hrms.core.utilities.results.Result;

import project.hrms.entities.concretes.ProgrammingLanguage;
import project.hrms.entities.dtos.ProgrammingLanguageDto;

public interface ProgrammingLanguageService {

	
Result add(ProgrammingLanguageDto programmingLanguageDto);
	
	DataResult< List<ProgrammingLanguage>>  getByCvId(int cvId);
	
	DataResult<ProgrammingLanguageDto> getById(int pLId);
	
	Result update(int id,ProgrammingLanguageDto programmingLanguageDto);
}
