package project.hrms.dataAccess.abstracts;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import project.hrms.entities.concretes.Employee;

public interface EmployeeDao extends JpaRepository<Employee, Integer>{

	
	
	Page<Employee> findByFirstNameOrCompanyEmailContaining(String firstName,String CompanyEmail,Pageable page);

	Page<Employee> findByCompanyEmailContaining(String companyEmail, Pageable page);
		
	Page<Employee> findByFirstNameContaining(String firstName, Pageable page);
}
