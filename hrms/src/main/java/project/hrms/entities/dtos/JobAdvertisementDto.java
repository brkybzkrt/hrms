package project.hrms.entities.dtos;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class JobAdvertisementDto {

	private String employerName;
	private String jobDescription;
	private int countOfPosition;
	private LocalDate releaseDate;
	
	private LocalDate deadlineDate;
	
	@JsonIgnore
	private boolean statusOfActive;
	
	
	
	
	
	
	
	
}
