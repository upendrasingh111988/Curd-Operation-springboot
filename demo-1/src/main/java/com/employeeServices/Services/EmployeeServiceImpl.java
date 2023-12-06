package com.employeeServices.Services;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.apache.catalina.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.employeeServices.Entity.Employee;
import com.employeeServices.Repository.EmployeeRepository;


@Component
public class EmployeeServiceImpl implements EmployeeService {
	
	@Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public Employee saveEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    @Override
    public List<Employee> fetchAllEmployees() {
        List<Employee> allEmployees = employeeRepository.findAll();
        return allEmployees;
    }

    @Override
    public Employee getEmployeeById(Long id) {
        Optional<Employee> employee = employeeRepository.findById(id);
        if (employee.isPresent()) {
            return employee.get();
        }
        return null;
    }

    @Override
    public Employee updateEmployeeById(Long id, Employee employee) {
        Optional<Employee> employee1 = employeeRepository.findById(id);

        if (employee1.isPresent()) {
            Employee originalEmployee = employee1.get();

            if (Objects.nonNull(employee.getEmployeeName()) && !"".equalsIgnoreCase(employee.getEmployeeName())) {
                originalEmployee.setEmployeeName(employee.getEmployeeName());
            }
            if (Objects.nonNull(employee.getSalary()) && employee.getSalary() != 0) {
                originalEmployee.setSalary(employee.getSalary());
            }
            return employeeRepository.save(originalEmployee);
        }
        return null;
    }

    @Override
    public String deleteDepartmentById(Long id) {
        if (employeeRepository.findById(id).isPresent()) {
            employeeRepository.deleteById(id);
            return "Employee deleted successfully";
        }
        return "No such employee in the database";
    }
	
}
