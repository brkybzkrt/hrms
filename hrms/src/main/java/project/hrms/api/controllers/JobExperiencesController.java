package project.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import project.hrms.business.abstracts.JobExperienceService;
import project.hrms.core.utilities.results.DataResult;
import project.hrms.core.utilities.results.Result;
import project.hrms.entities.concretes.JobExperience;
import project.hrms.entities.dtos.JobExperienceDto;



@RestController
@RequestMapping("/api/jobExperiences")
@CrossOrigin
public class JobExperiencesController {

private JobExperienceService jobExperienceService;
	
	@Autowired
	public JobExperiencesController(JobExperienceService jobExperienceService) {
	super();
	this.jobExperienceService = jobExperienceService;
}




	@PostMapping("/add")
	public Result add(@RequestBody JobExperienceDto jobExperienceDto) {
		
		return this.jobExperienceService.add(jobExperienceDto);
		
	}
	
	
	
	
	@GetMapping("/getAll")
public DataResult<List<JobExperience>> getByCvId(int cvId) {
		
		return this.jobExperienceService.getByCvId( cvId);
	}
}
