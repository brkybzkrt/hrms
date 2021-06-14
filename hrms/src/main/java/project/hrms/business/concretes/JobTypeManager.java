package project.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import project.hrms.business.abstracts.JobTypeService;
import project.hrms.core.utilities.results.DataResult;
import project.hrms.core.utilities.results.SuccessDataResult;
import project.hrms.dataAccess.abstracts.JobTypeDao;
import project.hrms.entities.concretes.JobType;

@Service
public class JobTypeManager implements JobTypeService{

	
	private JobTypeDao jobTypeDao; 
	
	@Autowired
	public JobTypeManager(JobTypeDao jobTypeDao) {
		super();
		this.jobTypeDao = jobTypeDao;
	}

	@Override
	public DataResult<List<JobType>> getAll() {
		
		return new SuccessDataResult<List<JobType>>(this.jobTypeDao.findAll(), "İş Tipleri getirildi.");
	}

}
