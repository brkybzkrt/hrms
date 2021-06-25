package project.hrms.api.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import project.hrms.business.abstracts.CvService;
import project.hrms.core.utilities.results.DataResult;
import project.hrms.core.utilities.results.Result;
import project.hrms.entities.concretes.Cv;
import project.hrms.entities.dtos.CvDto;

@CrossOrigin
@RestController
@RequestMapping("/api/cvies")
public class CviesController {

	private CvService cvService;

	@Autowired
	public CviesController(CvService cvService) {
		super();
		this.cvService = cvService;
	}
	
	@PostMapping("/add")
	public Result add(@Valid @RequestBody Cv cv) {
		return this.cvService.add(cv);
		
	}
	
	@GetMapping("/getAll")
	
	public DataResult<List<CvDto>> getAll(){
		
		return this.cvService.getAll();
		
	}
	
	@PostMapping("/addImage")
	public Result addImage(@RequestBody MultipartFile multipartFile,@RequestParam int cvId) {
		
		return this.cvService.addImage(multipartFile, cvId);
		
		
	}
	
	@GetMapping("/getByCandidateId")
	public DataResult<List<CvDto>>  getByCandidateId(@RequestParam int candidateId){
		
		return this.cvService.getByCandidate_Id(candidateId);
		
	}
	
	
	@PutMapping("/updateCv")
	public Result update(@RequestParam int cvId,@RequestBody Cv cv) {
		
		return this.cvService.update(cvId, cv);
	}
	
}
