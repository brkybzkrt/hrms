package project.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import project.hrms.entities.concretes.ActivationCode;

public interface ActivationCodeDao extends JpaRepository<ActivationCode, Integer>{

	
	boolean existsByActivationCode(String activationCode);
	ActivationCode getByActivationCode(String activationCode);
}
