package project.hrms.core.utilities.emailVerification;

import org.springframework.stereotype.Service;

import project.hrms.core.utilities.results.Result;
import project.hrms.core.utilities.results.SuccessResult;

@Service
public class EmailVerification<T> {

	
	public Result verification(T entity) {
		
		return new SuccessResult("Doğrulama bağlantısı emailinize gönderilmiştir.");
	
		
		
	}
	
}
