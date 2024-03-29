package project.hrms.api.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;


import project.hrms.business.abstracts.EmployerService;
import project.hrms.core.utilities.results.DataResult;
import project.hrms.core.utilities.results.ErrorDataResult;
import project.hrms.core.utilities.results.Result;
import project.hrms.entities.concretes.Employer;
import project.hrms.entities.concretes.EmployerUpdate;

@CrossOrigin
@RestController
@RequestMapping("/api/employers")
public class EmployersController {

	
	private EmployerService employerService;

	@Autowired
	public EmployersController(EmployerService employerService) {
		super();
		this.employerService = employerService;
	} 
	
	
	
	
	@GetMapping("/getall")
	public DataResult<List<Employer>>  getAll(){
		
		return this.employerService.getAll();
		
	}
	
	@PostMapping("/add")
	public ResponseEntity<?> add(@Valid @RequestBody Employer employer){
		
		return ResponseEntity.ok( this.employerService.add(employer));
	}
	
	
	@PutMapping("/updateEmployer")
	public ResponseEntity<?> update(@RequestParam int employerId,@RequestBody EmployerUpdate employerUpdate){
		return ResponseEntity.ok(this.employerService.update(employerId,employerUpdate));
		
	}
	
	@GetMapping("/getById")
	public ResponseEntity<?> getById(@RequestParam int id){
		
		return ResponseEntity.ok(this.employerService.getById(id));
	}
	
	
		@ExceptionHandler(MethodArgumentNotValidException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public ErrorDataResult<Object> handleValidationException(MethodArgumentNotValidException exceptions){
		
		Map<String,String> validateErrors= new HashMap<String,String>();
		for(FieldError fieldError:exceptions.getBindingResult().getFieldErrors()) {
			
			validateErrors.put(fieldError.getField(), fieldError.getDefaultMessage());
		}
		ErrorDataResult<Object> errors= new ErrorDataResult<Object>(validateErrors,"Doğrulama hataları");
		
		return errors;
	}
}
