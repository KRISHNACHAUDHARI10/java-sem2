package Schoole;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.EventQueue;
import java.awt.event.*;
import java.sql.*;

public class Students extends JFrame {

	private JPanel contentPane;
	private JTextField nameField, rollField, courseField;
	private JTable table;
	private DefaultTableModel model;
	private Connection con;

	public static void main(String[] args) {
		EventQueue.invokeLater(() -> {
			try {
				Students frame = new Students();
				frame.setVisible(true);
			} catch (Exception e) {
				e.printStackTrace();
			}
		});
	}

	public Students() {
		setTitle("Student Management System");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 700, 450);
		contentPane = new JPanel();
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblName = new JLabel("Name:");
		lblName.setBounds(30, 20, 80, 25);
		contentPane.add(lblName);

		nameField = new JTextField();
		nameField.setBounds(88, 20, 130, 25);
		contentPane.add(nameField);

		JLabel lblRoll = new JLabel("Roll No:");
		lblRoll.setBounds(30, 69, 80, 25);
		contentPane.add(lblRoll);

		rollField = new JTextField();
		rollField.setBounds(88, 69, 130, 25);
		contentPane.add(rollField);

		JLabel lblCourse = new JLabel("Course:");
		lblCourse.setBounds(30, 111, 80, 25);
		contentPane.add(lblCourse);

		courseField = new JTextField();
		courseField.setBounds(88, 111, 120, 25);
		contentPane.add(courseField);

		JButton btnAdd = new JButton("Add");
		btnAdd.setBounds(47, 146, 90, 25);
		contentPane.add(btnAdd);

		JButton btnUpdate = new JButton("Update");
		btnUpdate.setBounds(147, 146, 90, 25);
		contentPane.add(btnUpdate);

		JButton btnDelete = new JButton("Delete");
		btnDelete.setBounds(275, 146, 90, 25);
		contentPane.add(btnDelete);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(30, 192, 640, 188);
		contentPane.add(scrollPane);

		table = new JTable();
		model = new DefaultTableModel(new Object[]{"ID", "Name", "Roll No", "Course"}, 0);
		table.setModel(model);
		scrollPane.setViewportView(table);

		// DB Connection
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/studentcolage", "root", "root@");
			loadStudents();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "DB Error: " + e.getMessage());
		}

		// Add button action
		btnAdd.addActionListener(e -> {
			try {
				String name = nameField.getText();
				String roll = rollField.getText();
				String course = courseField.getText();

				String sql = "INSERT INTO students (name, roll, course) VALUES (?, ?, ?)";
				PreparedStatement ps = con.prepareStatement(sql);
				ps.setString(1, name);
				ps.setString(2, roll);
				ps.setString(3, course);
				ps.executeUpdate();
				loadStudents();
				clearFields();
				JOptionPane.showMessageDialog(null, "Student added successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
			} catch (Exception ex) {
				JOptionPane.showMessageDialog(null, "Insert Error: " + ex.getMessage());
			}
		});

		// Table click to populate fields
		table.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				int i = table.getSelectedRow();
				nameField.setText(model.getValueAt(i, 1).toString());
				rollField.setText(model.getValueAt(i, 2).toString());
				courseField.setText(model.getValueAt(i, 3).toString());
			}
		});

		// Update button action
		btnUpdate.addActionListener(e -> {
			int i = table.getSelectedRow();
			if (i >= 0) {
				try {
					int id = Integer.parseInt(model.getValueAt(i, 0).toString());
					String name = nameField.getText();
					String roll = rollField.getText();
					String course = courseField.getText();

					String sql = "UPDATE students SET name=?, roll=?, course=? WHERE id=?";
					PreparedStatement ps = con.prepareStatement(sql);
					ps.setString(1, name);
					ps.setString(2, roll);
					ps.setString(3, course);
					ps.setInt(4, id);
					ps.executeUpdate();
					loadStudents();
					clearFields();
					JOptionPane.showMessageDialog(null, "Student updated successfully!", "Updated", JOptionPane.INFORMATION_MESSAGE);
				} catch (Exception ex) {
					JOptionPane.showMessageDialog(null, "Update Error: " + ex.getMessage());
				}
			}
		});

		// Delete button action
		btnDelete.addActionListener(e -> {
			int i = table.getSelectedRow();
			if (i >= 0) {
				try {
					int id = Integer.parseInt(model.getValueAt(i, 0).toString());
					String sql = "DELETE FROM students WHERE id=?";
					PreparedStatement ps = con.prepareStatement(sql);
					ps.setInt(1, id);
					ps.executeUpdate();
					loadStudents();
					clearFields();
					JOptionPane.showMessageDialog(null, "Student deleted successfully!", "Deleted", JOptionPane.INFORMATION_MESSAGE);
				} catch (Exception ex) {
					JOptionPane.showMessageDialog(null, "Delete Error: " + ex.getMessage());
				}
			}
		});
	}

	// Load all students from DB
	private void loadStudents() {
		model.setRowCount(0);
		try {
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM students");
			while (rs.next()) {
				model.addRow(new Object[]{
						rs.getInt("id"),
						rs.getString("name"),
						rs.getString("roll"),
						rs.getString("course")
				});
			}
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Load Error: " + e.getMessage());
		}
	}

	private void clearFields() {
		nameField.setText("");
		rollField.setText("");
		courseField.setText("");
	}
}
