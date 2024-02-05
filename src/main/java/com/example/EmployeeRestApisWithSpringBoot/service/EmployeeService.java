package com.example.EmployeeRestApisWithSpringBoot.service;


import com.example.EmployeeRestApisWithSpringBoot.dto.EmployeeDto;
import com.example.EmployeeRestApisWithSpringBoot.exception.EmployeeNotFoundException;
import com.example.EmployeeRestApisWithSpringBoot.model.Employee;
import com.example.EmployeeRestApisWithSpringBoot.repository.EmployeeRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {


    @Autowired
    private EmployeeRepository employeeRepository ;

    private ModelMapper modelMapper;


    public EmployeeDto createEmployee(EmployeeDto employeeDto){

        Employee employee = modelMapper.map(employeeDto, Employee.class);
        Employee savedEmployee = employeeRepository.save(employee);
        EmployeeDto savedEmployeeDto = modelMapper.map(savedEmployee, EmployeeDto.class);
        return savedEmployeeDto ;
    }

    public EmployeeDto updateEmployee(Long id ,EmployeeDto employeeDto){

          Employee employee = null ;
          employee = employeeRepository.findById(id).get();

        if(employee == null){
            throw new EmployeeNotFoundException("Employee With ID : "+id+" Not Found");
        }

        employee.setId(id);

        Employee updatedEmployee = employeeRepository.save(employee);

        EmployeeDto updatedEmployeeDto = modelMapper.map(updatedEmployee, EmployeeDto.class);

        return updatedEmployeeDto ;

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
