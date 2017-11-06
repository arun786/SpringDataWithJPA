package com.arun.springdata.springdata.Service;

import com.arun.springdata.springdata.Entity.Employee;
import com.arun.springdata.springdata.Repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeService implements IEmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public void addEmployee(Employee employee) {
        employeeRepository.save(employee);
    }

    @Override
    public Employee getEmployee(Long Id) {
        return employeeRepository.findOne(Id);
    }

    @Override
    public Employee getEmployeeByName(String name) {
        return employeeRepository.findEmployeeByName(name);
    }

    @Override
    public List<Employee> getAllEmployee() {
        List<Employee> employees = new ArrayList<>();
        employeeRepository.findAll().forEach(employees::add);
        return employees;
    }
}
