package com.arun.springdata.springdata.Repository;

import com.arun.springdata.springdata.Entity.Employee;
import org.springframework.data.repository.CrudRepository;

public interface EmployeeRepositoryOnName extends CrudRepository<Employee, String> {
}
