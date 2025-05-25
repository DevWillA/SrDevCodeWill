package com.devsenior.will.entity;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "employees")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "employee_id")
    private Integer employeeId;

    @Column(name = "first_name", length = 20)
    private String firtsName;

    @Column(length = 25, nullable = false, name = "last_name")
    private String lastName;

    @Column(length = 100, nullable = false, name = "email")
    private String email;

    @Column(length = 20, name = "phone_number")
    private String phoneNumber;

    @Column(name = "hire_date",nullable = false)
    private LocalDate hireDate;

    @Column (name = "job_id")
    private Integer jobId;

    @Column(precision = 2, nullable = false)
    private Double salary;

    @ManyToOne
    @JoinColumn(name = "manager_id", referencedColumnName = "employee_id")
    @Column(name = "manager_id")
    private Employee manager;

    @ManyToOne
    @JoinColumn(name = "department_id", referencedColumnName = "department_id")
    @Column(name = "department_id")
    private Department department;

    public Integer getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Integer employeeId) {
        this.employeeId = employeeId;
    }

    public String getFirtsName() {
        return firtsName;
    }

    public void setFirtsName(String firtsName) {
        this.firtsName = firtsName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public LocalDate getHireDate() {
        return hireDate;
    }

    public void setHireDate(LocalDate hireDate) {
        this.hireDate = hireDate;
    }

    public Integer getJobId() {
        return jobId;
    }

    public void setJobId(Integer jobId) {
        this.jobId = jobId;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    public Employee getManager() {
        return manager;
    }

    public void setManager(Employee manager) {
        this.manager = manager;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    @Override
    public String toString() {
        return "Employee [employeeId=" + employeeId + ", firtsName=" + firtsName + ", lastName=" + lastName
                + ", email=" + email + ", phoneNumber=" + phoneNumber + ", hireDate=" + hireDate + ", jobId=" + jobId
                + ", salary=" + salary + ", manager=" + manager + ", department=" + department + "]";
    }

}
