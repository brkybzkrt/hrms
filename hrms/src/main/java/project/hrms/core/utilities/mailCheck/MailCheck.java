package project.hrms.core.utilities.mailCheck;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.stereotype.Service;

@Service
public class MailCheck {

	public boolean userEmailControl(String email) {
		Pattern eslesme= Pattern.compile("[a-zA-Z0-9]{5,}@(gmail|outlook|yandex|hotmail).com");
		
		Matcher kontrol = eslesme.matcher(email);
		
		if(kontrol.matches()) {
			
			return true;
			
		}
		else {
			
			return false;
		}
		
	}
	
	
	
	public boolean checkEmailAddress(String email,String company_name) {
		
		
		Pattern check = Pattern.compile("[a-zA-Z]{2,}@"+company_name+".com");
		Matcher kontrol = check.matcher(email);
		
		if(kontrol.matches()) {
			
			return true;
		}
		
		else {
			
			return false;
		}
	}
}
