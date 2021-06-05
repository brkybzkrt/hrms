package project.hrms.business.concretes;


import java.time.LocalDate;
import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;



import project.hrms.core.utilities.dtoConverter.DtoConverterService;
import project.hrms.core.utilities.results.DataResult;

import project.hrms.business.abstracts.JobAdvertisementService;
import project.hrms.core.utilities.results.Result;
import project.hrms.core.utilities.results.SuccessDataResult;
import project.hrms.core.utilities.results.SuccessResult;
import project.hrms.dataAccess.abstracts.JobAdvertisementDao;
import project.hrms.entities.concretes.JobAdvertisement;
import project.hrms.entities.dtos.JobAdvertisementDto;



@Service
public class JobAdvertisementManager implements JobAdvertisementService {

	
	private JobAdvertisementDao jobAdvertisementDao;
	private DtoConverterService dtoConverterService; 
	
	@Autowired
	public JobAdvertisementManager(JobAdvertisementDao jobAdvertisementDao,DtoConverterService dtoConverterService) {
		super();
		this.jobAdvertisementDao = jobAdvertisementDao;
		this.dtoConverterService=dtoConverterService;
		
	}

	
	@Override
	public Result add(JobAdvertisement jobAdvertisement) {
		
		jobAdvertisement.setReleaseDate(LocalDate.now());
		
		this.jobAdvertisementDao.save(jobAdvertisement);
		return new SuccessResult("kayıt başarılı"); 
	}
	
	
	@Override
	public DataResult<List<JobAdvertisementDto>> getAll() {
		
		
	return new SuccessDataResult<List<JobAdvertisementDto>>(this.dtoConverterService.dtoConverter( this.jobAdvertisementDao.getByStatusOfActive(true), JobAdvertisementDto.class));
		
	}

	@Override
	public DataResult<List<JobAdvertisementDto>> getByEmployer_CompanyName(String companyName) {
		return new SuccessDataResult<List<JobAdvertisementDto>>(this.dtoConverterService.dtoConverter(this.jobAdvertisementDao.getByEmployer_CompanyName(companyName), JobAdvertisementDto.class));
				
	}

	@Override
	public DataResult<List<JobAdvertisementDto>> getAllSortByDate(boolean sortByDate) {
		
		if(sortByDate==true) {
			
			Sort sort = Sort.by(Sort.Direction.DESC,"releaseDate");
			return new SuccessDataResult<List<JobAdvertisementDto>>(this.dtoConverterService.dtoConverter(this.jobAdvertisementDao.findAll(sort),JobAdvertisementDto.class));
		}
		else {
			
			Sort sort = Sort.by(Sort.Direction.ASC,"releaseDate");
			return new SuccessDataResult<List<JobAdvertisementDto>>(this.dtoConverterService.dtoConverter(this.jobAdvertisementDao.findAll(sort),JobAdvertisementDto.class));
		}
	}

	@Override
	public DataResult<List<JobAdvertisementDto>> getByStatusOfActive() {
		return new SuccessDataResult<List<JobAdvertisementDto>>(this.dtoConverterService.dtoConverter(this.jobAdvertisementDao.getByStatusOfActive(true), JobAdvertisementDto.class));
		
		
	}

	@Override
	public Result changeStatus(int id,boolean status) {
		JobAdvertisement job = this.jobAdvertisementDao.getById(id);
		if(status==true) {
			job.setStatusOfActive(true);
			this.jobAdvertisementDao.save(job);
		}
		else {
			job.setStatusOfActive(false);
			this.jobAdvertisementDao.save(job);
			
		}
		
		return new SuccessResult(); 
	}


	@Override
	public DataResult<List<JobAdvertisementDto>> getByStatusOfActiveAndEmployer_CompanyName(boolean status,
			String employerName) {
		
		return new SuccessDataResult<List<JobAdvertisementDto>> (this.dtoConverterService.dtoConverter(this.jobAdvertisementDao.getByStatusOfActiveAndEmployer_CompanyName(true, employerName), JobAdvertisementDto.class));
		
		
	}


	
		
		
	


	


	
	

}
