package project.hrms.business.concretes;


import java.time.LocalDate;
import java.util.UUID;

import org.springframework.stereotype.Service;

import project.hrms.business.abstracts.ActivationCodeService;
import project.hrms.core.utilities.results.ErrorResult;
import project.hrms.core.utilities.results.Result;
import project.hrms.core.utilities.results.SuccessResult;
import project.hrms.dataAccess.abstracts.ActivationCodeDao;
import project.hrms.entities.concretes.ActivationCode;
import project.hrms.entities.concretes.User;

@Service
public class ActivationCodeManager implements ActivationCodeService {

	
	
	private ActivationCodeDao activationCodeDao; 
	
	
	
	
	public ActivationCodeManager(ActivationCodeDao activationCodeDao) {
		super();
		this.activationCodeDao = activationCodeDao;
	}




	@Override
	public String createActivationCode(User user) {
		 String createCode=UUID.randomUUID().toString();
		 ActivationCode code = new ActivationCode();
		 LocalDate date = (LocalDate.now());
		 
		 code.setUserId(user);
		 code.setActivationCode(createCode.replace("-",""));
		 code.setCreatedDate(date);
		 this.activationCodeDao.save(code);
		 
		 return createCode;
		 
	}




	@Override
	public Result userVerify(String activationCode) {
		if(this.activationCodeDao.existsByActivationCode(activationCode)) {
			
			ActivationCode verifyCode = activationCodeDao.getByActivationCode(activationCode);
			LocalDate d= (LocalDate.now());
			
			verifyCode.setConfirmed(true);
			verifyCode.setConfirmDate(d);
			
			activationCodeDao.save(verifyCode);
			
			return new SuccessResult("Doğrulama başarılı");
			
			
		}
		else {
			
			return new ErrorResult("Aktivasyon kodu hatalı yada böyler bir aktivvasyon kodu yok");
		}
	}




	

}
