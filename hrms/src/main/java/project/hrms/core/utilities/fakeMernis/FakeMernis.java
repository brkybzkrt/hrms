package project.hrms.core.utilities.fakeMernis;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.stereotype.Service;

import project.hrms.entities.concretes.Candidate;

@Service
public class FakeMernis {

	
	
	public boolean isRealPerson(Candidate candidate) {
		
		boolean isReal=false;
		
		Pattern eslesme= Pattern.compile("[0-9]{11}");
		Matcher kontrol = eslesme.matcher(candidate.getNationalityId());
		
		if(candidate.getNationalityId().length()==11 && kontrol.matches()) {
			
			
			return isReal=true;
		}
		
		return isReal;
		
	}
}
