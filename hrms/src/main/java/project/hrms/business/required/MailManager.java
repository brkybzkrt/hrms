package project.hrms.business.required;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import project.hrms.core.utilities.mailCheck.MailCheck;


@Service
public class MailManager implements MailControl {

	
	private MailCheck mailCheck;
	
	
	@Autowired
	public MailManager(MailCheck mailCheck) {
		super();
		this.mailCheck = mailCheck;
	}


	@Override
	public boolean userEmailControl(String email) {
		
		if(this.mailCheck.userEmailControl(email)) {
			
			return true;
		}
		else {
			
			return false;
		}
	}


	@Override
	public boolean checkEmailAddress(String email, String company_name) {
		
		if(this.mailCheck.checkEmailAddress(email,company_name)) {
			
			return true;
		}
		else {
			
			return false;
		}
	}
	
	
}
