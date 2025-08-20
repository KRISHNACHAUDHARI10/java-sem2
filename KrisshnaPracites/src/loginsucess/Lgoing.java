package loginsucess;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Ragister.Log;
import Ragister.UserDAO;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Lgoing extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField username;
	private JTextField password;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Lgoing frame = new Lgoing();
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
	public Lgoing() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("For Login FORM");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel.setBounds(135, 10, 135, 13);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("UName");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_1.setBounds(46, 46, 78, 33);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Password");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_2.setBounds(44, 89, 67, 31);
		contentPane.add(lblNewLabel_2);
		
		username = new JTextField();
		username.setBounds(162, 54, 96, 19);
		contentPane.add(username);
		username.setColumns(10);
		
		password = new JTextField();
		password.setBounds(162, 96, 96, 19);
		contentPane.add(password);
		password.setColumns(10);
		
		JButton submit = new JButton("Login");
		submit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				
				    String user=  username.getText();           // Use textField for username
			        String pass = password.getText();         // Use textField_1 for password
			          if (LogUse.validuser(user, pass)) {
			        	JOptionPane.showMessageDialog(null, "Login Successful!");

			        } else {
			        	JOptionPane.showMessageDialog(null, "Login not Successful!");

			        }
				
				
				
				
			}
			
		});
		submit.setFont(new Font("Tahoma", Font.PLAIN, 14));
		submit.setBounds(118, 150, 85, 21);
		contentPane.add(submit);
	}
}
