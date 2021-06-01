package project.hrms.business.abstracts;

import java.util.List;

import project.hrms.core.utilities.results.DataResult;
import project.hrms.core.utilities.results.Result;
import project.hrms.entities.concretes.Cv;

public interface CvService {

	
	Result add(Cv cv);
	DataResult<List<Cv>> getAll();
}
