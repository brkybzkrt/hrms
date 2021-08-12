package project.hrms.entities.dtos;

import java.time.LocalDate;



import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EducationDto {

	
	private int id;
	private int cvId;
	private String schollName;
	private LocalDate startedYear;
	private LocalDate finishedYear;
	
	
}
