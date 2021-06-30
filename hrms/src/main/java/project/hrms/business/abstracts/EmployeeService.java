package project.hrms.business.abstracts;

import java.util.List;

import project.hrms.core.utilities.results.DataResult;
import project.hrms.core.utilities.results.Result;
import project.hrms.entities.concretes.Employee;

public interface EmployeeService {

	
	Result add(Employee employee);
	DataResult<List<Employee>> getAll();
	DataResult<Employee> getByEmployeeId(int employeeId);
	Result update(int employeeId,Employee employee);
}
