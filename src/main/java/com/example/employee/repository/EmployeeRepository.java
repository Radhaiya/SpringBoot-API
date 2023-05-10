package com.example.employee.repository;

import com.example.employee.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.SimpleTimeZone;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee,Long> {

   List<Employee> findByEmpcity(String emp_city);

    Optional<List<Employee>> findByEmpageGreaterThan(int emp_age);
}
