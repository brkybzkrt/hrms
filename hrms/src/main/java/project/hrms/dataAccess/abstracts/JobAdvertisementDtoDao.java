package project.hrms.dataAccess.abstracts;



import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import project.hrms.entities.concretes.Employer;
import project.hrms.entities.concretes.JobAdvertisement;
import project.hrms.entities.dtos.JobAdvertisementDto;

@Mapper
public interface JobAdvertisementDtoDao {

	@Mappings ({
	@Mapping(source="employer.companyName",target="employerName"),
	@Mapping(source="jobAdvertisement.jobDescription",target="jobDescription"),
	@Mapping(source="jobAdvertisement.countOfPosition",target="countOfPosition"),
	@Mapping(source="jobAdvertisement.releaseDate",target="releaseDate"),
	@Mapping(source="jobAdvertisement.deadlineDate",target="deadlineDate")})
	
	
	JobAdvertisementDto from(Employer employer,JobAdvertisement jobAdvertisement);
	
	
}
