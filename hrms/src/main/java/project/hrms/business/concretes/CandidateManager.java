package project.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import project.hrms.business.abstracts.ActivationCodeService;
import project.hrms.business.abstracts.CandidateService;
import project.hrms.business.required.EmailVerificationService;
import project.hrms.business.required.MailControl;

import project.hrms.business.required.UserValidService;
import project.hrms.core.utilities.results.DataResult;
import project.hrms.core.utilities.results.ErrorResult;
import project.hrms.core.utilities.results.Result;
import project.hrms.core.utilities.results.SuccessDataResult;
import project.hrms.core.utilities.results.SuccessResult;
import project.hrms.dataAccess.abstracts.CandidateDao;
import project.hrms.dataAccess.abstracts.UserDao;
import project.hrms.entities.concretes.Candidate;


@Service
public class CandidateManager implements CandidateService {

	private CandidateDao candidateDao;
	private ActivationCodeService activationCodeService;
	private UserDao userDao;
	private UserValidService userValidService;
	private MailControl mailControl;
	private EmailVerificationService emailVerificationService; 
	private PasswordEncoder passwordEncoder;
	
	
	
	@Autowired
	public CandidateManager(CandidateDao candidateDao,ActivationCodeService activationCodeService, UserDao userDao,@Qualifier("fakemernis") UserValidService userValidService, MailControl mailControl,EmailVerificationService emailVerificationService) {
		super();
		this.candidateDao = candidateDao;
		this.activationCodeService=activationCodeService;
		this.userDao=userDao;
		this.userValidService=userValidService;
		this.mailControl=mailControl;
		this.emailVerificationService=emailVerificationService;
		this.passwordEncoder= new BCryptPasswordEncoder();
		
		
	}


	@Override
	public DataResult<List<Candidate>>  getAll() {
		
		 return new SuccessDataResult<List<Candidate>>(this.candidateDao.findAll(),"İş arayanlar listelendi.");
	}


	@Override
	public Result add(Candidate candidate) {
		
		if(this.userDao.existsByEmail(candidate.getEmail())) {
			
			return new ErrorResult("email adresi mevcut");
			
		}
		
		else {	
			
			if (this.userValidService.personIsValid(candidate)&& this.mailControl.userEmailControl(candidate.getEmail())&& !this.candidateDao.existsByNationalityId(candidate.getNationalityId())) {
				
				
				candidate.setPassword(this.passwordEncoder.encode(candidate.getPassword()));
				 this.candidateDao.save(candidate);
				 this.activationCodeService.createActivationCode(candidate);
				this.emailVerificationService.verification(candidate);
				
				
				 return new SuccessResult("kayıt başarılı");
				 
			}
			else {
				
				 return new ErrorResult("kayıt başarısız,tc kimlik veya girilen mailiniz hatalı");
			}
		}
		
		
	}

}
