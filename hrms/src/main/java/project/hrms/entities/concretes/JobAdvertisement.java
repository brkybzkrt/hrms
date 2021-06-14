package project.hrms.entities.concretes;

import java.time.LocalDate;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Table(name="job_advertisements")
@Data
@NoArgsConstructor
@AllArgsConstructor

public class JobAdvertisement {

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	
	@Column(name="job_description")
	private String jobDescription;
	
	@Column(name="min_salary")
	private long minSalary;
	
	@Column(name="max_salary")
	private long maxSalary;
	
	@Column(name="count_of_position")
	private int countOfPosition;
	
	@Column(name="release_date")
	private LocalDate releaseDate;
	
	@Column(name="deadline__date")
	private LocalDate deadlineDate;
	
	
	@Column(name="status_of_active")
	private boolean statusOfActive;
	
	@ManyToOne()
	@JoinColumn(name="city")
	private City city;
	
	@ManyToOne
	@JoinColumn(name="job_position_id")
	private JobPosition jobPosition;
	
	
	@ManyToOne
	@JoinColumn(name="employer_id")
	private Employer employer;
	
	
	
	
	@ManyToOne
	@JoinColumn(name="job_type_id")
	private JobType jobType;
	
	
	@ManyToOne
	@JoinColumn(name="working_time_id")
	private WorkingTime workingTime;
	
	@JsonIgnore
	@OneToOne(mappedBy = "jobAdvertisement")
	private JobAdvertisementActivationByEmployee jobAdvertisementActivationByEmployee; 
	
	
}
