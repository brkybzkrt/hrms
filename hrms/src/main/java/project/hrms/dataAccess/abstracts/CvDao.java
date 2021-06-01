package project.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import project.hrms.entities.concretes.Cv;

public interface CvDao extends JpaRepository<Cv, Integer>{

	
	
}
