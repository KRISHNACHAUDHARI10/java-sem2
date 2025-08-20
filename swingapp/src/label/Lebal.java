package label;

import javax.swing.*;
import java.awt.Dimension;

class Lebal {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Hello Application");
        frame.setSize(400, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Using BoxLayout for vertical arrangement
        frame.setLayout(new BoxLayout(frame.getContentPane(), BoxLayout.Y_AXIS));

        // JLabel with preferred size (width, height)
        JLabel label = new JLabel("Type your name:");
        label.setPreferredSize(new Dimension(200, 30));  // 200x30 size
        frame.add(label);

        // JTextField with preferred size (width, height)
        JTextField nameField = new JTextField();
        nameField.setPreferredSize(new Dimension(200, 30));  // 200x30 size
        frame.add(nameField);

        frame.setVisible(true);
    }
}
