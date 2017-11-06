package com.arun.springdata.springdata.Service;

import com.arun.springdata.springdata.Entity.Employee;

import java.util.List;

public interface IEmployeeService {

    void addEmployee(Employee employee);
    Employee getEmployee(Long Id);
    Employee getEmployeeByName(String name);
    List<Employee> getAllEmployee();
}
