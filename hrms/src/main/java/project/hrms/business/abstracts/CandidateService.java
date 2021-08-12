package project.hrms.business.abstracts;

import java.util.List;

import project.hrms.core.utilities.results.DataResult;
import project.hrms.core.utilities.results.Result;
import project.hrms.entities.concretes.Candidate;
import project.hrms.entities.dtos.CandidateProfileDto;



public interface CandidateService {

	
	
	DataResult<List<Candidate>>  getAll();
	
	Result add(Candidate candidate);
	
	DataResult<CandidateProfileDto> getById(int candidateId);
}
