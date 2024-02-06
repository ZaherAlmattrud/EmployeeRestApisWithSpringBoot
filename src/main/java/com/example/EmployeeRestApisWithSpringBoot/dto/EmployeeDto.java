package com.example.EmployeeRestApisWithSpringBoot.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class EmployeeDto {

    private String firstName ;

    private String lastName  ;

    private double salary ;
}
