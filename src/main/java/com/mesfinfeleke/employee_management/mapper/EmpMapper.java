package com.mesfinfeleke.employee_management.mapper;

import com.mesfinfeleke.employee_management.model.Employee;
import com.mesfinfeleke.employee_management.model.EmployeeDTO;

public class EmpMapper {

    public static EmployeeDTO mapToEmployeeDTO(Employee emp){
        return new EmployeeDTO(emp.getEmpId(),
                emp.getFirstName(),
                emp.getLastName(),
                emp.getEmail());
    }

    public static Employee mapToEmployee(EmployeeDTO employeeDTO){
        return new Employee(
                employeeDTO.getEmpId(),
                employeeDTO.getFirstName(),
                employeeDTO.getLastName(),
                employeeDTO.getEmail()
        );
    }
}
