package now;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import java.awt.EventQueue;
import java.awt.event.*;
import java.sql.*;

public class ProductInventory extends JFrame {
	private JPanel contentPane;
	private JTextField txtProductID, txtProductName, txtQuantity, txtPrice;
	private JTable table;
	private JComboBox<String> comboCategory;

	public static void main(String[] args) {
		EventQueue.invokeLater(() -> {
			try {
				ProductInventory frame = new ProductInventory();
				frame.setVisible(true);
			} catch (Exception e) {
				e.printStackTrace();
			}
		});
	}

	public ProductInventory() {
		setTitle("Product Inventory System");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 750, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(10, 10, 10, 10));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblId = new JLabel("Product ID");
		lblId.setBounds(50, 30, 100, 25);
		contentPane.add(lblId);

		txtProductID = new JTextField();
		txtProductID.setBounds(160, 30, 150, 25);
		contentPane.add(txtProductID);

		JLabel lblName = new JLabel("Product Name");
		lblName.setBounds(50, 70, 100, 25);
		contentPane.add(lblName);

		txtProductName = new JTextField();
		txtProductName.setBounds(160, 70, 150, 25);
		contentPane.add(txtProductName);

		JLabel lblQuantity = new JLabel("Quantity");
		lblQuantity.setBounds(50, 110, 100, 25);
		contentPane.add(lblQuantity);

		txtQuantity = new JTextField();
		txtQuantity.setBounds(160, 110, 150, 25);
		contentPane.add(txtQuantity);

		JLabel lblPrice = new JLabel("Price");
		lblPrice.setBounds(50, 150, 100, 25);
		contentPane.add(lblPrice);

		txtPrice = new JTextField();
		txtPrice.setBounds(160, 150, 150, 25);
		contentPane.add(txtPrice);

		JLabel lblCategory = new JLabel("Category");
		lblCategory.setBounds(50, 190, 100, 25);
		contentPane.add(lblCategory);

		comboCategory = new JComboBox<>(new String[]{"Electronics", "Furniture", "Groceries", "Stationery", "Clothing"});
		comboCategory.setBounds(160, 190, 150, 25);
		contentPane.add(comboCategory);

		JButton btnAdd = new JButton("Add");
		btnAdd.setBounds(50, 240, 80, 30);
		contentPane.add(btnAdd);

		JButton btnUpdate = new JButton("Update");
		btnUpdate.setBounds(140, 240, 80, 30);
		contentPane.add(btnUpdate);

		JButton btnDelete = new JButton("Delete");
		btnDelete.setBounds(230, 240, 80, 30);
		contentPane.add(btnDelete);

		JButton btnView = new JButton("View All");
		btnView.setBounds(320, 240, 100, 30);
		contentPane.add(btnView);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(50, 290, 620, 250);
		contentPane.add(scrollPane);

		table = new JTable();
		scrollPane.setViewportView(table);

		// Add
		btnAdd.addActionListener(e -> {
			try {
				Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/InventoryDB", "root", "root@");
				String query = "INSERT INTO Product VALUES (?, ?, ?, ?, ?)";
				PreparedStatement ps = con.prepareStatement(query);
				ps.setString(1, txtProductID.getText());
				ps.setString(2, txtProductName.getText());
				ps.setInt(3, Integer.parseInt(txtQuantity.getText()));
				ps.setDouble(4, Double.parseDouble(txtPrice.getText()));
				ps.setString(5, comboCategory.getSelectedItem().toString());
				ps.executeUpdate();
				JOptionPane.showMessageDialog(null, "Product Added");
				ps.close(); con.close();
			} catch (Exception ex) {
				JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage());
			}
		});

		// Update
		btnUpdate.addActionListener(e -> {
			try {
				Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/InventoryDB", "root", "root@");
				String query = "UPDATE Product SET product_name=?, quantity=?, price=?, category=? WHERE product_id=?";
				PreparedStatement ps = con.prepareStatement(query);
				ps.setString(1, txtProductName.getText());
				ps.setInt(2, Integer.parseInt(txtQuantity.getText()));
				ps.setDouble(3, Double.parseDouble(txtPrice.getText()));
				ps.setString(4, comboCategory.getSelectedItem().toString());
				ps.setString(5, txtProductID.getText());
				ps.executeUpdate();
				JOptionPane.showMessageDialog(null, "Product Updated");
				ps.close(); con.close();
			} catch (Exception ex) {
				JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage());
			}
		});

		// Delete
		btnDelete.addActionListener(e -> {
			try {
				Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/InventoryDB", "root", "root@");
				String query = "DELETE FROM Product WHERE product_id=?";
				PreparedStatement ps = con.prepareStatement(query);
				ps.setString(1, txtProductID.getText());
				ps.executeUpdate();
				JOptionPane.showMessageDialog(null, "Product Deleted");
				ps.close(); con.close();
			} catch (Exception ex) {
				JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage());
			}
		});

		// View
		btnView.addActionListener(e -> {
			try {
				Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/InventoryDB", "root", "root@");
				Statement st = con.createStatement();
				ResultSet rs = st.executeQuery("SELECT * FROM Product");
				ResultSetMetaData rsmd = rs.getMetaData();
				DefaultTableModel model = (DefaultTableModel) table.getModel();
				int cols = rsmd.getColumnCount();
				String[] colName = new String[cols];
				for (int i = 0; i < cols; i++) colName[i] = rsmd.getColumnName(i + 1);
				model.setColumnIdentifiers(colName);
				model.setRowCount(0);
				while (rs.next()) {
					String[] row = new String[cols];
					for (int i = 0; i < cols; i++) row[i] = rs.getString(i + 1);
					model.addRow(row);
				}
				rs.close(); st.close(); con.close();
			} catch (Exception ex) {
				JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage());
			}
		});
	}

	
	
}
