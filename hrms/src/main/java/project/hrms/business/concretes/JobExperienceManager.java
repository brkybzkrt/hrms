package project.hrms.business.concretes;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import project.hrms.business.abstracts.JobExperienceService;
import project.hrms.core.utilities.dtoConverter.DtoConverterService;
import project.hrms.core.utilities.results.DataResult;
import project.hrms.core.utilities.results.Result;
import project.hrms.core.utilities.results.SuccessDataResult;
import project.hrms.core.utilities.results.SuccessResult;
import project.hrms.dataAccess.abstracts.CvDao;
import project.hrms.dataAccess.abstracts.JobExperienceDao;
import project.hrms.entities.concretes.Cv;
import project.hrms.entities.concretes.JobExperience;
import project.hrms.entities.dtos.JobExperienceDto;

@Service
public class JobExperienceManager implements JobExperienceService {

	
	private JobExperienceDao jobExperienceDao;  
	private DtoConverterService dtoConverterService; 
	private CvDao cvDao;
	
	
	@Autowired
	public JobExperienceManager(JobExperienceDao jobExperienceDao,DtoConverterService dtoConverterService,CvDao cvDao) {
		super();
		this.jobExperienceDao = jobExperienceDao;
		this.cvDao=cvDao;
		this.dtoConverterService=dtoConverterService;
	}

	@Override
	public Result add(JobExperienceDto jobExperienceDto) {
		Cv updatedCv=	this.cvDao.getOne(jobExperienceDto.getCvId());
		
		JobExperience jobExperience=(JobExperience) this.dtoConverterService.dtoClassConverter(jobExperienceDto, JobExperience.class);
		jobExperience.setCreatedDate(LocalDate.now());
		this.jobExperienceDao.save(jobExperience);
		
		
		updatedCv.setLastUpdatedDate(LocalDate.now());
		this.cvDao.save(updatedCv);
		return new SuccessResult("İş deneyimi başarıyla eklendi."); 
	}

	@Override
	public DataResult<List<JobExperience>>  getByCvId(int cvId) {
		return new SuccessDataResult<List<JobExperience>>(this.jobExperienceDao.findAllByCvId(cvId),"İş deneyimleri getirildi");
	}

	@Override
	public Result update(int id, JobExperienceDto jobExperienceDto) {
		JobExperience updated= this.jobExperienceDao.getOne(id);
		
		JobExperience newJobExperience= (JobExperience) this.dtoConverterService.dtoClassConverter(jobExperienceDto, JobExperience.class);
		
		updated.setFinishedYear(newJobExperience.getFinishedYear());
		updated.setJobPlaceName(newJobExperience.getJobPlaceName());
		updated.setJobPosition(newJobExperience.getJobPosition());
		updated.setStartedYear(newJobExperience.getStartedYear());
		updated.setCv(newJobExperience.getCv());
		
		this.jobExperienceDao.save(updated);
		
		return new SuccessResult("İş deneyimi başarıyla güncellendi");
	}

	@Override
	public DataResult<JobExperienceDto> getById(int jEId) {
		JobExperience jobExp= this.jobExperienceDao.getOne(jEId);
		
		return new SuccessDataResult<JobExperienceDto>((JobExperienceDto) this.dtoConverterService.dtoClassConverter(jobExp, JobExperienceDto.class),"İş deneyimi getirildi.");
	}

}
