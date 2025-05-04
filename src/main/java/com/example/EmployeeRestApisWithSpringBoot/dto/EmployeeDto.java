package com.example.EmployeeRestApisWithSpringBoot.dto;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class EmployeeDto {


    @NotNull
    @NotBlank(message = "Please provide a firstName")
    @Max(value = 20 , message = " firstName must 20 character maximum")
    @Min(value = 20 , message = " firstName must  grater than 3 character ")
    private String firstName ;

    @NotNull
    @NotBlank(message = "Please provide a lastName")
    @Max(value = 20 , message = " lastName must 20 character maximum")
    @Min(value = 20 , message = " lastName must  grater than 3 character ")
    private String lastName  ;

    @NotNull
    @NotBlank(message = "Please provide a salary")
    @Size(min = 1,message = "salary must equal or grater than 1 SYP ")
    private double salary ;
}
