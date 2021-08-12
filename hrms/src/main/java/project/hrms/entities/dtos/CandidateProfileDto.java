package project.hrms.entities.dtos;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CandidateProfileDto {
	
	
	private int id;
	private String lastName;
	private String firstName;
	private LocalDate dateOfBirth;
	private String email;
}
