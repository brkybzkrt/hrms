package project.hrms.business.concretes;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import project.hrms.business.abstracts.LanguageService;
import project.hrms.core.utilities.dtoConverter.DtoConverterService;
import project.hrms.core.utilities.results.DataResult;
import project.hrms.core.utilities.results.Result;
import project.hrms.core.utilities.results.SuccessDataResult;
import project.hrms.core.utilities.results.SuccessResult;
import project.hrms.dataAccess.abstracts.CvDao;
import project.hrms.dataAccess.abstracts.LanguageDao;
import project.hrms.entities.concretes.Cv;
import project.hrms.entities.concretes.Language;
import project.hrms.entities.dtos.LanguageDto;

@Service
public class LanguageManager implements LanguageService{

	private LanguageDao languageDao;
	private DtoConverterService dtoConverterService; 
	private CvDao cvDao;
	
	@Autowired
	public LanguageManager(LanguageDao languageDao,DtoConverterService dtoConverterService,CvDao cvDao) {
		super();
		this.languageDao = languageDao;
		this.dtoConverterService=dtoConverterService;
		this.cvDao=cvDao;
	}

	@Override
	public Result add(LanguageDto languageDto) {
		Cv updateCv= this.cvDao.getOne(languageDto.getCvId());
		
		updateCv.setLastUpdatedDate(LocalDate.now());
		this.cvDao.save(updateCv);
		
		languageDto.setCreatedDate(LocalDate.now());
		this.languageDao.save((Language) this.dtoConverterService.dtoClassConverter(languageDto, Language.class));
		return new SuccessResult("Yabancı Dil başarıyla eklendi");
	}

	@Override
	public DataResult<List<LanguageDto>>  getByCvId(int cvId) {
		return new SuccessDataResult<List<LanguageDto>>(this.dtoConverterService.dtoConverter(this.languageDao.findAllByCvId(cvId), LanguageDto.class) , "Yabancı diller getirildi");
	}

	@Override
	public Result update(int id,LanguageDto newLanguage) {
		
		Language updatedLanguage=  this.languageDao.getOne(id);
		
		Language newLang= (Language) this.dtoConverterService.dtoClassConverter(newLanguage, Language.class);		
		
		updatedLanguage.setLanguageLevel(newLang.getLanguageLevel());
		updatedLanguage.setLanguageName(newLang.getLanguageName());
		updatedLanguage.setCreatedDate(updatedLanguage.getCreatedDate());
		updatedLanguage.setCv(updatedLanguage.getCv());
		
		
		this.languageDao.save(updatedLanguage);
		
		return new SuccessResult("güncelleme başarılı");
		
	}

	@Override
	public DataResult<LanguageDto> getById(int id) {
		return new SuccessDataResult<LanguageDto>((LanguageDto) this.dtoConverterService.dtoClassConverter(this.languageDao.getOne(id), LanguageDto.class)) ;
	}
	
	

}
