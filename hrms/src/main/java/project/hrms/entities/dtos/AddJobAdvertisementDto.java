package project.hrms.entities.dtos;

import java.time.LocalDate;



import com.fasterxml.jackson.annotation.JsonIgnore;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddJobAdvertisementDto {


	@JsonIgnore
	private int id;
	private int employerId;
	private int jobPositionId;
	private int minSalary;
	private int maxSalary;
	private int cityId;
	private int jobTypeId;
	private int countOfPosition;
	private int workingTimeId;
	
	private LocalDate deadlineDate;
	
	@JsonIgnore
	private boolean statusOfActive;
	private LocalDate releaseDate;
	private String jobDescription;
	
	
	
}
