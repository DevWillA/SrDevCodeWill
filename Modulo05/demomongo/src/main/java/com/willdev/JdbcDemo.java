package com.willdev;

import java.sql.DriverManager;
import java.sql.SQLException;

public class JdbcDemo {

    public void dataTest()

    {

        try (var conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres",
                "admin123");
                var stmt = conn.prepareStatement("SELECT * FROM Employees");) {
            var rset = stmt.executeQuery();
            while (rset.next()) {
                System.out.printf("Empleado %s tiene el is %d se encuentra en el departamento %d%n",
                        rset.getString("first_name"),
                        rset.getString("last_name"),
                        rset.getInt("employee_id"),
                        rset.getInt("department_id"));

            }

           

            rset.close();
        } catch (SQLException e) {
            System.err.println("Error al conectar");
        }
    }

}
