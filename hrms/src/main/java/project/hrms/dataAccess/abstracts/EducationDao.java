package project.hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import project.hrms.entities.concretes.Education;

public interface EducationDao extends JpaRepository<Education, Integer>{

	
	List<Education> findAllByCvId(int cvId);
	
}
