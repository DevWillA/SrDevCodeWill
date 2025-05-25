package com.sql.dao;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.sql.vo.Employee;

public class EmployeeDao {

    public void saveEmployee(Employee employee) {

        var url = "jdbc:postgresql://localhost:5432/postgres";
        var user = "postgres";
        var pass = "admin123";

        try {
            var conn = DriverManager.getConnection(url, user, pass);

            var stmt = conn.createStatement();

            var sql = "INSERT INTO employees (first_name, last_name, email, phone_number, hire_date, job_id, salary, manager_id, department_id) "
                    + "VALUES ('" + employee.getFirtsName() + "', '" + employee.getLastName() + "', '"
                    + employee.getEmail()
                    + "', '" + employee.getPhoneNumber() + "', '" + employee.getHireDate() + "', " + employee.getJobId()
                    + ", " + employee.getSalary() + ", " + employee.getManagerId() + ", " + employee.getDepartmentId()
                    + ")";

            // System.out.println( "SQL: " + sql);
            stmt.execute(sql);
            stmt.close();
            conn.close();

            System.out
                    .println("Empleado Guardado " + employee.getFirtsName() + " " + employee.getLastName() + " con id "
                            + employee.getEmployeeId());
        } catch (SQLException e) {
            System.out.println("Error al guardar el empleado: " + e.getMessage());
        }

    }

    public Employee findEmployeeById(Integer id) {
        var employee = new Employee();

        var url = "jdbc:postgresql://localhost:5432/postgres";
        var user = "postgres";
        var pass = "admin123";

        try (var conn = DriverManager.getConnection(url, user, pass);
                var stmt = conn.prepareStatement("Select * from employees where employee_id = " + id);
                var rset = stmt.executeQuery();) {
            if (rset.next()) {
                employee.setEmployeeId(rset.getInt("employee_id"));
                employee.setFirtsName(rset.getString("first_name"));
                employee.setLastName(rset.getString("last_name"));
                employee.setEmail(rset.getString("email"));
                employee.setPhoneNumber(rset.getString("phone_number"));
                employee.setHireDate(rset.getDate("hire_date").toLocalDate());
                employee.setJobId(rset.getInt("job_id"));
                employee.setSalary(rset.getInt("salary"));
                employee.setManagerId(rset.getString("manager_id"));
                employee.setDepartmentId(rset.getInt("department_id"));

                System.out.println("Empleado encontrado con id:  " + id);
                
            }
        } catch (SQLException e) {
            System.out.println("Error al buscar el empleado: " + e.getMessage());
        }

        return employee;
    }

    public void updateEmployee(Integer id, Employee employee) {
        var url = "jdbc:postgresql://localhost:5432/postgres";
        var user = "postgres";
        var pass = "admin123";

        try (var conn = DriverManager.getConnection(url, user, pass);
                var stmt = conn.createStatement()) {

            var sql = "UPDATE employees SET first_name = '" + employee.getFirtsName() + "', last_name = '"
                    + employee.getLastName()
                    + "', email = '" + employee.getEmail() + "', phone_number = '" + employee.getPhoneNumber()
                    + "', hire_date = '"
                    + employee.getHireDate() + "', job_id = " + employee.getJobId() + ", salary = "
                    + employee.getSalary()
                    + ", manager_id = " + employee.getManagerId() + ", department_id = " + employee.getDepartmentId()
                    + " WHERE employee_id = " + id;

            stmt.execute(sql);

            System.out.println(
                    "Empleado Actulizado " + employee.getFirtsName() + " " + employee.getLastName() + " con id "
                            + employee.getEmployeeId());
        } catch (SQLException e) {
            System.out.println("Error al actualizar el empleado: " + e.getMessage());
        }

    }

    public void deleteEmployee(int id) {
        var url = "jdbc:postgresql://localhost:5432/postgres";
        var user = "postgres";
        var pass = "admin123";

        try (var conn = DriverManager.getConnection(url, user, pass);
                var stmt = conn.prepareStatement("DELETE FROM employees WHERE employee_id = " + id)) {
            stmt.execute();
            System.out.println("Empleado eliminado con id " + id);
        } catch (SQLException e) {
            System.out.println("Error al eliminar el empleado: " + e.getMessage());
        }

    }

    public List<Employee> findAllEmployees() {
        var employees = new ArrayList<Employee>();

        var url = "jdbc:postgresql://localhost:5432/postgres";
        var user = "postgres";
        var pass = "admin123";

        try (var conn = DriverManager.getConnection(url, user, pass);
                var stmt = conn.prepareStatement("Select * from employees");
                var rset = stmt.executeQuery();) {
            while (rset.next()) {
                var employee = new Employee();
                employee.setEmployeeId(rset.getInt("employee_id"));
                employee.setFirtsName(rset.getString("first_name"));
                employee.setLastName(rset.getString("last_name"));
                employee.setEmail(rset.getString("email"));
                employee.setPhoneNumber(rset.getString("phone_number"));
                employee.setHireDate(rset.getDate("hire_date").toLocalDate());
                employee.setJobId(rset.getInt("job_id"));
                employee.setSalary(rset.getInt("salary"));
                employee.setManagerId(rset.getString("manager_id"));
                employee.setDepartmentId(rset.getInt("department_id"));

                employees.add(employee);
            }

            System.out.println("Empleados Listados ");
        } catch (SQLException e) {
            System.out.println("Error al Listar los empleado: " + e.getMessage());
        }

        return employees;
    }
}