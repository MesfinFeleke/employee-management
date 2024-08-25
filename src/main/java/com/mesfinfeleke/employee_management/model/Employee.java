package com.mesfinfeleke.employee_management.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.autoconfigure.web.WebProperties;

@Data
@NoArgsConstructor
@Entity
@Table(name = "employee")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer empId;
    String firstName;
    String lastName;
    @Column(name ="email" , nullable = false , unique = true)
    String email;

}
