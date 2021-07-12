package project.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import project.hrms.business.abstracts.EducationService;
import project.hrms.core.utilities.results.DataResult;
import project.hrms.core.utilities.results.Result;
import project.hrms.entities.concretes.Education;
import project.hrms.entities.dtos.EducationDto;


@RestController
@RequestMapping("/api/educations")
@CrossOrigin
public class EducationsController {

	private EducationService educationService;
	
	@Autowired
	public EducationsController(EducationService educationService) {
		super();
		this.educationService = educationService;
	}

	
	@PostMapping("/add")
	public Result add(@RequestBody EducationDto educationDto) {
		
		
		return this.educationService.add(educationDto);
		
	}
	
	
	@GetMapping("/getAllByCvId")
	public DataResult<List<Education>> getAllByCvId(@RequestParam int cvId) {
		
		return this.educationService.getAllByCvId(cvId);
	}
}
