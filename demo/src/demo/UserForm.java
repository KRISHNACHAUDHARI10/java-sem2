package demo;



import java.awt.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.event.*;
import java.sql.*;

public class UserForm extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextField nameField, ageField, mobileField, emailField, usernameField, addressField;
    private JPasswordField passwordField;
    private final ButtonGroup genderGroup = new ButtonGroup();
    private JRadioButton maleBtn, femaleBtn;

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                UserForm frame = new UserForm();
                frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    public UserForm() {
        setTitle("User Registration Form");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 650, 520);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(10, 10, 10, 10));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel lblTitle = new JLabel("Register Form");
        lblTitle.setFont(new Font("Tahoma", Font.BOLD, 18));
        lblTitle.setBounds(250, 10, 150, 30);
        contentPane.add(lblTitle);

        JLabel lblName = new JLabel("Name");
        lblName.setFont(new Font("Tahoma", Font.BOLD, 14));
        lblName.setBounds(50, 60, 100, 25);
        contentPane.add(lblName);

        nameField = new JTextField();
        nameField.setBounds(180, 60, 180, 25);
        contentPane.add(nameField);

        JLabel lblAddress = new JLabel("Address");
        lblAddress.setFont(new Font("Tahoma", Font.BOLD, 14));
        lblAddress.setBounds(50, 100, 100, 25);
        contentPane.add(lblAddress);

        addressField = new JTextField();
        addressField.setBounds(180, 100, 180, 25);
        contentPane.add(addressField);

        JLabel lblGender = new JLabel("Gender");
        lblGender.setFont(new Font("Tahoma", Font.BOLD, 14));
        lblGender.setBounds(50, 140, 100, 25);
        contentPane.add(lblGender);

        maleBtn = new JRadioButton("Male");
        genderGroup.add(maleBtn);
        maleBtn.setBounds(180, 140, 80, 25);
        contentPane.add(maleBtn);

        femaleBtn = new JRadioButton("Female");
        genderGroup.add(femaleBtn);
        femaleBtn.setBounds(270, 140, 90, 25);
        contentPane.add(femaleBtn);

        JLabel lblAge = new JLabel("Age");
        lblAge.setFont(new Font("Tahoma", Font.BOLD, 14));
        lblAge.setBounds(50, 180, 100, 25);
        contentPane.add(lblAge);

        ageField = new JTextField();
        ageField.setBounds(180, 180, 180, 25);
        contentPane.add(ageField);

        JLabel lblMobile = new JLabel("Mobile");
        lblMobile.setFont(new Font("Tahoma", Font.BOLD, 14));
        lblMobile.setBounds(50, 220, 100, 25);
        contentPane.add(lblMobile);

        mobileField = new JTextField();
        mobileField.setBounds(180, 220, 180, 25);
        contentPane.add(mobileField);

        JLabel lblEmail = new JLabel("Email");
        lblEmail.setFont(new Font("Tahoma", Font.BOLD, 14));
        lblEmail.setBounds(50, 260, 100, 25);
        contentPane.add(lblEmail);

        emailField = new JTextField();
        emailField.setBounds(180, 260, 180, 25);
        contentPane.add(emailField);

        JLabel lblUsername = new JLabel("Username");
        lblUsername.setFont(new Font("Tahoma", Font.BOLD, 14));
        lblUsername.setBounds(50, 300, 100, 25);
        contentPane.add(lblUsername);

        usernameField = new JTextField();
        usernameField.setBounds(180, 300, 180, 25);
        contentPane.add(usernameField);

        JLabel lblPassword = new JLabel("Password");
        lblPassword.setFont(new Font("Tahoma", Font.BOLD, 14));
        lblPassword.setBounds(50, 340, 100, 25);
        contentPane.add(lblPassword);

        passwordField = new JPasswordField();
        passwordField.setBounds(180, 340, 180, 25);
        contentPane.add(passwordField);

        JButton btnRegister = new JButton("Register");
        btnRegister.setFont(new Font("Tahoma", Font.BOLD, 14));
        btnRegister.setBounds(100, 400, 120, 30);
        contentPane.add(btnRegister);

        JButton btnReset = new JButton("Reset");
        btnReset.setFont(new Font("Tahoma", Font.BOLD, 14));
        btnReset.setBounds(250, 400, 120, 30);
        contentPane.add(btnReset);

        btnRegister.addActionListener(e -> registerUser());
        btnReset.addActionListener(e -> clearFields());
    }

    private void registerUser() {
        String userName = nameField.getText();
        String address = addressField.getText();
        String gender = maleBtn.isSelected() ? "Male" : (femaleBtn.isSelected() ? "Female" : "");
        String ageText = ageField.getText();
        String mobile = mobileField.getText();
        String email = emailField.getText();
        String username = usernameField.getText();
        String password = new String(passwordField.getPassword());

        if (userName.isEmpty() || address.isEmpty() || gender.isEmpty() || ageText.isEmpty()
                || mobile.isEmpty() || email.isEmpty() || username.isEmpty() || password.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please fill all fields.");
            return;
        }

        try {
            int age = Integer.parseInt(ageText);
            Connection conn = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/userdb", "root", "root@"
            );
            String query = "INSERT INTO users1 (user_name, address, gender, age, mobile_no, email, username, password) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

            PreparedStatement pst = conn.prepareStatement(query);
            pst.setString(1, userName);
            pst.setString(2, address);
            pst.setString(3, gender);
            pst.setInt(4, age);
            pst.setString(5, mobile);
            pst.setString(6, email);
            pst.setString(7, username);
            pst.setString(8, password);

            int rows = pst.executeUpdate();
            if (rows > 0) {
                JOptionPane.showMessageDialog(this, "User registered successfully!");
                clearFields();
            } else {
                JOptionPane.showMessageDialog(this, "Registration failed.");
            }

            pst.close();
            conn.close();

        } catch (NumberFormatException nfe) {
            JOptionPane.showMessageDialog(this, "Age must be a valid number.");
        } catch (SQLException se) {
            JOptionPane.showMessageDialog(this, "Error: " + se.getMessage());
            se.printStackTrace();
        }
    }

    private void clearFields() {
        nameField.setText("");
        addressField.setText("");
        ageField.setText("");
        mobileField.setText("");
        emailField.setText("");
        usernameField.setText("");
        passwordField.setText("");
        genderGroup.clearSelection();
    }
}
