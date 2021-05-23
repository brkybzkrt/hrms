package project.hrms.business.abstracts;

import java.util.List;

import project.hrms.entities.concretes.User;

public interface UserService {

	List<User> getAll();
}
