package krishnaragister;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.FlowLayout;
import javax.swing.JCheckBox;
import java.awt.CardLayout;
import java.awt.GridLayout;

public class kkrishnaragister extends JFrame {

    private static final long serialVersionUID = 1L;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    kkrishnaragister frame = new kkrishnaragister();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the frame.
     */
    public kkrishnaragister() {
    	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setUndecorated(false);
        setBounds(100, 100, 653, 502);
        getContentPane().setLayout(null);
        getContentPane().setLayout(null);
        getContentPane().setLayout(null);
        getContentPane().setLayout(new CardLayout(0, 0));
        getContentPane().setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
        getContentPane().setLayout(new GridLayout(1, 0, 0, 0));
        getContentPane().setLayout(new GridLayout(1, 0, 0, 0));
    }
}
