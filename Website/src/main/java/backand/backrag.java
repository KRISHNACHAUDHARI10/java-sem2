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

@WebServlet("/Re")
public class backrag  extends HttpServlet{

	
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		 PrintWriter out = resp.getWriter();
		  try {
			
			  String myname =  req.getParameter("name1");
			  String myemail =  req.getParameter("email1");
			  String mypass =  req.getParameter("pass1");
			  String mygender =  req.getParameter("gende1");
			  
			  
			  Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Ragistration","root","root@");
			String qry =" insert into  users value(?,?,?,?)";
			PreparedStatement ps = con.prepareStatement(qry);
			ps.setString(1, myname);
			ps.setString(2,myemail );
			ps.setString(3, mypass);
			ps.setString(4,mygender);
			
			
			int count  = ps.executeUpdate();
			if(count  >0 ) {
				  resp.setContentType("text/html");
				  out.print("<h3>message succeessfully</h3>");
				  RequestDispatcher rsdp =  req.getRequestDispatcher("/Registrtion.jsp");
				  rsdp.include(req, resp);
				  
				  
			}
			else {
				resp.setContentType("text/html");
				out.print("<h3>message error</h3>");
				  RequestDispatcher rsdp =  req.getRequestDispatcher("/Registrtion.jsp");
				  rsdp.include(req, resp);
				  
			}
			
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
     
	
	
	
	
}
