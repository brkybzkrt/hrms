package project.hrms.api.controllers;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import project.hrms.business.abstracts.JobAdvertisementActivationByEmployeeService;
import project.hrms.core.utilities.results.Result;
import project.hrms.core.utilities.results.SuccessResult;
import project.hrms.entities.concretes.JobAdvertisementActivationByEmployee;

@RestController
@RequestMapping("/api/jobAdvertisementActivationByEmployees")
public class JobAdvertisementActivationByEmployeesController {

	
	private JobAdvertisementActivationByEmployeeService jobAdvertisementActivationByEmployeeService;

	public JobAdvertisementActivationByEmployeesController(
			JobAdvertisementActivationByEmployeeService jobAdvertisementActivationByEmployeeService) {
		super();
		this.jobAdvertisementActivationByEmployeeService = jobAdvertisementActivationByEmployeeService;
	}
	
	
	@PutMapping("/confirmToJobAdvertisement")
	public Result confirmToJobAdvertisement(@RequestParam("jobAdvertisementId") int jobAdvertisementId,@RequestParam("employeeId") int employeeId) {
		
		this.jobAdvertisementActivationByEmployeeService.confirmToJobAdvertisement(jobAdvertisementId, employeeId);
		return new SuccessResult("İş ilanı onaylandı");
		
	}
	
	
	
	@PostMapping("/add")
	Result add(@RequestBody JobAdvertisementActivationByEmployee jobAdvertisementActivationByEmployee) {
		return this.jobAdvertisementActivationByEmployeeService.add(jobAdvertisementActivationByEmployee);
		
		
	}
	
}
