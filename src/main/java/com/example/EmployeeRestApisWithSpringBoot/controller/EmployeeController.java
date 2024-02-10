package com.example.EmployeeRestApisWithSpringBoot.controller;


import com.example.EmployeeRestApisWithSpringBoot.dto.EmployeeDto;
import com.example.EmployeeRestApisWithSpringBoot.exception.EmployeeNotFoundException;
import com.example.EmployeeRestApisWithSpringBoot.model.Employee;
import com.example.EmployeeRestApisWithSpringBoot.repository.EmployeeRepository;
import com.example.EmployeeRestApisWithSpringBoot.service.EmployeeService;
import jakarta.validation.Valid;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/employee")
public class EmployeeController
{


    @Autowired
    private EmployeeService employeeService ;



@PostMapping("/create")
    public ResponseEntity<String> createEmployee(@RequestBody @Valid EmployeeDto employeeDto , BindingResult bindingResult){

    if (bindingResult.hasErrors()) {
        for (ObjectError error : bindingResult.getAllErrors()) {
            String errorMessage = error.getDefaultMessage();
            return ResponseEntity.badRequest().body( errorMessage );
        }
        //return ResponseEntity.badRequest().body("Validation failed");
    }

    employeeService.createEmployee(employeeDto);

    return ResponseEntity.ok("Employee Created Successfully");
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<String> updateEmployee(@PathVariable Long id ,@RequestBody @Valid EmployeeDto employeeDto , BindingResult bindingResult){

        if (bindingResult.hasErrors()) {
            for (ObjectError error : bindingResult.getAllErrors()) {
                String errorMessage = error.getDefaultMessage();
                return ResponseEntity.badRequest().body( errorMessage );
            }
          //  return ResponseEntity.badRequest().body("Validation failed");
        }

        employeeService.updateEmployee(id , employeeDto);

        return ResponseEntity.ok("Employee Updated Successfully");

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
    public List<EmployeeDto> getAllEmployees(){

      return employeeService.getAllEmployees();


    }
}
