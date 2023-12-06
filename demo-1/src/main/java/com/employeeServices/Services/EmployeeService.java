package com.employeeServices.Services;

import java.util.List;

import com.employeeServices.Entity.Employee;


public interface EmployeeService {
	
	Employee saveEmployee(Employee employee);

    List<Employee> fetchAllEmployees();

    Employee getEmployeeById(Long id);

    Employee updateEmployeeById(Long id, Employee employee);

    String deleteDepartmentById(Long id);
	

}
