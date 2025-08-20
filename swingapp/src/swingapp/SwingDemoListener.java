
 
 

package swingapp;

import javax.swing.*;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SwingDemoListener extends JFrame { 
    private JLabel jLabel;
    private JTextField jText;
    private JButton jButton;
    private JTextArea jTextArea;

    public SwingDemoListener() {
        // Set up frame
        setTitle("My New Frame");
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null); // Use null layout manager

        // Set background color for JFrame
        getContentPane().setBackground(Color.LIGHT_GRAY); 

        // Initialize components
        jLabel = new JLabel("Java Swing Tutorial");
        jLabel.setBounds(100, 20, 200, 30);
        jLabel.setForeground(Color.BLUE); 

        jText = new JTextField();
        jText.setBounds(100, 60, 200, 30);
        jText.setBackground(Color.WHITE); 
        jText.setForeground(Color.BLACK); 

        jButton = new JButton("Click New");
        jButton.setBounds(100, 100, 200, 30);
        jButton.setBackground(Color.CYAN); 
        jButton.setForeground(Color.BLACK);
        jTextArea = new JTextArea();
        jTextArea.setBounds(100, 140, 200, 100);
        jTextArea.setBackground(Color.yellow); 
        jTextArea.setForeground(Color.BLACK);
        jTextArea.setLineWrap(true); 
        jTextArea.setWrapStyleWord(true); 

        // Add components to the frame
        add(jLabel);
        add(jText);
        add(jButton);
        add(jTextArea);

        // Add ActionListener to the button
        jButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Change label text and text area content when the button is clicked
                jLabel.setText("After clicking the button");
                jTextArea.setText("In the Text Area");
            }
        });

        setVisible(true); // Make the frame visible
    }

    public static void main(String[] args) {
        SwingDemoListener sd = new SwingDemoListener(); 
    }
}
