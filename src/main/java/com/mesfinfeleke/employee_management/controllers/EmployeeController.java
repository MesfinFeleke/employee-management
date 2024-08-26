package com.mesfinfeleke.employee_management.controllers;

import com.mesfinfeleke.employee_management.mapper.EmpMapper;
import com.mesfinfeleke.employee_management.model.Employee;
import com.mesfinfeleke.employee_management.model.EmployeeDTO;
import com.mesfinfeleke.employee_management.service.EmployeeServiceIml;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class EmployeeController {

    @Autowired
    private EmployeeServiceIml employeeService;

    @GetMapping("/home")
    public String home(){
        return "Hello from home" ;
    }

    @GetMapping("/employee/{id}")
    public ResponseEntity<EmployeeDTO> getEmployee(@PathVariable("id") int empId){
           EmployeeDTO emp = employeeService.getEmployee(empId);
        return new ResponseEntity<>(emp, HttpStatus.valueOf(200));
    }

    @PostMapping("employee")
    public ResponseEntity<EmployeeDTO> createEmployee(@RequestBody EmployeeDTO empDto){
        employeeService.createEmployee(empDto);
      return new ResponseEntity<>(empDto, HttpStatus.CREATED);
    }

}

