package now;

import now.DatabaseConnection;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class InvoiceSystem extends JFrame {
    private DefaultTableModel model;
    private JTable table;
    private JTextField nameField, priceField, qtyField;
    private JLabel totalLabel;
    private double total = 0.0;

    public InvoiceSystem() {
        setTitle("Invoice Generation");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(700, 500);
        setLayout(new BorderLayout());

        
        
        
        // Input Panel
        JPanel inputPanel = new JPanel(new GridLayout(2, 4, 10, 10));
        nameField = new JTextField();
        priceField = new JTextField();
        qtyField = new JTextField();
        JButton addBtn = new JButton("Add Item");

        inputPanel.add(new JLabel("Product Name"));
        inputPanel.add(new JLabel("Price"));
        inputPanel.add(new JLabel("Quantity"));
        inputPanel.add(new JLabel(""));

        inputPanel.add(nameField);
        inputPanel.add(priceField);
        inputPanel.add(qtyField);
        inputPanel.add(addBtn);

        // Table
        model = new DefaultTableModel(new Object[]{"Product", "Price", "Qty", "Total"}, 0);
        table = new JTable(model);

        // Bottom Panel
        JPanel bottom = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        totalLabel = new JLabel("Total: ₹0.0");
        JButton saveBtn = new JButton("Save Invoice");
        JButton viewBtn = new JButton("View Invoices");
        bottom.add(totalLabel);
        bottom.add(saveBtn);
        bottom.add(viewBtn);

        // Action: Add item
        addBtn.addActionListener(e -> {
            String name = nameField.getText();
            double price = Double.parseDouble(priceField.getText());
            int qty = Integer.parseInt(qtyField.getText());
            double lineTotal = price * qty;

            model.	addRow(new Object[]{name, price, qty, lineTotal});
            total += lineTotal;
            totalLabel.setText("Total : $" + total);

            nameField.setText("");
            priceField.setText("");
            qtyField.setText("");
            
        });

        // Action: Save invoice
        saveBtn.addActionListener(e -> saveInvoice());

        // Action: View invoices
        viewBtn.addActionListener(e -> new InvoiceView());

        add(inputPanel, BorderLayout.NORTH);
        add(new JScrollPane(table), BorderLayout.CENTER);
        add(bottom, BorderLayout.SOUTH);

        setVisible(true);
    }

    private void saveInvoice() {
        try (Connection con = DatabaseConnection.getConnection()) {
            PreparedStatement ps = con.prepareStatement("INSERT INTO invoices (total_amount) VALUES (?)", Statement.RETURN_GENERATED_KEYS);
            ps.setDouble(1, total);
            ps.executeUpdate();

            ResultSet keys = ps.getGeneratedKeys();
            int invoiceId = 0;
            if (keys.next()) invoiceId = keys.getInt(1);

            PreparedStatement itemPS = con.prepareStatement("INSERT INTO invoice_items (invoice_id, product_name, price, quantity) VALUES (?, ?, ?, ?)");
            for (int i = 0; i < model.getRowCount(); i++) {
                itemPS.setInt(1, invoiceId);
                itemPS.setString(2, model.getValueAt(i, 0).toString());
                itemPS.setDouble(3, (double) model.getValueAt(i, 1));
                itemPS.setInt(4, (int) model.getValueAt(i, 2));
                itemPS.addBatch();
            }

            itemPS.executeBatch();
            JOptionPane.showMessageDialog(this, "Invoice Saved!");
            model.setRowCount(0);
            total = 0;
            totalLabel.setText("Total: ₹0.0");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new InvoiceSystem();
    }
}
