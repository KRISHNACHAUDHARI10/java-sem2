package swingapp;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SwingDemo extends JFrame {
    private JTextField textfield;
    private JButton button;
    private JLabel label;

    public SwingDemo() {
        setTitle("krishna application");
        setSize(400, 400);
        setLayout(null);

        textfield = new JTextField();
        textfield.setBounds(60, 50, 200, 30);
        add(textfield);

        button = new JButton("click here");
        button.setBounds(60, 100, 200, 30);
        add(button);

        label = new JLabel();
        label.setBounds(60, 150, 200, 30);  // Fixed position
        add(label);

        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                label.setText(textfield.getText());
            }
        });

        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  // Add this to close the window properly
    }

    public static void main(String[] args) {
        new SwingDemo();
    }
}
