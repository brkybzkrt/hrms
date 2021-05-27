package project.hrms.business.required;

public interface MailControl {

	
	boolean userEmailControl(String email);
	boolean checkEmailAddress(String email,String company_name);
}
