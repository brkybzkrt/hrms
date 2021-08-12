package project.hrms.business.concretes;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import project.hrms.business.abstracts.EducationService;
import project.hrms.core.utilities.dtoConverter.DtoConverterService;
import project.hrms.core.utilities.results.DataResult;
import project.hrms.core.utilities.results.Result;
import project.hrms.core.utilities.results.SuccessDataResult;
import project.hrms.core.utilities.results.SuccessResult;
import project.hrms.dataAccess.abstracts.CvDao;
import project.hrms.dataAccess.abstracts.EducationDao;
import project.hrms.entities.concretes.Cv;
import project.hrms.entities.concretes.Education;
import project.hrms.entities.dtos.EducationDto;

@Service
public class EducationManager implements EducationService{

	
	private EducationDao educationDao;
	private DtoConverterService dtoConverterService; 
	private CvDao cvDao;
	
	@Autowired
	public EducationManager(EducationDao educationDao,DtoConverterService dtoConverterService,CvDao cvDao) {
		super();
		this.educationDao = educationDao;
		this.cvDao=cvDao;
		this.dtoConverterService=dtoConverterService;
	}

	@Override
	public Result add(EducationDto educationDto) {
		
	Cv updateCv=this.cvDao.getOne(educationDto.getCvId());
		
		this.educationDao.save((Education) this.dtoConverterService.dtoClassConverter(educationDto, Education.class));
		updateCv.setLastUpdatedDate(LocalDate.now());
		this.cvDao.save(updateCv);
		return new SuccessResult("Eğitim başarıyla eklendi");
	}

	@Override
	public DataResult<List<Education>> getAllByCvId(int cvId) {
		return new SuccessDataResult<List<Education>>(this.educationDao.findAllByCvId(cvId), "Eğitimler getirildi");
	}

	@Override
	public Result update(int id, EducationDto educationDto) {
		Education updateEducation= this.educationDao.getOne(id);
		
		Education newEducation= (Education) this.dtoConverterService.dtoClassConverter( educationDto, Education.class);
		updateEducation.setSchollName(newEducation.getSchollName());
		updateEducation.setStartedYear(newEducation.getStartedYear());
		updateEducation.setFinishedYear(newEducation.getFinishedYear());
		updateEducation.setCv(newEducation.getCv());
	
		this.educationDao.save(updateEducation);
		
		return new SuccessResult("Eğitim başarıyla güncellendi");
	
	}

	@Override
	public DataResult<EducationDto> getById(int educationId) {
		Education edu = this.educationDao.getOne(educationId);
		
		return new SuccessDataResult<EducationDto>((EducationDto) this.dtoConverterService.dtoClassConverter(edu, EducationDto.class)); 
		
	}

}
