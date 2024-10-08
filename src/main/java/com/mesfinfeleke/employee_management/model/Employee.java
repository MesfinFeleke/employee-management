package com.mesfinfeleke.employee_management.model;

import jakarta.persistence.*;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer empId;
    private String firstName;
    private String lastName;
    @Column(name ="email" , nullable = false , unique = true)
    private String email;

}
