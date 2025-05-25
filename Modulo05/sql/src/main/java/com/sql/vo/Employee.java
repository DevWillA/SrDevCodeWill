package com.sql.vo;

import java.time.LocalDate;

public class Employee {

// VO - value Object
// DTO - Data Transfer Object
// POJO - Plain Old Java Object

    private Integer employeeId;
    private String firtsName;
    private String lastName;
    private String email;
    private String phoneNumber;
    private LocalDate hireDate;
    private Integer jobId;
    private Integer salary;
    private String managerId;
    private Integer departmentId;

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
    public Integer getSalary() {
        return salary;
    }
    public void setSalary(Integer salary) {
        this.salary = salary;
    }
    public String getManagerId() {
        return managerId;
    }
    public void setManagerId(String managerId) {
        this.managerId = managerId;
    }
    public Integer getDepartmentId() {
        return departmentId;
    }
    public void setDepartmentId(Integer departmentId) {
        this.departmentId = departmentId;
    }


    @Override
    public String toString() {
        return "Employee [employeeId= " + employeeId + ", firtsName= " + firtsName + ", lastName= " + lastName
                + ", email= " + email + ", phoneNumber= " + phoneNumber + ", hireDate= " + hireDate + ", jobId= " + jobId
                + ", salary= " + salary + ", managerId= " + managerId + ", departmentId= " + departmentId + "]";
    }

}
