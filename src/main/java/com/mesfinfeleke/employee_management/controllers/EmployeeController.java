package com.mesfinfeleke.employee_management.controllers;

import com.mesfinfeleke.employee_management.mapper.EmpMapper;
import com.mesfinfeleke.employee_management.model.Employee;
import com.mesfinfeleke.employee_management.model.EmployeeDTO;
import com.mesfinfeleke.employee_management.service.EmployeeService;
import com.mesfinfeleke.employee_management.service.EmployeeServiceIml;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/home")
    public String home() {
        return "Hello from home";
    }

    @GetMapping("{empId}")
    public ResponseEntity<EmployeeDTO> getEmployee(@PathVariable("empId") int empId) {
        EmployeeDTO emp = employeeService.getEmployee(empId);
        // return new ResponseEntity<>(emp, HttpStatus.valueOf(200));
        return ResponseEntity.ok(emp);

    }

    @PostMapping
    public ResponseEntity<EmployeeDTO> createEmployee(@RequestBody EmployeeDTO empDto) {
        EmployeeDTO savedEmployee = employeeService.createEmployee(empDto);
        return new ResponseEntity<>(savedEmployee, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<EmployeeDTO>> getAllEmployees() {
        List<EmployeeDTO> employess = employeeService.getAllEmployees();
        return ResponseEntity.ok(employess);
    }

    @PutMapping("{empID}")
    public ResponseEntity<EmployeeDTO> updateEmployee(@PathVariable("empID") int id, @RequestBody EmployeeDTO empDto) {
        EmployeeDTO updateEmployee = employeeService.updateEmployee(id, empDto);
        return ResponseEntity.ok(updateEmployee);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteEmployee(@PathVariable("id") int id) {
        employeeService.deleteEmployee(id);
        return ResponseEntity.ok("Employee deleted Successfully");

    }
}

