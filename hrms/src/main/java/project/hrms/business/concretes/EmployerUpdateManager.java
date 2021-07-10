package project.hrms.business.concretes;

import java.util.List;

import org.springframework.stereotype.Service;

import project.hrms.business.abstracts.EmployerUpdateService;
import project.hrms.core.utilities.results.DataResult;
import project.hrms.entities.concretes.EmployerUpdate;

@Service
public class EmployerUpdateManager implements EmployerUpdateService{

	@Override
	public DataResult<List<EmployerUpdate>> getAllActiveOfStatus(boolean status) {
		// TODO Auto-generated method stub
		return null;
	}

	
	
	
	

	
}
