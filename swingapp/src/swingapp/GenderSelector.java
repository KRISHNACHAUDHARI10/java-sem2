package swingapp;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class GenderSelector {
    public JFrame framej;
    public JLabel jlabel, imageLabel;
    public JButton jButton;
    public JRadioButton radioMale, radioFemale;
    public ButtonGroup genderGroup;

    public GenderSelector() {
    	
        framej = new JFrame("Gender Selector");

        // Load and set image
        ImageIcon icon = new ImageIcon("D:\\myeclipswork'\\Adovbeweb\\oops\\AAnimal\\swingapp\\src\\swingapp\\Screenshot 2025-01-19 221034.png");
        imageLabel = new JLabel(icon);
        imageLabel.setBounds(120, 10, 150, 100); // Adjust dimensions if needed

        jlabel = new JLabel("Select Your Gender:");
        jlabel.setBounds(120, 120, 200, 20);

        radioMale = new JRadioButton("Male");
        radioMale.setBounds(100, 150, 100, 20);

        radioFemale = new JRadioButton("Female");
        radioFemale.setBounds(200, 150, 100, 20);

        // Group the radio buttons so only one can be selected
        genderGroup = new ButtonGroup();
        genderGroup.add(radioMale);
        genderGroup.add(radioFemale);
        jButton = new JButton("Submit");
        jButton.setBounds(140, 200, 100, 30);

        jButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String selectedGender = "";
                if (radioMale.isSelected()) {
                    selectedGender = "You selected: Male";
                } else if (radioFemale.isSelected()) {
                    selectedGender = "You selected: Female";
                } else {
                    selectedGender = "Please select a gender.";
                }

                JOptionPane.showMessageDialog(framej,selectedGender); 
            }
        });

        // Add components to frame
        framej.add(imageLabel);
        framej.add(jlabel);
        framej.add(radioMale);
        framej.add(radioFemale);
        framej.add(jButton);

        // Frame settings
        framej.setSize(400, 300);
        framej.setLayout(null);
        framej.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        framej.setVisible(true);
    }

    public static void main(String[] args) {
        new GenderSelector();
    }
}
