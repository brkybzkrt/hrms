package project.hrms.dataAccess.abstracts;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import project.hrms.entities.concretes.JobAdvertisement;
import project.hrms.entities.dtos.JobAdvertisementDto;

public interface JobAdvertisementDao extends JpaRepository<JobAdvertisement, Integer> {

	
	JobAdvertisement getById(int id);
	
	List<JobAdvertisement> getByEmployer_CompanyName(String employerName);
	
	
	List<JobAdvertisement> getByStatusOfActive(boolean status);
	
	@Query("Select new project.hrms.entities.dtos.JobAdvertisementDto(ja.employer.companyName ,ja.jobDescription,ja.countOfPosition,ja.releaseDate,ja.deadlineDate,ja.statusOfActive) From JobAdvertisement ja Where ja.statusOfActive=true ")
	List<JobAdvertisementDto> getAllStatusOfActive();
}
