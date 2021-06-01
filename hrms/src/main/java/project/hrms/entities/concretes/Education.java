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
import javax.validation.constraints.NotBlank;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name="educations")
public class Education {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	
	@NotBlank(message = "Boş geçilemeyecek alan")
	@Column(name="school_name")
	private String schollName;
	
	
	@Column(name="started_year")
	private LocalDate startedYear;
	
	@Column(name="finished_year")
	private LocalDate finishedYear;
	
	
	
	@ManyToOne()
	@JoinColumn(name="cv_id")
	private Cv cv;
	
	
}
