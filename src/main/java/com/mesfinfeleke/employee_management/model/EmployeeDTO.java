package com.mesfinfeleke.employee_management.model;

import lombok.*;

@Data
@AllArgsConstructor
public class EmployeeDTO {

    private Integer empId;
    private String firstName;
    private String lastName;
    private String email;
}
