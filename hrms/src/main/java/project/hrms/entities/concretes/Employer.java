package project.hrms.entities.concretes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@Data
@EqualsAndHashCode(callSuper = false)
@NoArgsConstructor
@Table(name="employers")
public class Employer extends User {

	@Column(name="company_name")
	private String companyName;
	
	@Column(name="web_address")
	private String webAddress;

	@Column(name="phone_number")
	private String phoneNumber;
	
	public Employer(int id, String email,String password,String companyName, String webAddress, String phoneNumber) {
		super(id,email,password);
		this.companyName = companyName;
		this.webAddress = webAddress;
		this.phoneNumber = phoneNumber;
	}
	
	
}
