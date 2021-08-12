package project.hrms.business.concretes;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;


import project.hrms.business.abstracts.EmployerService;
import project.hrms.business.required.EmailVerificationService;
import project.hrms.business.required.MailControl;

import project.hrms.core.utilities.results.DataResult;
import project.hrms.core.utilities.results.ErrorResult;
import project.hrms.core.utilities.results.Result;
import project.hrms.core.utilities.results.SuccessDataResult;
import project.hrms.core.utilities.results.SuccessResult;
import project.hrms.dataAccess.abstracts.ConfirmedEmployerByEmployeeDao;
import project.hrms.dataAccess.abstracts.ConfirmedEmployerUpdateByEmployeeDao;
import project.hrms.dataAccess.abstracts.EmployerDao;
import project.hrms.dataAccess.abstracts.EmployerUpdateDao;
import project.hrms.dataAccess.abstracts.UserDao;
import project.hrms.entities.concretes.ConfirmedEmployerByEmployee;
import project.hrms.entities.concretes.ConfirmedEmployerUpdateByEmployee;
import project.hrms.entities.concretes.Employer;
import project.hrms.entities.concretes.EmployerUpdate;

@Service
public class EmployerManager implements EmployerService {

	private EmployerDao employerDao;
	private UserDao userDao;
	private MailControl mailControl;
	private EmailVerificationService emailVerificationService; 
	private ConfirmedEmployerByEmployeeDao confirmedEmployerByEmployeeDao; 
	private PasswordEncoder passwordEncoder;
	private EmployerUpdateDao  updateEmployerDao;
	private ConfirmedEmployerUpdateByEmployeeDao confirmedEmployerUpdateByEmployeeDao; 
	
	@Autowired
	public EmployerManager(EmployerDao employerDao,UserDao userDao,MailControl mailControl,EmailVerificationService emailVerificationService,ConfirmedEmployerByEmployeeDao confirmedEmployerByEmployeeDao,EmployerUpdateDao  updateEmployerDao,ConfirmedEmployerUpdateByEmployeeDao confirmedEmployerUpdateByEmployeeDao) {
		super();
		this.employerDao = employerDao;
		this.userDao=userDao;
		this.mailControl=mailControl;
		this.emailVerificationService=emailVerificationService;
		this.confirmedEmployerByEmployeeDao=confirmedEmployerByEmployeeDao;
		this.passwordEncoder= new BCryptPasswordEncoder();
		this.updateEmployerDao= updateEmployerDao;
		this.confirmedEmployerUpdateByEmployeeDao=confirmedEmployerUpdateByEmployeeDao;
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
			
			if(this.mailControl.checkEmailAddress(employer.getEmail(), employer.getWebAddress())) {
				this.emailVerificationService.verification(employer);
				employer.setPassword(this.passwordEncoder.encode(employer.getPassword()));
				 this.employerDao.save(employer);
				
				 ConfirmedEmployerByEmployee confirmedEmployerByEmployee= new ConfirmedEmployerByEmployee();
				 
				 confirmedEmployerByEmployee.setEmployer(employer);
				 confirmedEmployerByEmployee.setConfirmed(false);
				 this.confirmedEmployerByEmployeeDao.save(confirmedEmployerByEmployee);
				 
				return new SuccessResult("ekleme başarılı");
			}
			else {
				
				return new ErrorResult("email adresi domainle uyumsuz");
			}
		}
		
		
		
		
	}



	@Override
	public Result update(int employerId,EmployerUpdate employerUpdate) {
		
		if(this.employerDao.existsById(employerId)) {
			
			Employer getUpdate = this.employerDao.getOne(employerId);
			
			employerUpdate.setEmployer(getUpdate);
			employerUpdate.setConfirmedStatus(false);
			employerUpdate.setUpdateDate(LocalDate.now());
			employerUpdate.setPassword(getUpdate.getPassword());
			this.updateEmployerDao.save(employerUpdate);
			
			
			ConfirmedEmployerUpdateByEmployee confirmedEmployerUpdateByEmployee= new ConfirmedEmployerUpdateByEmployee();
			confirmedEmployerUpdateByEmployee.setConfirmedStatus(false);
			confirmedEmployerUpdateByEmployee.setEmployer(getUpdate);
			this.confirmedEmployerUpdateByEmployeeDao.save(confirmedEmployerUpdateByEmployee);
			
			return new SuccessResult("Güncelleme isteği başarıyla onaya gönderildi");
		}
		
		else {
			
			return new ErrorResult("Kayıt bulunamadı");
		}
		
		
		
	}

	
	


	@Override
	public DataResult<Employer> getById(int id) {
	return new SuccessDataResult<Employer>(this.employerDao.getOne(id),"iş veren getirildi");
	}

}
