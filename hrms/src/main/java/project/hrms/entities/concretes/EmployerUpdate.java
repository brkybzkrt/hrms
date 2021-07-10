package project.hrms.entities.concretes;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="employer_updates")
public class EmployerUpdate {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	int id;
	
	
	@JsonIgnore
	@OneToOne
	@JoinColumn(name="employer_id")
	private Employer employer;
	
	@Column(name="email")
	String email;
	
	@Column(name="password")
	String password;
	
	@Column(name="company_name")
	String companyName;
	
	@Column(name="web_address")
	String webAddress;
	
	@Column(name="phone_number")
	String phoneNumber;
	
	@JsonIgnore
	@Column(name="confirmed_status")
	Boolean confirmedStatus;
	
	@JsonIgnore
	@Column(name="update_date")
	LocalDate updateDate;
	

	

}
