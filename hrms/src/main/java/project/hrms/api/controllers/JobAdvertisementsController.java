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

import project.hrms.business.abstracts.JobAdvertisementService;

import project.hrms.core.utilities.results.DataResult;
import project.hrms.core.utilities.results.ErrorDataResult;
import project.hrms.core.utilities.results.Result;
import project.hrms.entities.concretes.JobAdvertisement;
import project.hrms.entities.dtos.AddJobAdvertisementDto;
import project.hrms.entities.dtos.JobAdvertisementDto;

@CrossOrigin
@RestController
@RequestMapping("/api/jobAdvertisements/")
public class JobAdvertisementsController {

	
	private JobAdvertisementService jobAdvertisementService;
	
	
	
	
	
	@Autowired
	public JobAdvertisementsController(JobAdvertisementService jobAdvertisementService) {
		super();
		this.jobAdvertisementService = jobAdvertisementService;
		
	} 
	
	@PostMapping("add")
 	public ResponseEntity<?> add(@Valid @RequestBody JobAdvertisement jobAdvertisement) {
 		
 		return ResponseEntity.ok( this.jobAdvertisementService.add(jobAdvertisement));
 	}
	
	
	@GetMapping("getAll")
	public DataResult<List<JobAdvertisementDto>> getAll(){
		
		return  this.jobAdvertisementService.getAll();
		
		
	}
	
	@GetMapping("getByEmployerName")
	public DataResult<List<JobAdvertisementDto>> getByEmployer_CompanyName(@RequestParam String companyName){
		return this.jobAdvertisementService.getByEmployer_CompanyName(companyName);
		
	}
	
	@PutMapping("changeStatus")
	public Result changeStatus(@RequestParam int id,boolean status) {
		
		return this.jobAdvertisementService.changeStatus(id,status);
		
	}
	
	@GetMapping("getByStatusOfActive")
	public DataResult<List<JobAdvertisementDto>> getByStatusOfActive(){
		
		return this.jobAdvertisementService.getByStatusOfActive();
	}
	
	
	
	
	@GetMapping("getAllSortedByReleaseDate")
	
	public DataResult<List<JobAdvertisementDto>> getAllSortByDate(boolean sortByDate){
		
		return this.jobAdvertisementService.getAllSortByDate(sortByDate);
		
	}
	
	@GetMapping("getByStatusOfActiveAndEmployer_CompanyName")
	public DataResult<List<JobAdvertisementDto>> getByStatusOfActiveAndEmployer_CompanyName(@RequestParam("employerName") String employerName){
		
		return this.jobAdvertisementService.getByStatusOfActiveAndEmployer_CompanyName(true, employerName);
		
		
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
