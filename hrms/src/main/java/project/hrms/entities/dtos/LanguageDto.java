package project.hrms.entities.dtos;

import java.time.LocalDate;



import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LanguageDto {


	private int id;
	private int cvId;
	private String languageName;
	private String languageLevel;
	private LocalDate createdDate;
	
}
