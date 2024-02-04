package com.example.EmployeeRestApisWithSpringBoot.exception;

public class EmployeeNotFoundException extends RuntimeException{


    public EmployeeNotFoundException(String message){

        super(message);
    }
}
