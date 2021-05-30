package project.hrms.dataAccess.abstracts;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import project.hrms.entities.concretes.JobAdvertisement;

public interface JobAdvertisementDao extends JpaRepository<JobAdvertisement, Integer> {

	
	JobAdvertisement getById(int id);
	
	List<JobAdvertisement> getByEmployer_CompanyName(String employerName);
	
	
	List<JobAdvertisement> getByStatusOfActive(boolean status);
	
}
