package project.hrms.entities.dtos;





import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CvDto {

	@JsonIgnore
	private int id;
	private int candidateId;
	private String photo;
	private String githubLink;
	private String linkedinLink;
	private String description;
	private LocalDate createdDate;
	private LocalDate updatedDate;
	
	
	
}
