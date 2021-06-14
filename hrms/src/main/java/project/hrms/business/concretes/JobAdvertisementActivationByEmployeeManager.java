package project.hrms.business.concretes;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import project.hrms.business.abstracts.JobAdvertisementActivationByEmployeeService;
import project.hrms.core.utilities.results.DataResult;
import project.hrms.core.utilities.results.Result;
import project.hrms.core.utilities.results.SuccessDataResult;
import project.hrms.core.utilities.results.SuccessResult;
import project.hrms.dataAccess.abstracts.EmployeeDao;
import project.hrms.dataAccess.abstracts.JobAdvertisementActivationByEmployeeDao;
import project.hrms.entities.concretes.JobAdvertisementActivationByEmployee;

@Service
public class JobAdvertisementActivationByEmployeeManager implements JobAdvertisementActivationByEmployeeService{

	private JobAdvertisementActivationByEmployeeDao jobAdvertisementActivationByEmployeeDao;
	private EmployeeDao employeeDao;
	
	@Autowired
	public JobAdvertisementActivationByEmployeeManager(
			JobAdvertisementActivationByEmployeeDao jobAdvertisementActivationByEmployeeDao,EmployeeDao employeeDao) {
		super();
		this.jobAdvertisementActivationByEmployeeDao = jobAdvertisementActivationByEmployeeDao;
		this.employeeDao=employeeDao;
	}

	@Override
	public DataResult<List<JobAdvertisementActivationByEmployee>> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DataResult<JobAdvertisementActivationByEmployee> getByJobAdvertisementId(int id) {
		return new SuccessDataResult<JobAdvertisementActivationByEmployee>(this.jobAdvertisementActivationByEmployeeDao.getByJobAdvertisement_Id(id),"Başarıyla getirildi"); 
	}

	@Override
	public Result confirmToJobAdvertisement(int jobAdvertisementId,int employeeId) {
		JobAdvertisementActivationByEmployee jobAdvertisementActivationByEmployee= this.jobAdvertisementActivationByEmployeeDao.getByJobAdvertisement_Id(jobAdvertisementId);
		
		jobAdvertisementActivationByEmployee.setEmployee(this.employeeDao.getOne(employeeId));
		jobAdvertisementActivationByEmployee.setIsConfirmed(true);
		LocalDate ld= LocalDate.now();
		jobAdvertisementActivationByEmployee.setConfirmedDate(ld);
		
		this.jobAdvertisementActivationByEmployeeDao.save(jobAdvertisementActivationByEmployee);
		
		return new SuccessResult("Başarıyla iş ilanı onaylandı");
	}

	@Override
	public Result add(JobAdvertisementActivationByEmployee jobAdvertisementActivationByEmployee) {
		
		this.jobAdvertisementActivationByEmployeeDao.save(jobAdvertisementActivationByEmployee);
		return new SuccessResult("Eklendi");
	}

}
