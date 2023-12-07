package com.SpringSecurity.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.SpringSecurity.EmployeeRepo.EmployeeRepository;
import com.SpringSecurity.Model.Employee;
import com.SpringSecurity.exception.EmployeeNotFoundException;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

	@Override
	public List<Employee> findAll() {
		
		 return employeeRepository.findAll();
	}

	@Override
	public Employee findById(int id) throws EmployeeNotFoundException {
		Employee employee = employeeRepository.findById(id);
        if(employee == null) {
            throw new EmployeeNotFoundException("Employee not found with id :" + id);
        }
        return employee;
	}

	@Override
	public void create(Employee employee) {
		employeeRepository.create(employee);
		
	}

	@Override
	public void delete(int id) {
		 employeeRepository.delete(id);
		
	}

	@Override
	public Employee update(Employee employee) {
		return employeeRepository.update(employee);
	}

    
}
