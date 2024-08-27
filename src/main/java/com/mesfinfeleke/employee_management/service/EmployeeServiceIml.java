package com.mesfinfeleke.employee_management.service;


import com.mesfinfeleke.employee_management.exception.ResourceNotFoundException;
import com.mesfinfeleke.employee_management.mapper.EmpMapper;
import com.mesfinfeleke.employee_management.model.Employee;
import com.mesfinfeleke.employee_management.model.EmployeeDTO;
import com.mesfinfeleke.employee_management.repository.EmployeeRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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

        Employee emp = employeeRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Employee does not exist for id " + id));
        return EmpMapper.mapToEmployeeDTO(emp);
    }

    @Override
    public List<EmployeeDTO> getAllEmployees() {
        List<Employee> employees = employeeRepository.findAll();
        List<EmployeeDTO> savedEmployee = employees.stream().map((employee) -> EmpMapper.mapToEmployeeDTO(employee))
                .toList();
        return savedEmployee;
    }

    @Override
    public EmployeeDTO updateEmployee(int id, EmployeeDTO empDto) {

        Employee emp = employeeRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Employee does not exist for id " + id));

       // emp.setEmpId(empDto.getEmpId());
        emp.setFirstName(empDto.getFirstName());
        emp.setLastName(empDto.getLastName());
        emp.setEmail(empDto.getEmail());
        employeeRepository.save(emp);

        EmployeeDTO savedEmployee = EmpMapper.mapToEmployeeDTO(emp);
        return savedEmployee;
    }

    @Override
    public void deleteEmployee(int id) {
        Employee emp = employeeRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Employee does not exist for id " + id));
        employeeRepository.delete(emp);
    }

}
