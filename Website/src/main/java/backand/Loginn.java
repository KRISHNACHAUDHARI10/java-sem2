package backand;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;


@WebServlet("/welcome")
public class Loginn extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		

         try {
        	 
         String name =  req.getParameter("name2");
         String email = req.getParameter("email2");
         
         
            Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/dataa","root","root@");
			String qry = "insert  into  dadalogin values(?,?)";
			PreparedStatement ps = con.prepareStatement(qry);
		    
		   ps.setString(1, name);
		   ps.setString(2, email);
		   ResultSet rs  = ps.executeQuery();

		
         
          } catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
       
     
		
		
		
		
	}
    
}
