package Firstwebsite;



import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

@WebServlet("/BookSearchServlet")
public class BookSearchServlet extends HttpServlet {

    private static final String URL = "jdbc:mysql://localhost:3306/librarydb";
    private static final String USER = "root";
    private static final String PASSWORD = "root@";

    // Inner class to represent a Book
    public static class Book {
        public String title;
        public String author;

        public Book(String title, String author) {
            this.title = title;
            this.author = author;
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String title = request.getParameter("title");
        String author = request.getParameter("author");

        List<Book> books = new ArrayList<>();

        try (Connection con = DriverManager.getConnection(URL, USER, PASSWORD);
             Statement stmt = con.createStatement()) {

            String query = "SELECT * FROM books WHERE 1=1";

            if (title != null && !title.isEmpty()) {
                query += " AND title LIKE '%" + title + "%'";
            }
            if (author != null && !author.isEmpty()) {
                query += " AND author LIKE '%" + author + "%'";
            }

            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                books.add(new Book(rs.getString("title"), rs.getString("author")));
            }
            System.out.println("Books retrieved: " + books.size()); // Debugging line

        } catch (SQLException e) {
            e.printStackTrace();
        }

        request.setAttribute("books", books);
        request.getRequestDispatcher("results.jsp").forward(request, response);
    }
}
