package com.arun.springdata.springdata.Controller;

import com.arun.springdata.springdata.Entity.Employee;
import com.arun.springdata.springdata.Service.IEmployeeService;
import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping(value = "/employee")
@RestController
@Api(value = "Details of the employee")
public class EmployeeController {

    @Autowired
    IEmployeeService employeeService;

    @ApiOperation(value = "Add Employee Details")
    @PostMapping(value = "/v1/add")
    public String addEmployee(@RequestBody Employee employee) {
        employeeService.addEmployee(employee);
        return "added";
    }

    @GetMapping(value = "/v1/get/{name}")
    @ApiOperation(value = "Get Employee details based on name")
    public @ResponseBody
    Employee getEmployee(@PathVariable String name) {
        return employeeService.getEmployeeByName(name);
    }

    @GetMapping(value = "/v1/getAll")
    public @ResponseBody
    List<Employee> getAllEmployee() {
        return employeeService.getAllEmployee();
    }

    @GetMapping(value = "/v1/getDetailsById/{Id}")
    public @ResponseBody
    Employee getEmployeeById(@PathVariable long Id) {
        return employeeService.getEmployee(Id);
    }
}
