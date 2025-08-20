package swingapp;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class PasswordDemo implements ActionListener {  // Implementing ActionListener

    private JFrame framej;       // JFrame instance
    private JLabel jLabel;
    private JButton jButton;
    private JPasswordField jPassword;

    public PasswordDemo() {
        framej = new JFrame("My First Frame");  // Creating JFrame instance

        jLabel = new JLabel("Password");
        jLabel.setBounds(40, 10, 100, 20);

        jPassword = new JPasswordField();
        jPassword.setBounds(40, 40, 150, 20);

        jButton = new JButton("Submit");
        jButton.setBounds(40, 70, 100, 30);

        // Adding components to the frame
        framej.add(jLabel);
        framej.add(jPassword);
        framej.add(jButton);

        // Adding ActionListener to the button
        jButton.addActionListener(this);

        framej.setSize(300, 200);
        framej.setLayout(null);                      // Using null layout for absolute positioning
        framej.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        framej.setVisible(true);                     // Making the window visible
    }

    public static void main(String[] args) {
        new PasswordDemo();                         // Creating an instance of PasswordDemo
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == jButton) {
            // Retrieve password as a String (recommended)
            String password = new String(jPassword.getPassword());
            jLabel.setText("Password: " + password);
        }
    }
}
