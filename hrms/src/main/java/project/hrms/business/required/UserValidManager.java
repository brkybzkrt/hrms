package project.hrms.business.required;







import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import project.hrms.core.utilities.fakeMernis.FakeMernis;
import project.hrms.entities.concretes.Candidate;




@Service("fakemernis")
public class UserValidManager implements UserValidService {

	
	
	private FakeMernis fakeMernis; 
	
	
	@Autowired
	public UserValidManager(FakeMernis fakeMernis) {
		super();
		this.fakeMernis = fakeMernis;
	}



	@Override
	public boolean personIsValid(Candidate candidate) {
		
		return this.fakeMernis.isRealPerson(candidate);
		
	}
	





}



	
	
	

