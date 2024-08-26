package com.mesfinfeleke.employee_management.service;

import com.mesfinfeleke.employee_management.model.EmployeeDTO;
import org.springframework.stereotype.Service;

@Service
public interface EmployeeService {

    EmployeeDTO createEmployee(EmployeeDTO employeeDTO) ;

    EmployeeDTO getEmployee(int id) ;
}
