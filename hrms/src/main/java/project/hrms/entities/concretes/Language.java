package project.hrms.entities.concretes;



import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name="languages")
public class Language {

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	
	@Column(name="language_name")
	private String languageName;
	
	@Size(max = 1,min=1)
	@Column(name="language_level")
	private String languageLevel;
	
	
	@Column(name="created_date")
	private LocalDate createdDate;
	
	@ManyToOne(targetEntity = Cv.class)
	@JoinColumn(name="cv_id" ,referencedColumnName = "id")
	private Cv cv;
	
	
}
