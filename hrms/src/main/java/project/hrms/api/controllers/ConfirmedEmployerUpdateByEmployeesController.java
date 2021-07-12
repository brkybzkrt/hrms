package project.hrms.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import project.hrms.business.abstracts.ConfirmedEmployerUpdateByEmployeeService;
import project.hrms.core.utilities.results.Result;

@RestController
@CrossOrigin
@RequestMapping("/api/confirmedEmployerUpdateByEmployeesController")
public class ConfirmedEmployerUpdateByEmployeesController {

	private ConfirmedEmployerUpdateByEmployeeService confirmedEmployerUpdateByEmployeeService;

	@Autowired
	public ConfirmedEmployerUpdateByEmployeesController(
			ConfirmedEmployerUpdateByEmployeeService confirmedEmployerUpdateByEmployeeService) {
		super();
		this.confirmedEmployerUpdateByEmployeeService = confirmedEmployerUpdateByEmployeeService;
	}
	
	
	
	
	@PutMapping("/confirmUpdate")
	public  Result confirmToEmployerUpdate(@RequestParam("employerId") int employerId,@RequestParam("employeeId") int employeeId) {
		
		return this.confirmedEmployerUpdateByEmployeeService.confirmToEmployerUpdate(employerId, employeeId);
	}
}
