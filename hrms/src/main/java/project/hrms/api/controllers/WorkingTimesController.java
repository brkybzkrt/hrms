package project.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import project.hrms.business.abstracts.WorkingTimeService;
import project.hrms.core.utilities.results.DataResult;
import project.hrms.entities.concretes.WorkingTime;

@CrossOrigin
@RestController
@RequestMapping("/api/workingTimes/")
public class WorkingTimesController {

	
	private WorkingTimeService workingTimeService;

	@Autowired
	public WorkingTimesController(WorkingTimeService workingTimeService) {
		super();
		this.workingTimeService = workingTimeService;
	} 
	
	
	
	@GetMapping("/getAll")
	public DataResult<List<WorkingTime>> getAll(){
		
		return this.workingTimeService.getAll();
	}
}
