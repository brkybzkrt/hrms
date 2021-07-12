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
		
		JobExperience jobExperience=(JobExperience) this.dtoConverterService.dtoClassConverter(updatedCv, JobExperience.class);
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
	public Result update(int id, JobExperience jobExperience) {
		JobExperience updated= this.jobExperienceDao.getOne(id);
		
		updated.setFinishedYear(jobExperience.getFinishedYear());
		updated.setJobPlaceName(jobExperience.getJobPlaceName());
		updated.setJobPosition(jobExperience.getJobPosition());
		updated.setStartedYear(jobExperience.getStartedYear());
		updated.setCv(jobExperience.getCv());
		
		this.jobExperienceDao.save(updated);
		
		return new SuccessResult("İş deneyimi başarıyla güncellendi");
	}

}
