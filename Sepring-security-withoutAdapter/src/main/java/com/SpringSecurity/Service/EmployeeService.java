package com.SpringSecurity.Service;

import java.util.List;

import com.SpringSecurity.Model.Employee;


public interface EmployeeService {
    List<Employee> findAll();
    Employee findById(int id);
    void create(Employee employee);
    void delete (int id);
    Employee update (Employee employee);
}