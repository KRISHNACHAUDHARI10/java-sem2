package Schoole;



import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import java.awt.EventQueue;
import java.awt.event.*;
import java.sql.*;

public class Employees extends JFrame {
    private JPanel contentPane;
    private JTextField idField, nameField, deptField, salaryField;
    private JTable table;
    private DefaultTableModel model;
    private JLabel totalSalaryLabel;
    private Connection con;

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                Employees frame = new Employees();
                frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    public Employees() {
        setTitle("Employee Management System");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 750, 500);
        contentPane = new JPanel();
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel lblId = new JLabel("Emp ID:");
        lblId.setBounds(30, 20, 80, 25);
        contentPane.add(lblId);

        idField = new JTextField();
        idField.setBounds(100, 20, 130, 25);
        contentPane.add(idField);

        JLabel lblName = new JLabel("Name:");
        lblName.setBounds(30, 60, 80, 25);
        contentPane.add(lblName);

        nameField = new JTextField();
        nameField.setBounds(100, 60, 130, 25);
        contentPane.add(nameField);

        JLabel lblDept = new JLabel("Department:");
        lblDept.setBounds(30, 100, 80, 25);
        contentPane.add(lblDept);

        deptField = new JTextField();
        deptField.setBounds(100, 100, 130, 25);
        contentPane.add(deptField);

        JLabel lblSalary = new JLabel("Salary:");
        lblSalary.setBounds(30, 140, 80, 25);
        contentPane.add(lblSalary);

        salaryField = new JTextField();
        salaryField.setBounds(100, 140, 130, 25);
        contentPane.add(salaryField);

        JButton btnAdd = new JButton("Add");
        btnAdd.setBounds(250, 20, 90, 25);
        contentPane.add(btnAdd);

        JButton btnUpdate = new JButton("Update");
        btnUpdate.setBounds(250, 60, 90, 25);
        contentPane.add(btnUpdate);

        JButton btnDelete = new JButton("Delete");
        btnDelete.setBounds(250, 100, 90, 25);
        contentPane.add(btnDelete);

        JButton btnSalary = new JButton("Total Salary");
        btnSalary.setBounds(250, 140, 120, 25);
        contentPane.add(btnSalary);

        totalSalaryLabel = new JLabel("Total: ₹0");
        totalSalaryLabel.setBounds(390, 140, 200, 25);
        contentPane.add(totalSalaryLabel);

        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(30, 200, 670, 230);
        contentPane.add(scrollPane);

        table = new JTable();
        model = new DefaultTableModel(new Object[]{"ID", "Name", "Dept", "Salary"}, 0);
        table.setModel(model);
        scrollPane.setViewportView(table);

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/studentcolage", "root", "root@");
            loadEmployees();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "DB Error: " + e.getMessage());
        }

        btnAdd.addActionListener(e -> {
            try {
                String id = idField.getText();
                String name = nameField.getText();
                String dept = deptField.getText();
                String salary = salaryField.getText();

                String sql = "INSERT INTO employees (emp_id, name, dept, salary) VALUES (?, ?, ?, ?)";
                PreparedStatement ps = con.prepareStatement(sql);
                ps.setString(1, id);
                ps.setString(2, name);
                ps.setString(3, dept);
                ps.setDouble(4, Double.parseDouble(salary));
                ps.executeUpdate();
                loadEmployees();
                clearFields();
                JOptionPane.showMessageDialog(null, "Employee added successfully.");
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "Insert Error: " + ex.getMessage());
            }
        });

        table.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                int i = table.getSelectedRow();
                idField.setText(model.getValueAt(i, 0).toString());
                nameField.setText(model.getValueAt(i, 1).toString());
                deptField.setText(model.getValueAt(i, 2).toString());
                salaryField.setText(model.getValueAt(i, 3).toString());
            }
        });

        btnUpdate.addActionListener(e -> {
            int i = table.getSelectedRow();
            if (i >= 0) {
                try {
                    String id = idField.getText();
                    String name = nameField.getText();
                    String dept = deptField.getText();
                    String salary = salaryField.getText();

                    String sql = "UPDATE employees SET name=?, dept=?, salary=? WHERE emp_id=?";
                    PreparedStatement ps = con.prepareStatement(sql);
                    ps.setString(1, name);
                    ps.setString(2, dept);
                    ps.setDouble(3, Double.parseDouble(salary));
                    ps.setString(4, id);
                    ps.executeUpdate();
                    loadEmployees();
                    clearFields();
                    JOptionPane.showMessageDialog(null, "Employee updated successfully.");
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "Update Error: " + ex.getMessage());
                }
            }
        });

        btnDelete.addActionListener(e -> {
            int i = table.getSelectedRow();
            if (i >= 0) {
                try {
                    String id = model.getValueAt(i, 0).toString();
                    String sql = "DELETE FROM employees WHERE emp_id=?";
                    PreparedStatement ps = con.prepareStatement(sql);
                    ps.setString(1, id);
                    ps.executeUpdate();
                    loadEmployees();
                    clearFields();
                    JOptionPane.showMessageDialog(null, "Employee deleted successfully.");
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "Delete Error: " + ex.getMessage());
                }
            }
        });

        btnSalary.addActionListener(e -> {
            try {
                String sql = "SELECT SUM(salary) FROM employees";
                PreparedStatement ps = con.prepareStatement(sql);
                ResultSet rs = ps.executeQuery();
                if (rs.next()) {
                    double total = rs.getDouble(1);
                    totalSalaryLabel.setText("Total: ₹" + total);
                }
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "Salary Calc Error: " + ex.getMessage());
            }
        });
    }

    private void loadEmployees() {
        model.setRowCount(0);
        try {
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM employees");
            while (rs.next()) {
                model.addRow(new Object[]{
                        rs.getString("emp_id"),
                        rs.getString("name"),
                        rs.getString("dept"),
                        rs.getDouble("salary")
                });
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Load Error: " + e.getMessage());
        }
    }

    private void clearFields() {
        idField.setText("");
        nameField.setText("");
        deptField.setText("");
        salaryField.setText("");
    }
}
