package com.mesfinfeleke.employee_management.controllers;

import com.mesfinfeleke.employee_management.model.Employee;
import com.mesfinfeleke.employee_management.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/")
    public String home(){
        return "Hello from home" ;
    }

    @GetMapping("/employee/{id}")
    public ResponseEntity<Employee> getEmployee(@PathVariable("id") int empId){
            Employee emp = employeeService.getEmployee(empId);
        return new ResponseEntity<>(emp, HttpStatusCode.valueOf(200));
    }

}

