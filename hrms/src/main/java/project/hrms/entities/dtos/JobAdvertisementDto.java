package project.hrms.entities.dtos;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonIgnore;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
;


@Data
@AllArgsConstructor
@NoArgsConstructor

public class JobAdvertisementDto {

	private String employerCompanyName;
	private String jobDescription;
	private int countOfPosition;
	private LocalDate releaseDate;
	private String jobPositionName;
	private String cityName;
	private LocalDate deadlineDate;
	private String jobTypeName;
	private String workingTimeName;
	
	@JsonIgnore
	private boolean jobAdvertisementActivationByEmployeeIsConfirmed;
	
	@JsonIgnore
	private boolean statusOfActive;
	
	
	
	
	
	
	
	
}
