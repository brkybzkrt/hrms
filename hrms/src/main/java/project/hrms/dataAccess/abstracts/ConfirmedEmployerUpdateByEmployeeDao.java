package project.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import project.hrms.entities.concretes.ConfirmedEmployerUpdateByEmployee;

public interface ConfirmedEmployerUpdateByEmployeeDao extends JpaRepository<ConfirmedEmployerUpdateByEmployee, Integer> {

	ConfirmedEmployerUpdateByEmployee findByEmployerId(int employerId);
	
}
