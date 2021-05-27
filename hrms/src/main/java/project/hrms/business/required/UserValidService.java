package project.hrms.business.required;

import project.hrms.entities.concretes.Candidate;

public interface UserValidService {

	 boolean personIsValid(Candidate candidate);
		
}
