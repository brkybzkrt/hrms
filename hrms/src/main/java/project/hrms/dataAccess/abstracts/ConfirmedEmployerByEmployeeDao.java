package project.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import project.hrms.entities.concretes.ConfirmedEmployerByEmployee;

public interface ConfirmedEmployerByEmployeeDao extends JpaRepository<ConfirmedEmployerByEmployee, Integer>{

	
	ConfirmedEmployerByEmployee getByEmployer_Id(int employerId);
	
	
}
