package ch1;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;

public class AttendanceSystem {
    public static void main(String[] args) {
        new AttendanceGUI();
    }
}

class AttendanceGUI extends JFrame {
	
    private JComboBox<String> studentIdBox;
    private JTextField dateField;
    private JComboBox<String> statusBox;
    private JButton submitButton;
    private JButton viewButton;
    
    public AttendanceGUI() {
        // Frame settings
        setTitle("Student Attendance System");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(4, 2));

        // Components
        add(new JLabel("Student ID:"));
        studentIdBox = new JComboBox<>(getStudentIdsFromDatabase());
        add(studentIdBox);

        add(new JLabel("Date (YYYY-MM-DD):"));
        dateField = new JTextField(LocalDate.now().toString());
        add(dateField);

        add(new JLabel("Attendance Status:"));
        statusBox = new JComboBox<>(new String[]{"Present", "Absent"});
        add(statusBox);

        submitButton = new JButton("Submit Attendance");
        submitButton.addActionListener(e -> saveAttendance());
        add(submitButton);

        viewButton = new JButton("View Attendance");
        viewButton.addActionListener(e -> viewAttendance());
        add(viewButton);

        // Display GUI
        setVisible(true);
    }

    private String[] getStudentIdsFromDatabase() {
        ArrayList<String> studentList = new ArrayList<>();
        String url = "jdbc:mysql://localhost:3306/yourDatabase";
        String user = "yourUsername";
        String password = "yourPassword";
        String query = "SELECT student_id FROM students"; 

        try (Connection connection = DriverManager.getConnection(url, user, password);
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(query)) {

            while (resultSet.next()) {
                studentList.add(resultSet.getString("student_id"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return studentList.toArray(new String[0]);
    }

    private void saveAttendance() {
        String studentId = (String) studentIdBox.getSelectedItem();
        String date = dateField.getText();
        String status = (String) statusBox.getSelectedItem();
        String url = "jdbc:mysql://localhost:3306/yourDatabase";
        String user = "yourUsername";
        String password = "yourPassword";
        String query = "INSERT INTO attendance (student_id, date, status) VALUES (?, ?, ?)";

        try (Connection connection = DriverManager.getConnection(url, user, password);
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            preparedStatement.setString(1, studentId);
            preparedStatement.setString(2, date);
            preparedStatement.setString(3, status);
            preparedStatement.executeUpdate();
            JOptionPane.showMessageDialog(this, "Attendance recorded successfully!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void viewAttendance() {
        String studentId = (String) studentIdBox.getSelectedItem();
        String url = "jdbc:mysql://localhost:3306/yourDatabase";
        String user = "yourUsername";
        String password = "yourPassword";
        String query = "SELECT date, status FROM attendance WHERE student_id = ?";
        StringBuilder result = new StringBuilder("Attendance Records:\n");

        try (Connection connection = DriverManager.getConnection(url, user, password);
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            preparedStatement.setString(1, studentId);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                result.append("Date: ").append(resultSet.getString("date"))
                      .append(", Status: ").append(resultSet.getString("status")).append("\n");
            }
            JOptionPane.showMessageDialog(this, result.toString());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}