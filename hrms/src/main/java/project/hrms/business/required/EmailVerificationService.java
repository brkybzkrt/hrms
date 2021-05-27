package project.hrms.business.required;

import project.hrms.entities.concretes.User;

public interface EmailVerificationService {

	public void verification(User user);
}
