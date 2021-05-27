package project.hrms.business.required;

import org.springframework.stereotype.Service;

import project.hrms.core.utilities.emailVerification.EmailVerification;
import project.hrms.entities.concretes.User;

@Service
public class EmailVerificationManager implements EmailVerificationService{

	private EmailVerification<User> emailVerification;
	
	
	
	public EmailVerificationManager(EmailVerification<User> emailVerification) {
		super();
		this.emailVerification = emailVerification;
	}



	@Override
	public void verification(User user) {
		this.emailVerification.verification(user);
		
	}

}
