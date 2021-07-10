package project.hrms.business.concretes;


import java.time.LocalDate;
import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;



import project.hrms.core.utilities.dtoConverter.DtoConverterService;
import project.hrms.core.utilities.results.DataResult;
import project.hrms.core.utilities.results.ErrorResult;
import project.hrms.business.abstracts.JobAdvertisementService;
import project.hrms.core.utilities.results.Result;
import project.hrms.core.utilities.results.SuccessDataResult;
import project.hrms.core.utilities.results.SuccessResult;
import project.hrms.dataAccess.abstracts.ConfirmedEmployerByEmployeeDao;
import project.hrms.dataAccess.abstracts.JobAdvertisementActivationByEmployeeDao;
import project.hrms.dataAccess.abstracts.JobAdvertisementDao;
import project.hrms.entities.concretes.JobAdvertisement;
import project.hrms.entities.concretes.JobAdvertisementActivationByEmployee;
import project.hrms.entities.dtos.AddJobAdvertisementDto;
import project.hrms.entities.dtos.JobAdvertisementDto;



@Service
public class JobAdvertisementManager implements JobAdvertisementService {

	
	private JobAdvertisementDao jobAdvertisementDao;
	private JobAdvertisementActivationByEmployeeDao jobAdvertisementActivationByEmployeeDao;
	private DtoConverterService dtoConverterService; 
	private ConfirmedEmployerByEmployeeDao confirmedEmployerByEmployeeDao;
	
	@Autowired
	public JobAdvertisementManager(JobAdvertisementDao jobAdvertisementDao,DtoConverterService dtoConverterService,JobAdvertisementActivationByEmployeeDao jobAdvertisementActivationByEmployeeDao,ConfirmedEmployerByEmployeeDao confirmedEmployerByEmployeeDao) {
		super();
		this.jobAdvertisementDao = jobAdvertisementDao;
		this.dtoConverterService=dtoConverterService;
		this.jobAdvertisementActivationByEmployeeDao=jobAdvertisementActivationByEmployeeDao;
		this.confirmedEmployerByEmployeeDao=confirmedEmployerByEmployeeDao;
		
	}

	
	@Override
	public Result add(AddJobAdvertisementDto addJobAdvertisementDto) {
		
		int getEmployerId= addJobAdvertisementDto.getEmployerId();

		if(this.confirmedEmployerByEmployeeDao.getByEmployer_Id(getEmployerId).isConfirmed()) {
			addJobAdvertisementDto.setReleaseDate(LocalDate.now());
			addJobAdvertisementDto.setStatusOfActive(true);
			
			

			
			JobAdvertisement ja= this.jobAdvertisementDao.save((JobAdvertisement) this.dtoConverterService.dtoClassConverter(addJobAdvertisementDto, JobAdvertisement.class));
			
			
			JobAdvertisementActivationByEmployee jAE= new JobAdvertisementActivationByEmployee();
			
			jAE.setJobAdvertisement(ja);
			jAE.setIsConfirmed(false);
			
			this.jobAdvertisementActivationByEmployeeDao.save(jAE);
			
			
			return new SuccessResult("iş ilanı kaydı başarılı"); 
			
		}
		else {
			
			return new ErrorResult("Onaylanmamış iş veren");
		}
		
	}
	
	
	@Override
	public DataResult<List<JobAdvertisementDto>> getAll() {
		
		
	return new SuccessDataResult<List<JobAdvertisementDto>>(this.dtoConverterService.dtoConverter( this.jobAdvertisementDao.getByJobAdvertisementActivationByEmployee_IsConfirmedAndStatusOfActive(true,true), JobAdvertisementDto.class));
		
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


	@Override
	public DataResult<List<JobAdvertisementDto>> findAllByJobAdvertisementActivationByEmployee_IsConfirmedAndStatusOfActive(
			int pageNo, int pageSize,String cityName,String jobPositionName) 
	{
		
		Pageable pageable= PageRequest.of(pageNo-1, pageSize);
		if(cityName==null && jobPositionName==null) {
			return new SuccessDataResult<List<JobAdvertisementDto>>(this.dtoConverterService.dtoConverter(this.jobAdvertisementDao.findAllByJobAdvertisementActivationByEmployee_IsConfirmedAndStatusOfActive(pageable, true, true), JobAdvertisementDto.class));
			
		}
		else if(jobPositionName!=null && cityName==null) {
			return new SuccessDataResult<List<JobAdvertisementDto>>(this.dtoConverterService.dtoConverter(this.jobAdvertisementDao.findAllByJobAdvertisementActivationByEmployee_IsConfirmedAndStatusOfActiveAndJobPositionNameContaining(pageable, true, true, jobPositionName), JobAdvertisementDto.class));
		}
		
		else if(cityName!=null && jobPositionName==null){
			return new SuccessDataResult<List<JobAdvertisementDto>>(this.dtoConverterService.dtoConverter(this.jobAdvertisementDao.findAllByJobAdvertisementActivationByEmployee_IsConfirmedAndStatusOfActiveAndCityNameContaining(pageable, true, true, cityName), JobAdvertisementDto.class));
		}
		
		else {
			
			return new SuccessDataResult<List<JobAdvertisementDto>>(this.dtoConverterService.dtoConverter
			(this.jobAdvertisementDao.findAllByJobAdvertisementActivationByEmployee_IsConfirmedAndStatusOfActiveAndJobPositionNameContainingAndCityNameContaining(pageable, true, true, jobPositionName, cityName), JobAdvertisementDto.class));
		}
		
	}


	@Override
	public Result update(int jobAdvertisementId,AddJobAdvertisementDto addJobAdvertisementDto) {
		JobAdvertisement updatedJA= this.jobAdvertisementDao.getById(jobAdvertisementId);
		
		JobAdvertisement asd=(JobAdvertisement) this.dtoConverterService.dtoClassConverter(addJobAdvertisementDto, JobAdvertisement.class);
		
		updatedJA.setCity(asd.getCity());
		updatedJA.setCountOfPosition(asd.getCountOfPosition());
		updatedJA.setEmployer(asd.getEmployer());
		updatedJA.setJobDescription(asd.getJobDescription());
		updatedJA.setDeadlineDate(asd.getDeadlineDate());

		updatedJA.setJobPosition(asd.getJobPosition());
		
		updatedJA.setJobType(asd.getJobType());
		updatedJA.setMinSalary(asd.getMinSalary());
		updatedJA.setMaxSalary(asd.getMaxSalary());
		updatedJA.setWorkingTime(asd.getWorkingTime());
		updatedJA.setReleaseDate(updatedJA.getReleaseDate());
		
		this.jobAdvertisementDao.save(updatedJA);
		
		return  new SuccessResult("İş ilanı başarıyla güncellendi");
		
	}


	@Override
	public DataResult<AddJobAdvertisementDto> getById(int id) {
		JobAdvertisement get=this.jobAdvertisementDao.getById(id);
	return new SuccessDataResult<AddJobAdvertisementDto>((AddJobAdvertisementDto) this.dtoConverterService.dtoClassConverter(get, AddJobAdvertisementDto.class));
		
	}




	
		
		
	


	


	
	

}
