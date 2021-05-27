package project.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import project.hrms.business.abstracts.EmployerService;
import project.hrms.business.required.EmailVerificationService;
import project.hrms.business.required.MailControl;

import project.hrms.core.utilities.results.DataResult;
import project.hrms.core.utilities.results.ErrorResult;
import project.hrms.core.utilities.results.Result;
import project.hrms.core.utilities.results.SuccessDataResult;
import project.hrms.core.utilities.results.SuccessResult;
import project.hrms.dataAccess.abstracts.EmployerDao;
import project.hrms.dataAccess.abstracts.UserDao;

import project.hrms.entities.concretes.Employer;

@Service
public class EmployerManager implements EmployerService {

	private EmployerDao employerDao;
	private UserDao userDao;
	private MailControl mailControl;
	private EmailVerificationService emailVerificationService; 
	
	
	
	@Autowired
	public EmployerManager(EmployerDao employerDao,UserDao userDao,MailControl mailControl,EmailVerificationService emailVerificationService) {
		super();
		this.employerDao = employerDao;
		this.userDao=userDao;
		this.mailControl=mailControl;
		this.emailVerificationService=emailVerificationService;
		
	}



	@Override
	public DataResult<List<Employer>>  getAll() {
		
		 
		 return new SuccessDataResult<List<Employer>>(this.employerDao.findAll(),"İş verenler listelendi.");
	}



	@Override
	public Result add(Employer employer) {
		
		if(this.userDao.existsByEmail(employer.getEmail())) {
			
			return new ErrorResult("email hesabı mevcut");
			
		}
		else {
			
			if(this.mailControl.checkEmailAddress(employer.getEmail(), employer.getCompanyName())) {
				
				this.employerDao.save(employer);
				this.emailVerificationService.verification(employer);
				return new SuccessResult("ekleme başarılı");
			}
			else {
				
				return new ErrorResult("email adresi domainle uyumsuz");
			}
		}
		
		
		
		
	}

}
