package project.hrms.business.concretes;

import java.util.List;

import org.springframework.stereotype.Service;

import project.hrms.business.abstracts.EducationService;
import project.hrms.core.utilities.results.DataResult;
import project.hrms.core.utilities.results.Result;
import project.hrms.core.utilities.results.SuccessDataResult;
import project.hrms.core.utilities.results.SuccessResult;
import project.hrms.dataAccess.abstracts.EducationDao;
import project.hrms.entities.concretes.Education;

@Service
public class EducationManager implements EducationService{

	
	private EducationDao educationDao;
	public EducationManager(EducationDao educationDao) {
		super();
		this.educationDao = educationDao;
	}

	@Override
	public Result add(Education education) {
		this.educationDao.save(education);
		return new SuccessResult("Eğitim başarıyla eklendi");
	}

	@Override
	public DataResult<List<Education>> getAll() {
		return new SuccessDataResult<List<Education>>(this.educationDao.findAll(), "Eğitimler getirildi");
	}

}
