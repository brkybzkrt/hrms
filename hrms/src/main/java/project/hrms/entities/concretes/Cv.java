package project.hrms.entities.concretes;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;



import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Table(name="cvies")
@AllArgsConstructor
@NoArgsConstructor
public class Cv {


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="photo")
	private String photo;
	
	@Column(name="github_link")
	private String githubLink;

	
	@Column(name="linkedin_link")
	private String linkedinLink;
	
	@Column(name="description")
	private String description;
	
	
	@Column(name="generated_date")
	private LocalDate generatedDate;
	
	@Column(name="active_status")
	private boolean activeOfStatus;
	
	@Column(name="last_updated_date")
	private LocalDate lastUpdatedDate;
	
	
	@OneToOne()
	@JoinColumn(name = "candidate_id",referencedColumnName = "id")
	private Candidate candidate;
	
	
	@OneToMany(mappedBy = "cv")
	private List<Education> educations;
	
	
	@OneToMany(mappedBy = "cv")
	private List<Language> languages;


	@OneToMany(mappedBy = "cv")
	private List<ProgrammingLanguage> programmingLanguages;
	
	@OneToMany(mappedBy = "cv")
	private List<JobExperience> jobExperiences;
	
	
	
    
}
