package com.example.EmployeeRestApisWithSpringBoot.repository;

import com.example.EmployeeRestApisWithSpringBoot.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee , Long> {
}
