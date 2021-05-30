package project.hrms.core.converter;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;


import project.hrms.entities.concretes.JobAdvertisement;
import project.hrms.entities.dtos.JobAdvertisementDto;

@Component
public class JobAdvertisementConverter {

	
	public JobAdvertisementDto entityToDto(JobAdvertisement jobAdvertisement) {
		
		
		JobAdvertisementDto advertisementDto = new JobAdvertisementDto(); 
		
		advertisementDto.setEmployerName(jobAdvertisement.getEmployer().getCompanyName());
		advertisementDto.setJobDescription(jobAdvertisement.getJobDescription());
		advertisementDto.setCountOfPosition(jobAdvertisement.getCountOfPosition());
		advertisementDto.setReleaseDate(jobAdvertisement.getReleaseDate());
		advertisementDto.setDeadlineDate(jobAdvertisement.getDeadlineDate());
		advertisementDto.setStatusOfActive(jobAdvertisement.isStatusOfActive());
		
		return advertisementDto;
		
	} 
	
	
	
	public List<JobAdvertisementDto>  entitiesToDto(List<JobAdvertisement> jobAdvertisements){
		
		return jobAdvertisements.stream().map(x-> entityToDto(x)).collect(Collectors.toList());
		
	}
	
	
	
	
	

}
