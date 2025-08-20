package Schoole;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class LibraryInventory extends JFrame {

    private JPanel contentPane;
    private JTextField titleField, authorField, isbnField, qtyField, searchField;
    private JTable table;
    private DefaultTableModel model;
    private Connection con;

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                LibraryInventory frame = new LibraryInventory();
                frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    public LibraryInventory() {
        setTitle("Library Book Inventory");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 800, 500);
        contentPane = new JPanel();
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel lblTitle = new JLabel("Title:");
        lblTitle.setBounds(30, 20, 80, 25);
        contentPane.add(lblTitle);

        titleField = new JTextField();
        titleField.setBounds(90, 20, 150, 25);
        contentPane.add(titleField);

        JLabel lblAuthor = new JLabel("Author:");
        lblAuthor.setBounds(30, 60, 80, 25);
        contentPane.add(lblAuthor);

        authorField = new JTextField();
        authorField.setBounds(90, 60, 150, 25);
        contentPane.add(authorField);

        JLabel lblISBN = new JLabel("ISBN:");
        lblISBN.setBounds(30, 100, 80, 25);
        contentPane.add(lblISBN);

        isbnField = new JTextField();
        isbnField.setBounds(90, 100, 150, 25);
        contentPane.add(isbnField);

        JLabel lblQty = new JLabel("Quantity:");
        lblQty.setBounds(30, 140, 80, 25);
        contentPane.add(lblQty);

        qtyField = new JTextField();
        qtyField.setBounds(90, 140, 150, 25);
        contentPane.add(qtyField);

        JButton btnAdd = new JButton("Add");
        btnAdd.setBounds(270, 20, 90, 25);
        contentPane.add(btnAdd);

        JButton btnUpdate = new JButton("Update");
        btnUpdate.setBounds(270, 60, 90, 25);
        contentPane.add(btnUpdate);

        JButton btnDelete = new JButton("Delete");
        btnDelete.setBounds(270, 100, 90, 25);
        contentPane.add(btnDelete);

        searchField = new JTextField();
        searchField.setBounds(400, 20, 180, 25);
        contentPane.add(searchField);

        JButton btnSearch = new JButton("Search");
        btnSearch.setBounds(590, 20, 90, 25);
        contentPane.add(btnSearch);

        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(30, 200, 720, 230);
        contentPane.add(scrollPane);

        table = new JTable();
        model = new DefaultTableModel(new Object[]{"ID", "Title", "Author", "ISBN", "Quantity"}, 0);
        table.setModel(model);
        scrollPane.setViewportView(table);

        // DB Connection
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/librarydb", "root", "root@");
            loadBooks();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "DB Error: " + e.getMessage());
        }

        // Add book
        btnAdd.addActionListener(e -> {
            try {
                String title = titleField.getText();
                String author = authorField.getText();
                String isbn = isbnField.getText();
                int qty = Integer.parseInt(qtyField.getText());

                String sql = "INSERT INTO books (title, author, isbn, quantity) VALUES (?, ?, ?, ?)";
                PreparedStatement ps = con.prepareStatement(sql);
                ps.setString(1, title);
                ps.setString(2, author);
                ps.setString(3, isbn);
                ps.setInt(4, qty);
                ps.executeUpdate();
                loadBooks();
                clearFields();
                JOptionPane.showMessageDialog(null, "Book added successfully!");
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "Insert Error: " + ex.getMessage());
            }
        });

        // Table click to load data
        table.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                int i = table.getSelectedRow();
                titleField.setText(model.getValueAt(i, 1).toString());
                authorField.setText(model.getValueAt(i, 2).toString());
                isbnField.setText(model.getValueAt(i, 3).toString());
                qtyField.setText(model.getValueAt(i, 4).toString());
            }
        });

        // Update book
        btnUpdate.addActionListener(e -> {
            int i = table.getSelectedRow();
            if (i >= 0) {
                try {
                    int id = Integer.parseInt(model.getValueAt(i, 0).toString());
                    String title = titleField.getText();
                    String author = authorField.getText();
                    String isbn = isbnField.getText();
                    int qty = Integer.parseInt(qtyField.getText());

                    String sql = "UPDATE books SET title=?, author=?, isbn=?, quantity=? WHERE id=?";
                    PreparedStatement ps = con.prepareStatement(sql);
                    ps.setString(1, title);
                    ps.setString(2, author);
                    ps.setString(3, isbn);
                    ps.setInt(4, qty);
                    ps.setInt(5, id);
                    ps.executeUpdate();
                    loadBooks();
                    clearFields();
                    JOptionPane.showMessageDialog(null, "Book updated successfully!");
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "Update Error: " + ex.getMessage());
                }
            }
        });

        // Delete book
        btnDelete.addActionListener(e -> {
            int i = table.getSelectedRow();
            if (i >= 0) {
                try {
                    int id = Integer.parseInt(model.getValueAt(i, 0).toString());
                    String sql = "DELETE FROM books WHERE id=?";
                    PreparedStatement ps = con.prepareStatement(sql);
                    ps.setInt(1, id);
                    ps.executeUpdate();
                    loadBooks();
                    clearFields();
                    JOptionPane.showMessageDialog(null, "Book deleted successfully!");
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "Delete Error: " + ex.getMessage());
                }
            }
        });

        // Search book
        btnSearch.addActionListener(e -> {
            String keyword = searchField.getText();
            searchBooks(keyword);
        });
    }

    // Load all books
    private void loadBooks() {
        model.setRowCount(0);
        try {
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM books");
            while (rs.next()) {
                model.addRow(new Object[]{
                        rs.getInt("id"),
                        rs.getString("title"),
                        rs.getString("author"),
                        rs.getString("isbn"),
                        rs.getInt("quantity")
                });
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Load Error: " + e.getMessage());
        }
    }

    // Search books
    private void searchBooks(String keyword) {
        model.setRowCount(0);
        try {
            String sql = "SELECT * FROM books WHERE title LIKE ? OR author LIKE ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, "%" + keyword + "%");
            ps.setString(2, "%" + keyword + "%");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                model.addRow(new Object[]{
                        rs.getInt("id"),
                        rs.getString("title"),
                        rs.getString("author"),
                        rs.getString("isbn"),
                        rs.getInt("quantity")
                });
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Search Error: " + e.getMessage());
        }
    }

    private void clearFields() {
        titleField.setText("");
        authorField.setText("");
        isbnField.setText("");
        qtyField.setText("");
        searchField.setText("");
    }
}
