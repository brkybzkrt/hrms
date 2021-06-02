package project.hrms.business.abstracts;

import java.util.List;

import project.hrms.core.utilities.results.DataResult;
import project.hrms.core.utilities.results.Result;

import project.hrms.entities.concretes.ProgrammingLanguage;

public interface ProgrammingLanguageService {

	
Result add(ProgrammingLanguage programmingLanguage);
	
	DataResult< List<ProgrammingLanguage>> getAll();
}
