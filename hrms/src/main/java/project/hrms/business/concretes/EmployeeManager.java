package project.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
		
		employee.setCompanyEmail("calisan"+employee.getId()+"@hrms.com");
		this.employeeDao.save(employee);
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

}
