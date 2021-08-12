package project.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Service;

import com.sun.istack.NotNull;

import project.hrms.business.abstracts.EmployeeService;
import project.hrms.core.utilities.results.DataResult;
import project.hrms.core.utilities.results.Result;
import project.hrms.core.utilities.results.SuccessDataResult;
import project.hrms.core.utilities.results.SuccessResult;
import project.hrms.dataAccess.abstracts.EmployeeDao;
import project.hrms.entities.concretes.Employee;

@Service
public class EmployeeManager implements EmployeeService {

	private EmployeeDao employeeDao;
	
	@Autowired
	public EmployeeManager(EmployeeDao employeeDao) {
		super();
		this.employeeDao = employeeDao;
	}


	@Override
	public Result add(Employee employee) {
		
		
		this.employeeDao.save(employee);
		Employee sameEmployee= this.employeeDao.getOne(employee.getId());
		sameEmployee.setCompanyEmail("calisan"+sameEmployee.getId()+"@hrms.com");
		this.employeeDao.save(sameEmployee);
		return new SuccessResult("Çalışan eklendi");
	}


	@Override
	public Result update(int employeeId, Employee employee) {
		Employee updatedEmployee= this.employeeDao.getOne(employeeId);
		
		updatedEmployee.setFirstName(employee.getFirstName());
		updatedEmployee.setLastName(employee.getLastName());
		updatedEmployee.setEmail(employee.getEmail());
		updatedEmployee.setPassword(employee.getPassword());
		
		this.employeeDao.save(updatedEmployee);
		
		return new SuccessResult("başarıyla güncellendi");
		
	}


	@Override
	public DataResult<Employee> getByEmployeeId(int employeeId) {
		return new SuccessDataResult<Employee>(this.employeeDao.getOne(employeeId),"Çalışan getirildi");
	}


	@Override
	public DataResult<List<Employee>> getAll() {
		
		return new SuccessDataResult<List<Employee>>(this.employeeDao.findAll());
	}


	@Override
	public DataResult<Page<Employee>> findAllWithPageable(String firstName,String companyEmail,int pageNumber,int pageSize) {
		
		Pageable page=PageRequest.of(pageNumber-1, pageSize);
		
		if(firstName==null&& companyEmail==null) {
			
			return new SuccessDataResult<Page<Employee>>(this.employeeDao.findAll(page));
		}
		else if(firstName==null && companyEmail!=null) {
			
			return new SuccessDataResult<Page<Employee>>(this.employeeDao.findByCompanyEmailContaining( companyEmail, page));
		}
		else if(firstName!=null && companyEmail==null) {
			
			return new SuccessDataResult<Page<Employee>>(this.employeeDao.findByFirstNameContaining(firstName, page));
		}
		else {
			return new SuccessDataResult<Page<Employee>>(this.employeeDao.findByFirstNameOrCompanyEmailContaining(firstName,companyEmail, page), "Sayfalama ile çalışanlar getirildi.");
		}
		
		
	}
	
	
	

}
