package project.hrms.business.abstracts;

import project.hrms.core.utilities.results.Result;
import project.hrms.entities.concretes.User;

public interface ActivationCodeService {

	
	String createActivationCode(User user);
	
	
	Result userVerify(String activationCode);
	
	
	
}
