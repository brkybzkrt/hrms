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
@Table(name="job_advertisement_activation_by_employees")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class JobAdvertisementActivationByEmployee {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@JsonIgnore
	@OneToOne()
	@JoinColumn(name="job_advertisement_id")
	private JobAdvertisement jobAdvertisement;
	
	@ManyToOne()
	@JoinColumn(name="employee_id")
	private Employee employee;
	
	
	@Column(name="is_confirmed")
	private Boolean isConfirmed;
	
	
	@Column(name="confirmed_date")
	private LocalDate  confirmedDate;
	
	
}
