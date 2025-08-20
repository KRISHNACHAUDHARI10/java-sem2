package Ragister;


import java.sql.*;

public class DBConnection {
    public static Connection getConnection() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver"); // MySQL Driver
            return DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/your_database_name", // change this!
                "your_username",
                "your_password"
            );
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
