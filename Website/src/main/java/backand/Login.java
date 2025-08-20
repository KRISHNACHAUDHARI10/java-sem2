package backand;
//Question = 3
import java.io.IOException;
import java.io.PrintWriter;
import java.net.http.HttpRequest;
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


@WebServlet("/Loginform")
public class Login extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		     PrintWriter out = resp.getWriter();
		 try {
			 String   myemail = req.getParameter("email1");
			 String mypassword = req.getParameter("pass1");
			  Class.forName("com.mysql.cj.jdbc.Driver");
			  Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/login","root","root@");
			  String qry = "select * from users where email=? and password=?";
			  PreparedStatement ps = con.prepareStatement(qry);
			  
		     
			   ps.setString(1, myemail);
		       ps.setString(2,mypassword);
		     
		     
		     ResultSet rs = ps.executeQuery();
		     if(rs.next()) {
		    	  HttpSession session =  req.getSession();
				  session.setAttribute("session_name",rs.getString("name"));
		    	  resp.setContentType("text/html");
		    	  
		    	  RequestDispatcher rsdp = req.getRequestDispatcher("/profile.jsp ");
		    	  rsdp.include(req, resp);
		    	  
		     }
		     
		     else {
		    	  resp.setContentType("text/html");
		    	  RequestDispatcher rsdp = req.getRequestDispatcher("/Login.jsp");
		    	  out.print("<h3 style='color:red;'>Invalid email or password. Please try again.</h3>");
		    	  rsdp.include(req, resp);
		    	  }
		     
	}
		catch(SQLException e) {
			 e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
        
	
	
}
