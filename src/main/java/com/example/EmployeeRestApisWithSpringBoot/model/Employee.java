package com.example.EmployeeRestApisWithSpringBoot.model;

import jakarta.persistence.*;
import lombok.*;


@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Entity
@Table(name ="employees")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name ="emp_id")
    private Long id ;
    private String firstName ;

    private String lastName  ;

    private double salary ;
}
