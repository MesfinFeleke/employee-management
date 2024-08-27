package com.mesfinfeleke.employee_management.service;

import com.mesfinfeleke.employee_management.model.EmployeeDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface EmployeeService {

    EmployeeDTO createEmployee(EmployeeDTO employeeDTO) ;

    EmployeeDTO getEmployee(int id) ;

    List<EmployeeDTO> getAllEmployees();

    EmployeeDTO updateEmployee(int id, EmployeeDTO empDto);

    void deleteEmployee (int id);
}
