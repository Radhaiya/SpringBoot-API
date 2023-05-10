package com.example.employee.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;

@Entity
@Table(name = "employee")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long empid;

    @JsonProperty("employee_name")
    @Column(name = "emp_name")
    private String empname;

    @Column(name = "emp_salaray")
    private Float empsalary;

    @Column(name = "emp_age")
    private int empage;


    @Column(name = "emp_city")
    private String empcity;


    ///Getter and Setters
    public Long getEmpid() {
        return empid;
    }

    public void setEmpid(Long empid) {
        this.empid = empid;
    }

    public String getEmp_name() {
        return empname;
    }

    public void setEmp_name(String emp_name) {
        this.empname = emp_name;
    }

    public Float getEmp_salary() {
        return empsalary;
    }

    public void setEmp_salary(Float emp_salary) {
        this.empsalary = emp_salary;
    }

    public int getEmp_age() {
        return empage;
    }

    public void setEmp_age(int emp_age) {
        this.empage = emp_age;
    }

    public String getEmp_city() {
        return empcity;
    }

    public void setEmp_city(String emp_city) {
        this.empcity = emp_city;
    }

    public Employee(Long empid, String emp_name, Float emp_salary, int emp_age, String emp_city) {
        this.empid = empid;
        this.empname = emp_name;
        this.empsalary = emp_salary;
        this.empage = emp_age;
        this.empcity = emp_city;
    }

    public Employee(){

    }

    @Override
    public String toString() {
        return "Employee{" +
                "empid=" + empid +
                ", emp_name='" + empname + '\'' +
                ", emp_salary=" + empsalary +
                ", emp_age=" + empage +
                ", emp_city=" + empcity + '\''+
                '}';
    }
}
