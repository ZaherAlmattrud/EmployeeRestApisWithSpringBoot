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
    public ResponseEntity<EmployeeDto> createEmployee(@RequestBody EmployeeDto employeeDto){

        return employeeService.createEmployee(employeeDto);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<EmployeeDto> updateEmployee(@PathVariable Long id ,@RequestBody EmployeeDto employeeDto){


        return employeeService.updateEmployee(id , employeeDto);

    }

    @DeleteMapping("/delete/{id}")
    public void deleteEmployee(@PathVariable  Long id){

         employeeService.deleteEmployee(id);

    }

    @GetMapping("/{id}")
    public ResponseEntity<EmployeeDto> getEmployee(@PathVariable Long id){

        return  employeeService.getEmployee(id);

    }

@GetMapping("all")
    public List<Employee> getAllEmployees(){

      return employeeService.getAllEmployees();


    }
}
