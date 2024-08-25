package com.mesfinfeleke.employee_management.service;
import com.mesfinfeleke.employee_management.dto.EmployeeRepository;
import com.mesfinfeleke.employee_management.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepo;

    public Employee getEmployee(int id){
      return employeeRepo.findById(id).get();
    }
}
