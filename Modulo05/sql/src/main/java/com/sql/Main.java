
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Main {
    public static void main(String[] args) {
        var url = "jdbc:postgresql://localhost:5432/postgres";
        var user = "postgres";
        var pass = "admin123";

        try (var connection = java.sql.DriverManager.getConnection(url, user, pass)) {
            Connection conn = DriverManager.getConnection(url, user, pass);
            
            Statement stmt = conn.createStatement();
            ResultSet rset = stmt.executeQuery("SELECT * FROM employees");

            while (rset.next()) {
                var id = rset.getInt(1);
                var name = rset.getString(2);
                var email = rset.getString(4);
                var salary = rset.getDouble(8);
                System.out.println("El empleado con id " + id + " es " + name + " con email " + email + " y salario " + salary);
            }

            rset.close();
            stmt.close();
            conn.close();

        } catch (java.sql.SQLException e) {
            System.out.println("Erro al conectar con la base de datos: " + e.getMessage());
        }
    }
}