package Cscorner;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

@WebServlet("/loginservlet")
public class LgoinServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        String name = request.getParameter("txtname");
        String pass = request.getParameter("txtpass"); // fixed: removed space

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/loginn", "root", "root@"
            );

            PreparedStatement ps = con.prepareStatement(
                "SELECT uname FROM man WHERE uname = ? AND password = ?"
            );
            ps.setString(1, name);
            ps.setString(2, pass);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                RequestDispatcher rd = request.getRequestDispatcher("welcome.jsp");
                rd.forward(request, response);
            } else {
                out.println("<font color='red' size='5'>Login Failed!!<br>");
                out.println("<a href='login.jsp'>Try Again</a>");
            }

            rs.close();
            ps.close();
            con.close();

        } catch (Exception e) {
            out.println("Error: " + e.getMessage());
        }
    }
}
