package project.hrms.business.concretes;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import project.hrms.business.abstracts.ProgrammingLanguageService;
import project.hrms.core.utilities.dtoConverter.DtoConverterService;
import project.hrms.core.utilities.results.DataResult;
import project.hrms.core.utilities.results.Result;
import project.hrms.core.utilities.results.SuccessDataResult;
import project.hrms.core.utilities.results.SuccessResult;
import project.hrms.dataAccess.abstracts.CvDao;
import project.hrms.dataAccess.abstracts.ProgrammingLanguageDao;
import project.hrms.entities.concretes.Cv;
import project.hrms.entities.concretes.ProgrammingLanguage;
import project.hrms.entities.dtos.ProgrammingLanguageDto;

@Service
public class ProgrammingLanguageManager implements ProgrammingLanguageService{

	private ProgrammingLanguageDao programmingLanguageDao;
	private DtoConverterService dtoConverterService; 
	private CvDao cvDao;
	
	@Autowired
	public ProgrammingLanguageManager(ProgrammingLanguageDao programmingLanguageDao,DtoConverterService dtoConverterService,CvDao cvDao) {
		super();
		this.programmingLanguageDao = programmingLanguageDao;
		this.cvDao=cvDao;
		this.dtoConverterService=dtoConverterService;
	}

	@Override
	public Result add(ProgrammingLanguageDto programmingLanguageDto) {
	Cv updatedCv=this.cvDao.getOne(programmingLanguageDto.getCvId());
		
	ProgrammingLanguage updatedProgrammingLanguage=(ProgrammingLanguage) this.dtoConverterService.dtoClassConverter(programmingLanguageDto,ProgrammingLanguage.class );
	updatedProgrammingLanguage.setCreatedDate(LocalDate.now());	
	this.programmingLanguageDao.save(updatedProgrammingLanguage);
		
		updatedCv.setLastUpdatedDate(LocalDate.now());
		this.cvDao.save(updatedCv);
		return new SuccessResult("Programlama dili başarıyla eklendi");
	}

	@Override
	public DataResult<List<ProgrammingLanguage>>  getByCvId(int cvId) {
		return new SuccessDataResult<List<ProgrammingLanguage>>(this.programmingLanguageDao.findAllByCvId(cvId), "Programlama eğitimleri getirildi");
	}

	@Override
	public Result update(int id, ProgrammingLanguageDto programmingLanguageDto) {
	  ProgrammingLanguage updated=	this.programmingLanguageDao.getOne(id);
	  
	  ProgrammingLanguage newProgrammingLanguage=(ProgrammingLanguage) this.dtoConverterService.dtoClassConverter(programmingLanguageDto, ProgrammingLanguage.class);
	  
	  updated.setProgrammingName(newProgrammingLanguage.getProgrammingName());
	  
	  this.programmingLanguageDao.save(updated);
	  
	  return new SuccessResult("Teknoloji başarıyla güncellendi");
	}

	@Override
	public DataResult<ProgrammingLanguageDto> getById(int pLId) {
		ProgrammingLanguage programmingLan = this.programmingLanguageDao.getOne(pLId);
		return new SuccessDataResult<ProgrammingLanguageDto>((ProgrammingLanguageDto) this.dtoConverterService.dtoClassConverter(programmingLan, ProgrammingLanguageDto.class),"Program dili getirildi.");
	}

}
