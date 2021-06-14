package project.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import project.hrms.business.abstracts.JobTypeService;
import project.hrms.core.utilities.results.DataResult;
import project.hrms.entities.concretes.JobType;

@RestController
@RequestMapping("/api/jobTypes/")
public class JobTypesController {

	
	private JobTypeService jobTypeService;
	
	@Autowired
	public JobTypesController(JobTypeService jobTypeService) {
		super();
		this.jobTypeService = jobTypeService;
	}





	@GetMapping("/getAll")
	public DataResult<List<JobType>> getAll(){
		
		return this.jobTypeService.getAll();
		
	}
}
