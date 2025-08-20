	package Ragister;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;

public class Log extends JFrame {

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
					Log frame = new Log();
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
	public Log() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("This is Login Form");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel.setVerticalAlignment(SwingConstants.BOTTOM);
		lblNewLabel.setBounds(117, 10, 123, 13);
		contentPane.add(lblNewLabel);
		
		JLabel usernamee = new JLabel("Username ");
		usernamee.setFont(new Font("Tahoma", Font.BOLD, 14));
		usernamee.setBounds(39, 60, 85, 34);
		contentPane.add(usernamee);
		
		JLabel passwordd = new JLabel("Password");
		passwordd.setFont(new Font("Tahoma", Font.BOLD, 14));
		passwordd.setBounds(39, 129, 85, 34);
		contentPane.add(passwordd);
		
		username = new JTextField();
		username.setBounds(170, 70, 96, 19);
		contentPane.add(username);
		username.setColumns(10);
		
		password = new JTextField();
		password.setBounds(170, 139, 96, 19);
		contentPane.add(password);
		password.setColumns(10);
		
		JButton btnNewButton = new JButton("Login");
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnNewButton.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        String user =  username.getText();           // Use textField for username
		        String pass = password.getText();         // Use textField_1 for password
		        if (UserDAO.validateUser(user, pass)) {
		            JOptionPane.showMessageDialog(Log.this, "Login Successful!");
		        } else {
		           JOptionPane.showMessageDialog(Log.this, "Invalid Credentials!");
		        }
		    }
		 
		});

		btnNewButton.setBounds(117, 206, 108, 28);
		contentPane.add(btnNewButton);
	}
}
