package project.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import project.hrms.business.abstracts.LanguageService;
import project.hrms.core.utilities.results.DataResult;
import project.hrms.core.utilities.results.Result;

import project.hrms.entities.dtos.LanguageDto;

@RestController
@RequestMapping("/api/languages")
@CrossOrigin
public class LanguagesController {

	private LanguageService languageService;

	@Autowired
	public LanguagesController(LanguageService languageService) {
		super();
		this.languageService = languageService;
	}
	
	@PostMapping("/add")
	public Result add(@RequestBody LanguageDto languageDto) {
		
		return this.languageService.add(languageDto);
	}
	
	
	
	@GetMapping("/getAll")
	public DataResult<List<LanguageDto>> getByCvId(int cvId) {
		
		return this.languageService.getByCvId(cvId);
	}
	
	@GetMapping("/getById")
	public DataResult<LanguageDto> getById(int id){
		return this.languageService.getById(id);
	}
	
	@PutMapping("/updateById")
	public Result updateById(@RequestParam int id,@RequestBody LanguageDto languageDto){
		return this.languageService.update(id, languageDto);
		
	}
}
