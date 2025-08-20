package Schoole;



import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class Invoicegenration extends JFrame {
    private JPanel contentPane;
    private JTextField nameField, productField, priceField, quantityField;
    private JTable table;
    private DefaultTableModel model;
    private JLabel totalLabel;
    private Connection con;
    private double totalAmount = 0;

    // Main method to run the application
    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
            	Invoicegenration frame = new Invoicegenration();
                frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    // Constructor to set up UI components and database connection
    public Invoicegenration() {
        setTitle("Invoice Generation System");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 750, 500);
        contentPane = new JPanel();
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel lblName = new JLabel("Customer Name:");
        lblName.setBounds(30, 20, 150, 25);
        contentPane.add(lblName);

        nameField = new JTextField();
        nameField.setBounds(150, 20, 150, 25);
        contentPane.add(nameField);

        JLabel lblProduct = new JLabel("Product Name:");
        lblProduct.setBounds(30, 60, 150, 25);
        contentPane.add(lblProduct);

        productField = new JTextField();
        productField.setBounds(150, 60, 150, 25);
        contentPane.add(productField);

        JLabel lblPrice = new JLabel("Price:");
        lblPrice.setBounds(30, 100, 150, 25);
        contentPane.add(lblPrice);

        priceField = new JTextField();
        priceField.setBounds(150, 100, 150, 25);
        contentPane.add(priceField);

        JLabel lblQuantity = new JLabel("Quantity:");
        lblQuantity.setBounds(30, 140, 150, 25);
        contentPane.add(lblQuantity);

        quantityField = new JTextField();
        quantityField.setBounds(150, 140, 150, 25);
        contentPane.add(quantityField);

        JButton btnAdd = new JButton("Add Product");
        btnAdd.setBounds(150, 180, 150, 25);
        contentPane.add(btnAdd);

        JButton btnGenerateInvoice = new JButton("Generate Invoice");
        btnGenerateInvoice.setBounds(150, 220, 150, 25);
        contentPane.add(btnGenerateInvoice);

        totalLabel = new JLabel("Total: ₹0");
        totalLabel.setBounds(30, 220, 150, 25);
        contentPane.add(totalLabel);

        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(30, 260, 670, 150);
        contentPane.add(scrollPane);

        table = new JTable();
        model = new DefaultTableModel(new Object[]{"Product", "Price", "Quantity", "Total"}, 0);
        table.setModel(model);
        scrollPane.setViewportView(table);

        // Database connection setup
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/shop_invoice_system", "root", "root@");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "DB Error: " + e.getMessage());
        }

        // Add product to the list of items in the invoice
        btnAdd.addActionListener(e -> {
            try {
                String product = productField.getText();
                double price = Double.parseDouble(priceField.getText());
                int quantity = Integer.parseInt(quantityField.getText());
                double total = price * quantity;
                
                model.addRow(new Object[]{product, price, quantity, total});
                totalAmount += total;
                totalLabel.setText("Total: ₹" + totalAmount);
                
                // Clear the fields for next entry
                productField.setText("");
                priceField.setText("");
                quantityField.setText("");
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(null, "Error: Invalid input.");
            }
        });

        // Generate and save the invoice to the database
        btnGenerateInvoice.addActionListener(e -> {
            try {
                String customerName = nameField.getText();
                if (customerName.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Please enter customer name.");
                    return;
                }

                // Insert the invoice data
                String sqlInvoice = "INSERT INTO invoices (customer_name, total_amount) VALUES (?, ?)";
                PreparedStatement psInvoice = con.prepareStatement(sqlInvoice, Statement.RETURN_GENERATED_KEYS);
                psInvoice.setString(1, customerName);
                psInvoice.setDouble(2, totalAmount);
                psInvoice.executeUpdate();

                // Get the generated invoice_id
                ResultSet rs = psInvoice.getGeneratedKeys();
                int invoiceId = 0;
                if (rs.next()) {
                    invoiceId = rs.getInt(1);
                }

                // Save each product in the invoice
                for (int i = 0; i < model.getRowCount(); i++) {
                    String product = (String) model.getValueAt(i, 0);
                    double price = (Double) model.getValueAt(i, 1);
                    int quantity = (Integer) model.getValueAt(i, 2);
                    double total = (Double) model.getValueAt(i, 3);
                    
                    String sqlItem = "INSERT INTO invoice_items (invoice_id, product_name, price, quantity, total) VALUES (?, ?, ?, ?, ?)";
                    PreparedStatement psItem = con.prepareStatement(sqlItem);
                    psItem.setInt(1, invoiceId);
                    psItem.setString(2, product);
                    psItem.setDouble(3, price);
                    psItem.setInt(4, quantity);
                    psItem.setDouble(5, total);
                    psItem.executeUpdate();
                }

                JOptionPane.showMessageDialog(null, "Invoice generated successfully!");
                clearFields();
                model.setRowCount(0);
                totalAmount = 0;
                totalLabel.setText("Total: ₹0");
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage());
            }
        });
    }

    // Helper method to clear all input fields
    private void clearFields() {
        nameField.setText("");
        productField.setText("");
        priceField.setText("");
        quantityField.setText("");
    }
}
