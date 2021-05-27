package project.hrms.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import project.hrms.business.abstracts.ActivationCodeService;
import project.hrms.core.utilities.results.Result;
import project.hrms.entities.concretes.ActivationCode;

@RestController
@RequestMapping("/activationcodes/api")
public class ActivationCodesController {

	
	
	private ActivationCodeService  activationCodeService;

	@Autowired
	public ActivationCodesController(ActivationCodeService activationCodeService) {
		super();
		this.activationCodeService = activationCodeService;
	}
	
	
	
	
	@PutMapping("/{activationCode}")
	public Result verify(@PathVariable("activationCode") String activationCode,@RequestBody ActivationCode activationBody) {
		
		return this.activationCodeService.userVerify(activationCode);
	} 
}
