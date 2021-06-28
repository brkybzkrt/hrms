package project.hrms.entities.dtos;



import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FavoriteDto {

	@JsonIgnore
	private int id;
	
	private int candidateId;
	
	private int jobAdvertisementId;
}
