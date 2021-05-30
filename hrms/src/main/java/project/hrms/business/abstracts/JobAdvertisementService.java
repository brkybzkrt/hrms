package project.hrms.business.abstracts;


import java.util.List;



import project.hrms.core.utilities.results.DataResult;
import project.hrms.core.utilities.results.Result;

import project.hrms.entities.concretes.JobAdvertisement;
import project.hrms.entities.dtos.JobAdvertisementDto;


public interface JobAdvertisementService {

	Result add(JobAdvertisement jobAdvertisement);
	
	DataResult<List<JobAdvertisementDto>> getAll();
	
	DataResult<List<JobAdvertisement>> getAllSortedBySalary(boolean sortType);
	
	
	DataResult<List<JobAdvertisement>> getByEmployerId(int id);
	
	DataResult<List<JobAdvertisementDto>> getAllSortByDate(boolean sortByDate);
	
	DataResult<List<JobAdvertisement>> getByStatusOfActive(boolean status);
	
	Result changeStatus(int id,boolean status);
}
