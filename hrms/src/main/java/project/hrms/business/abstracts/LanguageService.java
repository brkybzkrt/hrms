package project.hrms.business.abstracts;

import java.util.List;

import project.hrms.core.utilities.results.DataResult;
import project.hrms.core.utilities.results.Result;
import project.hrms.entities.concretes.Language;
import project.hrms.entities.dtos.LanguageDto;

public interface LanguageService {

	Result add(LanguageDto languageDto);
	
	DataResult< List<Language>>  getByCvId(int cvId);
	
	Result update(int id,Language language);
	
}
