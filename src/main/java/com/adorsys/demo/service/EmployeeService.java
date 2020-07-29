package com.adorsys.demo.service;
import com.adorsys.demo.entity.*;

import java.util.List;

public interface EmployeeService {
	
	public List<Employee> getEmployee();
	
	public Employee getEmployeeById(Long id);
	
	public Employee createEmployee(Employee newEmployee);
	
	public Employee updateEmployee(Employee newEmbloyee, Long id);
	
	public void deleteEmployee(Long id);

}
