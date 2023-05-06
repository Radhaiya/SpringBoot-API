package com.example.employee.controller;

import com.example.employee.entity.Employee;
import com.example.employee.repository.EmployeeRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.swing.text.html.Option;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class EmployeeController {

    @Autowired
    EmployeeRepository  employeeRepository;

    @PostMapping("/employee")
    public String createNewEmployee(@RequestBody Employee employee){
        employeeRepository.save(employee);
        return "Database is Created";
    }

    @GetMapping("/employee")
    public ResponseEntity<List<Employee>> getAllEmployee(){
       List<Employee>emplist = new ArrayList<>();
      employeeRepository.findAll().forEach(emplist::add);
      return new ResponseEntity<List<Employee>>(emplist, HttpStatus.OK) ;
    }

    @GetMapping("/employee/{emid}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable long emid){
       Optional<Employee> emp =   employeeRepository.findById(emid);
       if(emp.isPresent()){
           return new ResponseEntity<Employee>(emp.get(),HttpStatus.FOUND);
       }
       else {
           return new ResponseEntity<Employee>(HttpStatus.NOT_FOUND);
       }
    }

    @PutMapping("/employee/{emid}")
    public String editEmployeeId(@PathVariable long emid,@RequestBody Employee employee){
       Optional<Employee> emp =  employeeRepository.findById(emid);
       if(emp.isPresent()){
           Employee existEmployee = emp.get();
           existEmployee.setEmp_age(employee.getEmp_age());
           existEmployee.setEmp_name(employee.getEmp_name());
           existEmployee.setEmp_salary(employee.getEmp_salary());
           existEmployee.setEmp_city(employee.getEmp_city());
           employeeRepository.save(existEmployee);
            return "Employee Details against id "+emid+" updated";
       }
       else {
           return "No employee found";
       }

    }

    @DeleteMapping("/employee/{emid}")
    public ResponseEntity<String> deleteEmployeebyId(@PathVariable long emid){
        Optional<Employee> emp = employeeRepository.findById(emid);
        if(emp.isPresent()){
            Employee existEmployee = emp.get();
            employeeRepository.delete(existEmployee);
            return new ResponseEntity<>("Deleted with ID"+emid ,HttpStatus.OK);
        }
        else {
            return new ResponseEntity<>("Not found with ID"+emid ,HttpStatus.NOT_FOUND);
        }
    }
}
