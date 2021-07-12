package project.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import project.hrms.business.abstracts.FavoriteService;
import project.hrms.core.utilities.results.DataResult;
import project.hrms.core.utilities.results.Result;
import project.hrms.entities.concretes.Favorite;
import project.hrms.entities.dtos.FavoriteDto;

@RestController
@RequestMapping("/api/favorites")
@CrossOrigin
public class FavoritesController {

	
	private FavoriteService favoriteService;

	@Autowired
	public FavoritesController(FavoriteService favoriteService) {
		super();
		this.favoriteService = favoriteService;
	}
	
	
	@PostMapping("/add")
	public Result add(@RequestBody FavoriteDto favoriteDto) {
		
		return this.favoriteService.add(favoriteDto);
	}
	
	@GetMapping("/getAllByCandidateId")
	public DataResult<List<Favorite>> getAllByCandidateId(@RequestParam int candidateId){
		
		return this.favoriteService.findByCandidateId(candidateId);
	}
	
	@DeleteMapping("/delete")
	public Result deleteByIdAndCandidateId(@RequestParam("favoriteId") int favoriteId,@RequestParam("candidateId") int candidateId)  {
		return this.favoriteService.deleteByIdAndCandidateId(favoriteId, candidateId);
		
		
	}
}
