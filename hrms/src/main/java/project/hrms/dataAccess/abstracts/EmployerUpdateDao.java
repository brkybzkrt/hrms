package project.hrms.dataAccess.abstracts;


import org.springframework.data.jpa.repository.JpaRepository;

import project.hrms.entities.concretes.EmployerUpdate;

public interface EmployerUpdateDao extends JpaRepository<EmployerUpdate, Integer>{

	EmployerUpdate findByEmployer_Id(int employerId);
	
}
