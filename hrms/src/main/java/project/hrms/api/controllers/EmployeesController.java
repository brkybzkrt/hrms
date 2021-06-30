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

import project.hrms.business.abstracts.EmployeeService;
import project.hrms.core.utilities.results.DataResult;
import project.hrms.core.utilities.results.Result;
import project.hrms.entities.concretes.Employee;

@RestController
@RequestMapping("/api/employees")
@CrossOrigin
public class EmployeesController {

	private EmployeeService employeeService;

	@Autowired
	public EmployeesController(EmployeeService employeeService) {
		super();
		this.employeeService = employeeService;
	}
	
	
	@GetMapping("/getAll")
	public DataResult<List<Employee>> getAll() {
		
		
		return this.employeeService.getAll();
	}
	
	@PostMapping("/add")
	public Result add(@RequestBody Employee employee) {
		
		
		return this.employeeService.add(employee);
	}
	
	@GetMapping("/getByEmployeeId")
	public DataResult<Employee> getByEmployeeId(@RequestParam  int employeeId) {
		
		return this.employeeService.getByEmployeeId(employeeId);
		
	}
	
	@PutMapping("/updateByEmployeeId")
	public Result update(@RequestParam int employeeId,@RequestBody Employee employee) {
		
		return this.employeeService.update(employeeId, employee);
	}
	
}
