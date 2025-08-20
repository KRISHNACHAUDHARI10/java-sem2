package today;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.SQLException;

public class Connections {
    public static void main(String[] args) {

        // ✅ Declare variables FIRST
        String jdbcUrl = "jdbc:mysql://localhost:3306/user?useSSL=false&serverTimezone=UTC";
        String username = "root";
        String password = "root@";

        // ✅ Now use them in try-with-resources
        try (
            Connection connection = DriverManager.getConnection(jdbcUrl, username, password);
            Statement statement = connection.createStatement()
            		
        ) {
            System.out.println("Connection successful!");

        } catch (SQLException e) {
            System.out.println("Connection failed:");
            e.printStackTrace();
        }
    }
}
