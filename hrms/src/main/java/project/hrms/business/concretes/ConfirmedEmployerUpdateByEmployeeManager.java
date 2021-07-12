package project.hrms.business.concretes;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import project.hrms.business.abstracts.ConfirmedEmployerUpdateByEmployeeService;
import project.hrms.core.utilities.results.Result;
import project.hrms.core.utilities.results.SuccessResult;
import project.hrms.dataAccess.abstracts.ConfirmedEmployerUpdateByEmployeeDao;
import project.hrms.dataAccess.abstracts.EmployeeDao;
import project.hrms.dataAccess.abstracts.EmployerDao;
import project.hrms.dataAccess.abstracts.EmployerUpdateDao;
import project.hrms.entities.concretes.ConfirmedEmployerUpdateByEmployee;
import project.hrms.entities.concretes.Employee;
import project.hrms.entities.concretes.Employer;
import project.hrms.entities.concretes.EmployerUpdate;

@Service
public class ConfirmedEmployerUpdateByEmployeeManager implements ConfirmedEmployerUpdateByEmployeeService{

	private ConfirmedEmployerUpdateByEmployeeDao confirmedEmployerUpdateByEmployeeDao;
	private EmployerUpdateDao employerUpdateDao;
	private EmployerDao employerDao;
	private EmployeeDao employeeDao;
	
	
	@Autowired
	public ConfirmedEmployerUpdateByEmployeeManager(
			ConfirmedEmployerUpdateByEmployeeDao confirmedEmployerUpdateByEmployeeDao,
			EmployerUpdateDao employerUpdateDao, EmployerDao employerDao,EmployeeDao employeeDao) {
		super();
		this.confirmedEmployerUpdateByEmployeeDao = confirmedEmployerUpdateByEmployeeDao;
		this.employerUpdateDao = employerUpdateDao;
		this.employerDao = employerDao;
		this.employeeDao=employeeDao;
	}



	@Override
	public Result confirmToEmployerUpdate(int employerId,int employeeId) {
		Employer updateEmployer= this.employerDao.getOne(employerId);
		EmployerUpdate getUpdatedEmployer=this.employerUpdateDao.findByEmployer_Id(employerId);
		Employee getEmployee= this.employeeDao.getOne(employeeId);
		
		updateEmployer.setCompanyName(getUpdatedEmployer.getCompanyName());
		updateEmployer.setEmail(getUpdatedEmployer.getEmail());
		updateEmployer.setPhoneNumber(getUpdatedEmployer.getPhoneNumber());
		updateEmployer.setWebAddress(getUpdatedEmployer.getWebAddress());
		
		this.employerDao.save(updateEmployer);
		
		ConfirmedEmployerUpdateByEmployee confirmedEmployerUpdateByEmployee= this.confirmedEmployerUpdateByEmployeeDao.findByEmployerId(employerId);
		confirmedEmployerUpdateByEmployee.setConfirmedDate(LocalDate.now());
		confirmedEmployerUpdateByEmployee.setEmployee(getEmployee);
		confirmedEmployerUpdateByEmployee.setConfirmedStatus(true);
		
		this.confirmedEmployerUpdateByEmployeeDao.save(confirmedEmployerUpdateByEmployee);
		
		return new SuccessResult("Güncelleme başarıyla onaylandı");
	}

}
