
package loginsucess;

import java.sql.*;

public class LogUse {

    public static boolean validuser(String username, String password) {
        String qry = "SELECT 1 FROM employes WHERE username = ? AND password = ?";

        try (
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Employe", "root", "root@");
            PreparedStatement stmt = con.prepareStatement(qry)
        ) {
            stmt.setString(1, username);
            stmt.setString(2, password);

            try (ResultSet rs = stmt.executeQuery()) {
                return rs.next(); // true if a record exists
            }

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}




