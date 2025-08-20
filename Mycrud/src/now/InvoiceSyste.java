package now;

import java.awt.EventQueue;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.*;
import java.sql.*;

public class InvoiceSyste extends JFrame {

	private JPanel contentPane;
	private JTextField productField;
	private JTextField priceField;
	private JTextField quantityField;
	private JTable table;
	private DefaultTableModel model;
	private JLabel totalLabel;
	private double total = 0;

	public static void main(String[] args) {
		EventQueue.invokeLater(() -> {
			try {
				InvoiceSyste frame = new InvoiceSyste();
				frame.setVisible(true);
			} catch (Exception e) {
				e.printStackTrace();
			}
		});
	}

	public InvoiceSyste() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 700, 600);
		contentPane = new JPanel();
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblProduct = new JLabel("Product");
		lblProduct.setBounds(30, 30, 70, 20);
		contentPane.add(lblProduct);

		productField = new JTextField();
		productField.setBounds(100, 30, 150, 25);
		contentPane.add(productField);

		JLabel lblPrice = new JLabel("Price");
		lblPrice.setBounds(270, 30, 70, 20);
		contentPane.add(lblPrice);

		priceField = new JTextField();
		priceField.setBounds(320, 30, 100, 25);
		contentPane.add(priceField);

		JLabel lblQty = new JLabel("Quantity");
		lblQty.setBounds(440, 30, 70, 20);
		contentPane.add(lblQty);

		quantityField = new JTextField();
		quantityField.setBounds(510, 30, 100, 25);
		contentPane.add(quantityField);

		JButton btnAddItem = new JButton("Add Item");
		btnAddItem.setBounds(270, 70, 150, 25);
		contentPane.add(btnAddItem);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(30, 120, 620, 200);
		contentPane.add(scrollPane);

		model = new DefaultTableModel(new String[]{"Product", "Price", "Quantity", "Total"}, 0);
		table = new JTable(model);
		scrollPane.setViewportView(table);

		totalLabel = new JLabel("Total: ₹0.0");
		totalLabel.setBounds(30, 340, 200, 30);
		contentPane.add(totalLabel);

		JButton btnSave = new JButton("Generate Invoice");
		btnSave.setBounds(270, 340, 150, 30);
		contentPane.add(btnSave);

		JButton btnViewInvoices = new JButton("View Invoices");
		btnViewInvoices.setBounds(440, 340, 150, 30);
		contentPane.add(btnViewInvoices);

		JScrollPane invoiceScroll = new JScrollPane();
		invoiceScroll.setBounds(30, 390, 620, 150);
		contentPane.add(invoiceScroll);

		JTable invoiceTable = new JTable();
		invoiceScroll.setViewportView(invoiceTable);

		// Add Item Button
		btnAddItem.addActionListener(e -> {
			String product = productField.getText();
			double price = Double.parseDouble(priceField.getText());
			int qty = Integer.parseInt(quantityField.getText());
			double subtotal = price * qty;
			model.addRow(new Object[]{product, price, qty, subtotal});
			total += subtotal;
			totalLabel.setText("Total: ₹" + total);
		});

		// Save Invoice Button
		btnSave.addActionListener(e -> {
			try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/shopdb", "root", "root@")) {
				PreparedStatement ps1 = con.prepareStatement("INSERT INTO invoices (total) VALUES (?)", Statement.RETURN_GENERATED_KEYS);
				ps1.setDouble(1, total);
				ps1.executeUpdate();
				ResultSet rs = ps1.getGeneratedKeys();
				int invoiceId = 0;
				if (rs.next()) {
					invoiceId = rs.getInt(1);
				}
				PreparedStatement ps2 = con.prepareStatement("INSERT INTO invoice_items (invoice_id, product_name, price, quantity) VALUES (?,?,?,?)");
				for (int i = 0; i < model.getRowCount(); i++) {
					ps2.setInt(1, invoiceId);
					ps2.setString(2, model.getValueAt(i, 0).toString());
					ps2.setDouble(3, Double.parseDouble(model.getValueAt(i, 1).toString()));
					ps2.setInt(4, Integer.parseInt(model.getValueAt(i, 2).toString()));
					ps2.executeUpdate();
				}
				JOptionPane.showMessageDialog(this, "Invoice Saved Successfully!");
				model.setRowCount(0);
				total = 0;
				totalLabel.setText("Total: ₹0.0");
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		});

		// View Invoices Button
		btnViewInvoices.addActionListener(e -> {
			try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/shopdb", "root", "root@")) {
				Statement st = con.createStatement();
				ResultSet rs = st.executeQuery("SELECT * FROM invoices");
				DefaultTableModel invoiceModel = new DefaultTableModel(new String[]{"Invoice ID", "Total", "Date"}, 0);
				while (rs.next()) {
					invoiceModel.addRow(new Object[]{
						rs.getInt("invoice_id"),
						rs.getDouble("total"),
						rs.getTimestamp("date")
					});
				}
				invoiceTable.setModel(invoiceModel);
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		});
	}
}
