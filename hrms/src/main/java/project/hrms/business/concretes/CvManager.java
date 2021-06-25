package project.hrms.business.concretes;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import project.hrms.business.abstracts.CvService;
import project.hrms.core.utilities.cloudinary.CloudinaryService;
import project.hrms.core.utilities.dtoConverter.DtoConverterService;
import project.hrms.core.utilities.results.DataResult;
import project.hrms.core.utilities.results.ErrorResult;
import project.hrms.core.utilities.results.Result;
import project.hrms.core.utilities.results.SuccessDataResult;
import project.hrms.core.utilities.results.SuccessResult;
import project.hrms.dataAccess.abstracts.CvDao;
import project.hrms.entities.concretes.Cv;
import project.hrms.entities.dtos.CvDto;

@Service
public class CvManager implements CvService {

	private CvDao cvDao;
	private CloudinaryService cloudinaryService;
	private DtoConverterService dtoConverterService;
	
	@Autowired
	public CvManager(CvDao cvDao,CloudinaryService cloudinaryService,DtoConverterService dtoConverterService) {
		super();
		this.cvDao = cvDao;
		this.cloudinaryService=cloudinaryService;
		this.dtoConverterService=dtoConverterService;
	}

	@Override
	public Result add(Cv cv) {
		this.cvDao.save(cv);
		
		return new SuccessResult("cv başarıyla eklendi");
	}

	@Override
	public DataResult<List<CvDto>> getAll() {
		
		return new SuccessDataResult<List<CvDto>>(this.dtoConverterService.dtoConverter(this.cvDao.findAll(), CvDto.class)  ,"cvler getirildi");
	}

	@SuppressWarnings("unchecked")
	@Override
	public Result addImage(MultipartFile multipartFile, int cvId) {
		Map<String, String> add= (Map<String, String>) this.cloudinaryService.add(multipartFile).getData();
		
		String imageAddress=add.get("url");
		
		Cv cv= this.cvDao.getOne(cvId);
		cv.setPhoto(imageAddress);
		
		this.cvDao.save(cv);
		
		return new SuccessResult("Resim başarıyla eklendi");
		
	}

	@Override
	public DataResult<List<CvDto>> getByCandidate_Id(int candidateId) {
		return new SuccessDataResult<List<CvDto>>(this.dtoConverterService.dtoConverter(this.cvDao.getByCandidate_Id(candidateId), CvDto.class),"cv getirildi" );
	}

	@Override
	public Result update(int cvId, Cv cv) {
		if(this.cvDao.existsById(cvId)) {
			
			Cv updateCv=this.cvDao.getOne(cvId);
			
			updateCv.setDescription(cv.getDescription());
			updateCv.setGithubLink(cv.getGithubLink());
			updateCv.setLinkedinLink(cv.getLinkedinLink());
			
			updateCv.setEducations(cv.getEducations());
			updateCv.setJobExperiences(cv.getJobExperiences());
			updateCv.setLanguages(cv.getLanguages());
			updateCv.setProgrammingLanguages(cv.getProgrammingLanguages());
			
			updateCv.setLastUpdatedDate(LocalDate.now());
			
			this.cvDao.save(updateCv);
			return new SuccessResult("Cv başarıyla güncellendi");
		}
		
		else {
			
			return new ErrorResult("Cv bulunamadı");
			
		}
	}

	
	
	
}
