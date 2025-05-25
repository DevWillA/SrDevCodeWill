package com.sql.dao;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.sql.vo.Department;

public class DepartmentDao {

    public void saveDepartment(Department department) {

        var url = "jdbc:postgresql://localhost:5432/postgres";
        var user = "postgres";
        var pass = "admin123";

        try {
            var conn = DriverManager.getConnection(url, user, pass);

            var stmt = conn.createStatement();
            var sql = "INSERT INTO departments (department_id, department_name, location_id) "
                    + "VALUES (" + department.getDepartmentId() + ", '" + department.getDepartmentName() + "', "
                    + department.getLocationId() + ")";

            // System.out.println( "SQL: " + sql);
            stmt.execute(sql);

        } catch (SQLException e) {
            System.out.println("Error al guardar el departamento: " + e.getMessage());
        }

    }

    public Department findDepartmentById(Integer id) {

        var department = new Department();

        var url = "jdbc:postgresql://localhost:5432/postgres";
        var user = "postgres";
        var pass = "admin123";
        try (var conn = DriverManager.getConnection(url, user, pass);
                var stmt = conn.prepareStatement("Select * from departments where department_id = " + id);
                var rset = stmt.executeQuery();) {
            if (rset.next()) {
                department.setDepartmentId(rset.getInt("department_id"));
                department.setDepartmentName(rset.getString("department_name"));
                department.setLocationId(rset.getInt("location_id"));
            }
        } catch (SQLException e) {
            System.out.println("Error al encontrar el departamento: " + e.getMessage());
        }

        return department;
    }

    public List<Department> findAllDepartments() {
        var departments = new ArrayList<Department>();

        var url = "jdbc:postgresql://localhost:5432/postgres";
        var user = "postgres";
        var pass = "admin123";

        try (var conn = DriverManager.getConnection(url, user, pass);
                var stmt = conn.prepareStatement("Select * from departments");
                var rset = stmt.executeQuery();) {
            while (rset.next()) {
                var department = new Department();
                department.setDepartmentId(rset.getInt("department_id"));
                department.setDepartmentName(rset.getString("department_name"));
                department.setLocationId(rset.getInt("location_id"));
                departments.add(department);
            }
        } catch (SQLException e) {
            System.out.println("Error al encontrar los departamentos: " + e.getMessage());
        }
        return departments;
    }

    public void updateDepartment(Integer id, Department department) {
        var url = "jdbc:postgresql://localhost:5432/postgres";
        var user = "postgres";
        var pass = "admin123";

        try (var conn = DriverManager.getConnection(url, user, pass);
                var stmt = conn
                        .prepareStatement("UPDATE departments SET department_name = '" + department.getDepartmentName()
                                + "', location_id = " + department.getLocationId() + " WHERE department_id = " + id)) {
            stmt.execute();
            System.out.println("Departamento actualizado con id " + id);
        } catch (SQLException e) {
            System.out.println("Error al actualizar el departamento: " + e.getMessage());
        }
    }

    public void deleteDepartment(Integer id) {
        var url = "jdbc:postgresql://localhost:5432/postgres";
        var user = "postgres";
        var pass = "admin123";

        try (var conn = DriverManager.getConnection(url, user, pass);
                var stmt = conn.prepareStatement("DELETE FROM departments WHERE department_id = " + id)) {
            stmt.execute();
            System.out.println("Departamento eliminado con id " + id);
        } catch (SQLException e) {
            System.out.println("Error al eliminar el departamento: " + e.getMessage());
        }
    }
}
