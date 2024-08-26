package com.mesfinfeleke.employee_management.service;


import com.mesfinfeleke.employee_management.mapper.EmpMapper;
import com.mesfinfeleke.employee_management.model.Employee;
import com.mesfinfeleke.employee_management.model.EmployeeDTO;
import com.mesfinfeleke.employee_management.repository.EmployeeRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeServiceIml implements EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public EmployeeDTO createEmployee(EmployeeDTO employeeDTO) {
        Employee savedEmployee = EmpMapper.mapToEmployee(employeeDTO);
        employeeRepository.save(savedEmployee);
        return EmpMapper.mapToEmployeeDTO(savedEmployee);
    }

    @Override
    public EmployeeDTO getEmployee(int id) {

        Employee emp = employeeRepository.findById(id).get();
        return EmpMapper.mapToEmployeeDTO(emp);
    }
}
