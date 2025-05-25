
package com.sql;

import java.time.LocalDate;

public class Main {

    public static void main(String[] args) {

        var employee = new com.sql.vo.Employee();
        employee.setFirtsName("Juan");
        employee.setLastName("Pérez");
        employee.setEmail("JP@dias.com");
        employee.setPhoneNumber("123456789");
        employee.setJobId(1);
        employee.setSalary(15000);
        employee.setManagerId("100");
        employee.setDepartmentId(1);
        employee.setHireDate(LocalDate.of(2025, 5, 5));

        //Save
        var employeeDao = new com.sql.dao.EmployeeDao();
        /// employeeDao.saveEmployee(employee);

        //Update
        //employee.setLastName("Pérez");
        //employee.setPhoneNumber("123456789");
        //employeeDao.updateEmployee(1, employee);

        //Delete
        //employeeDao.deleteEmployee(1);

        //FindAll
        //employeeDao.findAllEmployees().forEach(System.out::println);

        //FindById
        var employeeFound = employeeDao.findEmployeeById(206);
        System.out.println(employeeFound);

    }

    public static void testConnection() {

        // var employees = new ArrayList<Employee>();

        // var url = "jdbc:postgresql://localhost:5432/postgres";
        // var user = "postgres";
        // var pass = "admin123";

        // try {

        // Connection conn = DriverManager.getConnection(url, user, pass);
        // System.out.println("Conectado a la base de datos");

        // Statement stmt = conn.createStatement();
        // ResultSet rset = stmt.executeQuery("SELECT * FROM employees");

        // while (rset.next()) {

        // var employee = new Employee();
        // employee.setId(rset.getInt(Employeeid));

        // var id = rset.getInt(1);
        // var name = rset.getString(2);
        // var email = rset.getString(4);
        // var salary = rset.getDouble(8);
        // System.out.println("El empleado con id " + id + " es " + name + " con email "
        // + email + " y salario " + salary);
        // }

        // rset.close();
        // stmt.close();
        // conn.close();

        // }
    }
}