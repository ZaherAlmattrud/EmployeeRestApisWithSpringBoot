package com.example.EmployeeRestApisWithSpringBoot.service;


import com.example.EmployeeRestApisWithSpringBoot.exception.EmployeeNotFoundException;
import com.example.EmployeeRestApisWithSpringBoot.model.Employee;
import com.example.EmployeeRestApisWithSpringBoot.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {


    @Autowired
    private EmployeeRepository employeeRepository ;


    public Employee createEmployee(Employee employee){

        return employeeRepository.save(employee);
    }

    public Employee updateEmployee(Long id ,Employee employee){

        Optional<Employee> optionalEmployee = employeeRepository.findById(id);

        if(! optionalEmployee.isPresent()){
            throw new EmployeeNotFoundException("Employee With ID : "+id+" Not Found");
        }

        employee.setId(id);
        return employeeRepository.save(employee);

    }

    public void deleteEmployee(Long id){

        Optional<Employee> optionalEmployee = employeeRepository.findById(id);

        if( optionalEmployee.isEmpty()){
            throw new EmployeeNotFoundException("Employee With ID : "+id+" Not Found");
        }

        employeeRepository.deleteById(id);

    }

    public Employee getEmployee(Long id){

        Optional<Employee> optionalEmployee = employeeRepository.findById(id);

        if( optionalEmployee.isEmpty()){
            throw new EmployeeNotFoundException("Employee With ID : "+id+" Not Found");
        }

        return optionalEmployee.get();

    }


    public List<Employee> getAllEmployees(){

        return employeeRepository.findAll();


    }
}
