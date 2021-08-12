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

import project.hrms.business.abstracts.ProgrammingLanguageService;
import project.hrms.core.utilities.results.DataResult;
import project.hrms.core.utilities.results.Result;

import project.hrms.entities.concretes.ProgrammingLanguage;
import project.hrms.entities.dtos.ProgrammingLanguageDto;

@RestController
@RequestMapping("/api/programmingLanguages")
@CrossOrigin
public class ProgrammingLanguagesController {

	private ProgrammingLanguageService programmingLanguageService;
	
	@Autowired
	public ProgrammingLanguagesController(ProgrammingLanguageService programmingLanguageService) {
		super();
		this.programmingLanguageService = programmingLanguageService;
	}


	@PostMapping("/add")
	public Result add(@RequestBody ProgrammingLanguageDto programmingLanguageDto) {
		
		
		return this.programmingLanguageService.add(programmingLanguageDto);
		
	}
	
	
	@GetMapping("/getAll")
public DataResult<List<ProgrammingLanguage>> getByCvId(int cvId) {
		
		return this.programmingLanguageService.getByCvId( cvId);
	}
	
	
	@PutMapping("/update")
	public Result update(@RequestParam int id,@RequestBody ProgrammingLanguageDto programmingLanguageDto){
		
		return this.programmingLanguageService.update(id, programmingLanguageDto);
	}
	
	@GetMapping("/getById")
	public DataResult<ProgrammingLanguageDto> getById(int id) {
		return this.programmingLanguageService.getById(id);
	}
}
