package project.hrms.business.concretes;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import project.hrms.business.abstracts.CvService;
import project.hrms.core.utilities.cloudinary.CloudinaryService;
import project.hrms.core.utilities.results.DataResult;
import project.hrms.core.utilities.results.Result;
import project.hrms.core.utilities.results.SuccessDataResult;
import project.hrms.core.utilities.results.SuccessResult;
import project.hrms.dataAccess.abstracts.CvDao;
import project.hrms.entities.concretes.Cv;

@Service
public class CvManager implements CvService {

	private CvDao cvDao;
	private CloudinaryService cloudinaryService;
	
	@Autowired
	public CvManager(CvDao cvDao,CloudinaryService cloudinaryService) {
		super();
		this.cvDao = cvDao;
		this.cloudinaryService=cloudinaryService;
	}

	@Override
	public Result add(Cv cv) {
		this.cvDao.save(cv);
		
		return new SuccessResult("cv başarıyla eklendi");
	}

	@Override
	public DataResult<List<Cv>> getAll() {
		
		return new SuccessDataResult<List<Cv>>( this.cvDao.findAll(),"cvler getirildi");
	}

	@Override
	public Result addImage(MultipartFile multipartFile, int cvId) {
		Map<String, String> add= (Map<String, String>) this.cloudinaryService.add(multipartFile).getData();
		
		String imageAddress=add.get("url");
		
		Cv cv= this.cvDao.getOne(cvId);
		cv.setPhoto(imageAddress);
		
		this.cvDao.save(cv);
		
		return new SuccessResult("Resim başarıyla eklendi");
		
	}

	
	
	
}
