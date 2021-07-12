package project.hrms.business.abstracts;

import java.util.List;

import project.hrms.core.utilities.results.DataResult;
import project.hrms.core.utilities.results.Result;
import project.hrms.entities.concretes.Favorite;
import project.hrms.entities.dtos.FavoriteDto;

public interface FavoriteService {

	
	
	Result add(FavoriteDto favoriteDto);
	
	Result deleteByIdAndCandidateId(int favoriteId,int candidateId);
	
	DataResult<List<Favorite>> findByCandidateId(int candidateId);
}
