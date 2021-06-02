package project.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import project.hrms.business.abstracts.EducationService;
import project.hrms.core.utilities.results.DataResult;
import project.hrms.core.utilities.results.Result;
import project.hrms.entities.concretes.Education;


@RestController
@RequestMapping("/api/educations")
public class EducationsController {

	private EducationService educationService;
	
	@Autowired
	public EducationsController(EducationService educationService) {
		super();
		this.educationService = educationService;
	}

	
	@PostMapping("/add")
	public Result add(@RequestBody Education education) {
		
		
		return this.educationService.add(education);
		
	}
	
	
	@GetMapping("/getAll")
	public DataResult<List<Education>> getAll() {
		
		return this.educationService.getAll();
	}
}
