package project.hrms.dataAccess.abstracts;


import java.util.List;


import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import project.hrms.entities.concretes.JobAdvertisement;


public interface JobAdvertisementDao extends JpaRepository<JobAdvertisement, Integer> {

	
	JobAdvertisement getById(int id);
	
	List<JobAdvertisement> findAllByJobAdvertisementActivationByEmployee_IsConfirmedAndStatusOfActiveAndCityNameContaining(Pageable pageable,boolean confirmStatus,boolean isActiveStatus,String cityName);
	
	List<JobAdvertisement> findAllByJobAdvertisementActivationByEmployee_IsConfirmedAndStatusOfActiveAndJobPositionNameContaining(Pageable pageable,boolean confirmStatus,boolean isActiveStatus,String jobPositionName);
	
	List<JobAdvertisement> findAllByJobAdvertisementActivationByEmployee_IsConfirmedAndStatusOfActiveAndJobPositionNameContainingAndCityNameContaining
	(Pageable pageable,boolean confirmStatus,boolean isActiveStatus,String jobPositionName,String cityname);
	
	List<JobAdvertisement> findAllByJobAdvertisementActivationByEmployee_IsConfirmedAndStatusOfActive(Pageable pageable,boolean confirmStatus,boolean isActiveStatus);
	
	List<JobAdvertisement> getByEmployer_CompanyName(String employerName);
	
	List<JobAdvertisement> getByStatusOfActiveAndEmployer_CompanyName(boolean status,String employerName);
	
	List<JobAdvertisement> getByJobAdvertisementActivationByEmployee_IsConfirmedAndStatusOfActive(boolean confirmStatus,boolean isActiveStatus);
	
	List<JobAdvertisement> getByStatusOfActive(boolean status);
	
	
	
}
