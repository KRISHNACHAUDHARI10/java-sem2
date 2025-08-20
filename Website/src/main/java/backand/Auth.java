package backand;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
@WebServlet("/regester")
public class Auth  extends HttpServlet {

	
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	   PrintWriter  out = resp.getWriter();
          try{
        	    String name = req.getParameter("name1");
        	    String email = req.getParameter("email1");
        	    String course = req.getParameter("course1");
        	    String rollno = req.getParameter("rollno1");
        	    
               Class.forName("com.mysql.cj.jdbc.Driver");
        	   Connection con  = DriverManager.getConnection("jdbc:mysql://localhost:3306/auth","root","root@");
        	   String qry = "insert into user values(?,?,?,?)";
        	   PreparedStatement ps = con.prepareStatement(qry); 
        	  ps.setString(1, name); 
        	  ps.setString(2, email);
        	  ps.setString(3, course);
        	  ps.setString(4, rollno);
        	  int count = ps.executeUpdate();
        	  if(count> 0) {
        		  resp.setContentType("text/html");
        		  out.print("<h3>Success</h3>");
        		  RequestDispatcher rsdp = req.getRequestDispatcher(qry);
        		  rsdp.include(req, resp);
        	  }
        	  else {
        		  resp.setContentType("text/html");
        		  out.print("<h3>register not success</h3>");
        		  RequestDispatcher rsdp = req.getRequestDispatcher("/Authentication.jsp");
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
