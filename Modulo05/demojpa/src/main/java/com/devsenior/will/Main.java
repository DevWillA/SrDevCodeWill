package com.devsenior.will;

public class Main {
    public static void main(String[] args) {
        
        
        var dao = new com.devsenior.will.dao.EmployeeDao();
        dao.findAll().forEach(System.out::println);
    }
}