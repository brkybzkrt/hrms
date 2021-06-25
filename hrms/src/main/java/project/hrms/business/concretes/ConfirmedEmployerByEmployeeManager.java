package project.hrms.business.concretes;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import project.hrms.business.abstracts.ConfirmedEmployerByEmployeeService;
import project.hrms.core.utilities.results.Result;
import project.hrms.core.utilities.results.SuccessResult;
import project.hrms.dataAccess.abstracts.ConfirmedEmployerByEmployeeDao;
import project.hrms.dataAccess.abstracts.EmployeeDao;
import project.hrms.entities.concretes.ConfirmedEmployerByEmployee;

@Service
public class ConfirmedEmployerByEmployeeManager implements ConfirmedEmployerByEmployeeService{

	private ConfirmedEmployerByEmployeeDao confirmedEmployerByEmployeeDao;
	private EmployeeDao employeeDao;
	
	@Autowired
	public ConfirmedEmployerByEmployeeManager(ConfirmedEmployerByEmployeeDao confirmedEmployerByEmployeeDao,EmployeeDao employeeDao) {
		super();
		this.confirmedEmployerByEmployeeDao = confirmedEmployerByEmployeeDao;
		this.employeeDao=employeeDao;
	}

	@Override
	public Result confirmEmployer(int employeeId,int employerId) {
		
		ConfirmedEmployerByEmployee confirmedEmployerByEmployee=this.confirmedEmployerByEmployeeDao.getByEmployer_Id(employerId);
		 
		confirmedEmployerByEmployee.setEmployee(this.employeeDao.getOne(employeeId));
		confirmedEmployerByEmployee.setConfirmed(true);
		
		LocalDate localDate= LocalDate.now();
		confirmedEmployerByEmployee.setConfirmedDate(localDate);
		
		this.confirmedEmployerByEmployeeDao.save(confirmedEmployerByEmployee);
		
		return new SuccessResult("İş veren onaylandı");
	}

}
