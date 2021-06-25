package project.hrms.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import project.hrms.business.abstracts.ConfirmedEmployerByEmployeeService;
import project.hrms.core.utilities.results.Result;

@RestController
@RequestMapping("/api/confirmedEmployerByEmployees")
public class ConfirmedEmployerByEmployeesController {

	
	private ConfirmedEmployerByEmployeeService confirmedEmployerByEmployeeService;

	@Autowired
	public ConfirmedEmployerByEmployeesController(
			ConfirmedEmployerByEmployeeService confirmedEmployerByEmployeeService) {
		super();
		this.confirmedEmployerByEmployeeService = confirmedEmployerByEmployeeService;
	}
	
	
	
	@PutMapping("/confirmEmployee")
	public Result confirmEmployee(@RequestParam("employeeId") int employeeId,@RequestParam("employerId") int employerId) {
		
		return this.confirmedEmployerByEmployeeService.confirmEmployer(employeeId, employerId);
	}
	
}
