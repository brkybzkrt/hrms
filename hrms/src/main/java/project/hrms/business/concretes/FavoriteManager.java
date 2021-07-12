package project.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import project.hrms.business.abstracts.FavoriteService;
import project.hrms.core.utilities.dtoConverter.DtoConverterService;
import project.hrms.core.utilities.results.DataResult;
import project.hrms.core.utilities.results.ErrorResult;
import project.hrms.core.utilities.results.Result;
import project.hrms.core.utilities.results.SuccessDataResult;
import project.hrms.core.utilities.results.SuccessResult;
import project.hrms.dataAccess.abstracts.FavoriteDao;
import project.hrms.entities.concretes.Favorite;
import project.hrms.entities.dtos.FavoriteDto;

@Service
public class FavoriteManager implements FavoriteService{

	private FavoriteDao favoriteDao;
	private DtoConverterService dtoConverterService; 
	
	@Autowired
	public FavoriteManager(FavoriteDao favoriteDao,DtoConverterService dtoConverterService) {
		super();
		this.favoriteDao = favoriteDao;
		this.dtoConverterService=dtoConverterService;
	}

	@Override
	public Result add(FavoriteDto favoriteDto) {
		
		
		
		if(this.favoriteDao.existsByJobAdvertisementId(favoriteDto.getJobAdvertisementId())) {
			
			return new ErrorResult("Bu zaten favoride mevcut");
		}
		else {
			Favorite fav= (Favorite) this.dtoConverterService.dtoClassConverter(favoriteDto, Favorite.class);
			 this.favoriteDao.save(fav);
			 
			 return new SuccessResult("İş ilanı favorilere eklendi");
		}
		
	}

	@Override
	public DataResult<List<Favorite>> findByCandidateId(int candidateId) {
		
		return new SuccessDataResult<List<Favorite>>(this.favoriteDao.getByCandidate_Id(candidateId));
	}

	@Override
	public Result deleteByIdAndCandidateId(int favoriteId,int candidateId) {
	 Favorite deletedFavorite=	this.favoriteDao.getOneByIdAndCandidateId(favoriteId, candidateId);
		
		this.favoriteDao.delete(deletedFavorite);
	
		
		return new SuccessResult("başarıyla silindi");
	}

}
