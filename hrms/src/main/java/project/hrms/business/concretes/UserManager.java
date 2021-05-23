package project.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import project.hrms.business.abstracts.UserService;
import project.hrms.dataAccess.abstracts.UserDao;
import project.hrms.entities.concretes.User;

@Service
public class UserManager implements UserService{

	private UserDao userDao;
	
	@Autowired
	public UserManager(UserDao userDao) {
		super();
		this.userDao = userDao;
	}


	@Override
	public List<User> getAll() {
		return userDao.findAll();
	}

}
