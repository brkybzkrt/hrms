package project.hrms.business.abstracts;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import project.hrms.core.utilities.results.DataResult;
import project.hrms.core.utilities.results.Result;
import project.hrms.entities.concretes.Cv;
import project.hrms.entities.dtos.CvDto;

public interface CvService {

	
	Result add(Cv cv);
	Result update(int candidateId,CvDto cvDto);
	DataResult<List<CvDto>> getAll();
	
	
	
	DataResult<List<Cv>> getByCandidate_Id(int candidateId);
	
	
	Result addImage(MultipartFile multipartFile, int cvId);
	
	DataResult<CvDto> getCvByCandidate(int candidateId);


	boolean existsByCandidateId(int candidateId);
}
