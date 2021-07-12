package project.hrms.entities.dtos;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProgrammingLanguageDto {

	@JsonIgnore
	private int id;
	private int cvId;
	private String programmingName;
	private LocalDate createdDate;
	
}
