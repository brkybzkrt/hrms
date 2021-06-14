package project.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import project.hrms.entities.concretes.JobAdvertisementActivationByEmployee;

public interface JobAdvertisementActivationByEmployeeDao extends JpaRepository<JobAdvertisementActivationByEmployee, Integer>{
	
	
	
	
	JobAdvertisementActivationByEmployee  getByJobAdvertisement_Id(int id);
	
	

}
