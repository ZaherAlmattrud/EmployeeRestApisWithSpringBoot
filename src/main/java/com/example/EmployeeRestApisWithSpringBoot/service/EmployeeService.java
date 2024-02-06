package com.example.EmployeeRestApisWithSpringBoot.service;


import com.example.EmployeeRestApisWithSpringBoot.dto.EmployeeDto;
import com.example.EmployeeRestApisWithSpringBoot.exception.EmployeeNotFoundException;
import com.example.EmployeeRestApisWithSpringBoot.model.Employee;
import com.example.EmployeeRestApisWithSpringBoot.repository.EmployeeRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {


    @Autowired
    private EmployeeRepository employeeRepository ;

    @Autowired
    private ModelMapper modelMapper;


    public ResponseEntity<EmployeeDto> createEmployee(EmployeeDto employeeDto){

        Employee employee = modelMapper.map(employeeDto, Employee.class);
        Employee savedEmployee = employeeRepository.save(employee);
        EmployeeDto savedEmployeeDto = modelMapper.map(savedEmployee, EmployeeDto.class);
        return ResponseEntity.ok(savedEmployeeDto) ;
    }

    public ResponseEntity<EmployeeDto> updateEmployee(Long id ,EmployeeDto employeeDto){


        Employee  employee = employeeRepository.findById(id).orElse(null);

        System.out.print(employee);
        if(employee == null){
            throw new EmployeeNotFoundException("Employee With ID : "+id+" Not Found");
        }

        employee.setId(id);
        employee.setFirstName(employeeDto.getFirstName());
        employee.setLastName(employeeDto.getLastName());
        employee.setSalary(employeeDto.getSalary());


        Employee updatedEmployee = employeeRepository.save(employee);

        EmployeeDto updatedEmployeeDto = modelMapper.map(updatedEmployee, EmployeeDto.class);

        return ResponseEntity.ok(updatedEmployeeDto) ;

    }

    public void deleteEmployee(Long id){

        Employee employee = employeeRepository.findById(id).orElse(null);

        if( employee == null){
            throw new EmployeeNotFoundException("Employee With ID : "+id+" Not Found");
        }

        employeeRepository.deleteById(id);

    }

    public ResponseEntity<EmployeeDto> getEmployee(Long id){

        Employee employee = employeeRepository.findById(id).orElse(null);

        if( employee == null ){
            throw new EmployeeNotFoundException("Employee With ID : "+id+" Not Found");
        }

        EmployeeDto employeeDto = modelMapper.map(employee, EmployeeDto.class);

        return ResponseEntity.ok(employeeDto) ;

    }


    public List<Employee> getAllEmployees(){

        List<Employee>  employees = employeeRepository.findAll();

        return  employees ;


    }
}
