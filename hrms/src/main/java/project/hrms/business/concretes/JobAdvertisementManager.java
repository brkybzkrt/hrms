package project.hrms.business.concretes;


import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;


import project.hrms.core.converter.JobAdvertisementConverter;
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
	private JobAdvertisementConverter jobAdvertisementsConverter; 
	
	@Autowired
	public JobAdvertisementManager(JobAdvertisementDao jobAdvertisementDao,JobAdvertisementConverter jobAdvertisementsConverter) {
		super();
		this.jobAdvertisementDao = jobAdvertisementDao;
		this.jobAdvertisementsConverter=jobAdvertisementsConverter;
		
	}

	
	@Override
	public Result add(JobAdvertisement jobAdvertisement) {
		
		
		this.jobAdvertisementDao.save(jobAdvertisement);
		return new SuccessResult("kayıt başarılı"); 
	}
	
	
	@Override
	public DataResult<List<JobAdvertisementDto>> getAll() {
		
		
	return	new SuccessDataResult<List<JobAdvertisementDto>>(this.jobAdvertisementsConverter.entitiesToDto(this.jobAdvertisementDao.findAll()));
		
		
	}

	@Override
	public DataResult<List<JobAdvertisementDto>> getByEmployer_CompanyName(String companyName) {
		return new SuccessDataResult<List<JobAdvertisementDto>> (this.jobAdvertisementsConverter.entitiesToDto(this.jobAdvertisementDao.getByEmployer_CompanyName(companyName)));
				
	}

	@Override
	public DataResult<List<JobAdvertisementDto>> getAllSortByDate(boolean sortByDate) {
		
		if(sortByDate==true) {
			
			Sort sort = Sort.by(Sort.Direction.DESC,"releaseDate");
			return new SuccessDataResult<List<JobAdvertisementDto>>(this.jobAdvertisementsConverter.entitiesToDto(this.jobAdvertisementDao.findAll(sort)));
		}
		else {
			
			Sort sort = Sort.by(Sort.Direction.ASC,"releaseDate");
			return new SuccessDataResult<List<JobAdvertisementDto>>(this.jobAdvertisementsConverter.entitiesToDto(this.jobAdvertisementDao.findAll(sort)));
		}
	}

	@Override
	public DataResult<List<JobAdvertisement>> getByStatusOfActive(boolean status) {
		
		
		return new SuccessDataResult<List<JobAdvertisement>>( this.jobAdvertisementDao.getByStatusOfActive(status));
	}

	@Override
	public Result changeStatus(int id,boolean status) {
		JobAdvertisement job = this.jobAdvertisementDao.getById(id);
		if(status==true) {
			job.setStatusOfActive(false);
			this.jobAdvertisementDao.save(job);
		}
		else {
			job.setStatusOfActive(true);
			this.jobAdvertisementDao.save(job);
			
		}
		
		return new SuccessResult(); 
	}


	@Override
	public  DataResult<List<JobAdvertisement>> getAllSortedBySalary(boolean sortType) {
		
		if(sortType==true) {
			
			Sort sort = Sort.by(Sort.Direction.DESC,"minSalary");
			return new SuccessDataResult<List<JobAdvertisement>>(this.jobAdvertisementDao.findAll(sort));
		}
		else {
			
			Sort sort = Sort.by(Sort.Direction.ASC,"maxSalary");
			return new SuccessDataResult<List<JobAdvertisement>>(this.jobAdvertisementDao.findAll(sort));
		}
		
		
	}


	
	

}
