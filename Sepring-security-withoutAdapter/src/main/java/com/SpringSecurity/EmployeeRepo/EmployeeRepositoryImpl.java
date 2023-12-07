package com.SpringSecurity.EmployeeRepo;

import org.springframework.stereotype.Repository;


import com.SpringSecurity.EmployeeRepo.EmployeeRepository;
import com.SpringSecurity.Model.Employee;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class EmployeeRepositoryImpl implements EmployeeRepository {

    private Map<Integer, Employee> employeeMap = new HashMap<>();

    public EmployeeRepositoryImpl() {

        Employee employee1 = new Employee();
        employee1.setId(1);
        employee1.setDepartment("Development");
        employee1.setGender("Male");
        employee1.setName("John Doe");

        Employee employee2 = new Employee();
        employee2.setId(2);
        employee2.setDepartment("Tester");
        employee2.setGender("Male");
        employee2.setName("Max Musterman");

        Employee employee3 = new Employee();
        employee3.setId(3);
        employee3.setDepartment("Human Resource");
        employee3.setGender("Female");
        employee3.setName("Mary Hxvier");

        employeeMap.put(employee1.getId(),employee1);
        employeeMap.put(employee2.getId(),employee2);
        employeeMap.put(employee3.getId(),employee3);
    }

	@Override
	public List<Employee> findAll() {
		
		return new ArrayList<>(employeeMap.values());
	}

	@Override
	public Employee findById(int id) {
		
		return employeeMap.get(id);
	}

	@Override
	public void create(Employee employee) {
		employee.setId((int) new Date().getTime());
        employeeMap.put(employee.getId(),employee);
		
	}

	@Override
	public void delete(int id) {
		 employeeMap.remove(id);
		
	}

	@Override
	public Employee update(Employee employee) {
		  employeeMap.replace(employee.getId(), employee);
	        return employee;
	}
    
}
