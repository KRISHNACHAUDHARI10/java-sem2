package Ragister;

import java.sql.*;


public class UserDAO {

    public static boolean validateUser(String username, String password) {
    	
        String qry = "SELECT 1 FROM loginusers WHERE username = ? AND password = ?";

        try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/userdb", "root", "root@");
             PreparedStatement stmt = con.prepareStatement(qry)) 
        
        {
            
            stmt.setString(1, username);
            stmt.setString(2, password);

            try (ResultSet rs = stmt.executeQuery()) {
                return rs.next(); 
            }

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        
        }
        
    }
}
