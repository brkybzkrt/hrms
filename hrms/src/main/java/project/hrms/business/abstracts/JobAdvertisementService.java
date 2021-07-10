package project.hrms.business.abstracts;


import java.util.List;

import org.springframework.data.domain.Page;

import project.hrms.core.utilities.results.DataResult;
import project.hrms.core.utilities.results.Result;
import project.hrms.entities.concretes.JobAdvertisement;
import project.hrms.entities.dtos.AddJobAdvertisementDto;
import project.hrms.entities.dtos.JobAdvertisementDto;


public interface JobAdvertisementService {

	Result add(AddJobAdvertisementDto addJobAdvertisementDto);
	
	DataResult<List<JobAdvertisementDto>> findAllByJobAdvertisementActivationByEmployee_IsConfirmedAndStatusOfActive(int pageNo, int pageSize,String name,String jobPositionName);
	
	DataResult<List<JobAdvertisementDto>> getAll();
	
	DataResult<List<JobAdvertisementDto>> getByStatusOfActiveAndEmployer_CompanyName(boolean status,String employerName);
	
	
	DataResult<List<JobAdvertisementDto>> getByEmployer_CompanyName(String companyName);
	
	DataResult<List<JobAdvertisementDto>> getAllSortByDate(boolean sortByDate);
	
	DataResult<List<JobAdvertisementDto>> getByStatusOfActive();
	
	Result changeStatus(int id,boolean status);
	
	
	Result update(int jobAdvertisementId,AddJobAdvertisementDto addJobAdvertisementDto);
	
	DataResult<AddJobAdvertisementDto> getById(int id);
	
}
