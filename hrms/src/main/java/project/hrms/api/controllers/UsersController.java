package project.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import project.hrms.business.abstracts.UserService;
import project.hrms.entities.concretes.User;

@RestController
@RequestMapping("/users/api")
public class UsersController {

	
	private UserService userService;

	@Autowired
	public UsersController(UserService userService) {
		super();
		this.userService = userService;
	}
	
	
	
	@GetMapping("/getAll")
	List<User> getAll(){
		
		
		return userService.getAll();
	}
}
