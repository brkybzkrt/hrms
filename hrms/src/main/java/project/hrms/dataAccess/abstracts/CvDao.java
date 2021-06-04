package project.hrms.dataAccess.abstracts;



import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;


import project.hrms.entities.concretes.Cv;


public interface CvDao extends JpaRepository<Cv, Integer>{

	
	
	List<Cv> getByCandidate_Id(int candidateId);
	
}
