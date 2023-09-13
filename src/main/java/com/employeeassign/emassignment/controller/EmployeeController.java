package com.employeeassign.emassignment.controller;

import com.employeeassign.emassignment.model.Employee;
import com.employeeassign.emassignment.model.IncrementSalaryRequest;
import com.employeeassign.emassignment.service.EmployeeService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("employee")
@Api(value = "Employee Management System", description = "Managing employees and their data")
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;
    @ApiOperation(value = "Get a list of employees available", response=List.class)
    @GetMapping(produces = {"application/json", MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<List<Employee>> getEmployees(){
        return employeeService.getEmployees();
    }
    @ApiOperation(value = "Add an employee")
    @PostMapping(consumes = {"application/json", MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<?> postEmployee(@Valid @RequestBody Employee employee){
        return employeeService.postEmployee(employee);
    }
    @GetMapping(value = "/{id}", produces = {"application/json", MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<Employee> getEmployeeById(@PathVariable Integer id){
        return employeeService.getEmployeeById(id);
    }
    @GetMapping("/find")
    public ResponseEntity<Employee> getEmployeeByFirstNameandLastName
            (@RequestParam String firstName, @RequestParam String lastName){
        return employeeService.getEmployeeByFirstNameandLastName(firstName, lastName);
    }
    @PutMapping("/{id}")
    public ResponseEntity<?> updateEmployee(@PathVariable Integer id, @RequestBody Employee employee){
        return employeeService.updateEmployee(id, employee);
    }
    @PatchMapping("/{id}")
    public ResponseEntity<Employee> incrementSalary(@PathVariable Integer id, @RequestBody IncrementSalaryRequest incrementSalaryRequest){
        return employeeService.incrementSalary(id, incrementSalaryRequest);
    }


}
