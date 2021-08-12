package project.hrms.entities.concretes;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@Data
@EqualsAndHashCode(callSuper = false)
@NoArgsConstructor
@Table(name="employers")
@JsonIgnoreProperties({"hibernateLazyInitializer","handler","jobAdvertisements"})
public class Employer extends User {

	@Column(name="company_name")
	private String companyName;
	
	@Column(name="web_address")
	private String webAddress;

	@Column(name="phone_number")
	private String phoneNumber;
	
	@JsonIgnore
	@OneToMany(mappedBy = "employer")
	private List<JobAdvertisement> jobAdvertisements;
	
	@JsonIgnore
	@OneToOne(mappedBy = "employer")
	private ConfirmedEmployerByEmployee confirmedEmployerByEmployee;
	
	@JsonIgnore
	@OneToOne(mappedBy = "employer")
	private EmployerUpdate employerUpdate;
	
	
	@JsonIgnore
	@OneToOne(mappedBy = "employer")
	private ConfirmedEmployerUpdateByEmployee confirmedEmployerUpdateByEmployee;
	
	
	
	public Employer(int id, String email,String password,String companyName, String webAddress, String phoneNumber) {
		super(id,email,password);
		this.companyName = companyName;
		this.webAddress = webAddress;
		this.phoneNumber = phoneNumber;
	}
	
	
}
