package com.example.EmployeeRestApisWithSpringBoot.controller;


import com.example.EmployeeRestApisWithSpringBoot.dto.EmployeeDto;
import com.example.EmployeeRestApisWithSpringBoot.exception.EmployeeNotFoundException;
import com.example.EmployeeRestApisWithSpringBoot.model.Employee;
import com.example.EmployeeRestApisWithSpringBoot.repository.EmployeeRepository;
import com.example.EmployeeRestApisWithSpringBoot.service.EmployeeService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/employee")
public class EmployeeController
{


    @Autowired
    private EmployeeService employeeService ;



@PostMapping("/create")
    public ResponseEntity<EmployeeDto> createEmployee(EmployeeDto employeeDto){

        return employeeService.createEmployee(employeeDto);
    }

    @PutMapping("/update")
    public ResponseEntity<EmployeeDto> updateEmployee(Long id ,EmployeeDto employeeDto){


        return employeeService.updateEmployee(id , employeeDto);

    }

    @DeleteMapping("/delete")
    public void deleteEmployee(Long id){

         employeeService.deleteEmployee(id);

    }

    @GetMapping("/{id}")
    public ResponseEntity<EmployeeDto> getEmployee(Long id){

        return  employeeService.getEmployee(id);

    }

@GetMapping("all")
    public List<Employee> getAllEmployees(){

      return employeeService.getAllEmployees();


    }
}
