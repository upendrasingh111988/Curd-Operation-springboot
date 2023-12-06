package com.employeeServices.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.employeeServices.Entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

}
