package Ragister;

import java.awt.EventQueue;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.awt.event.ActionEvent;

public class FormSubmision extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel txtname;
	private JTextField textnameee;
	private final ButtonGroup genderGroup = new ButtonGroup();
	private JTextField txtage;
	private JTextField txtmobile;
	private JTextField txtemail;
	private JTextField txtuname;
	private JPasswordField txtpassword;

	public static void main(String[] args) {
		EventQueue.invokeLater(() -> {
			try {
				FormSubmision frame = new FormSubmision();
				frame.setVisible(true);
			} catch (Exception e) {
				e.printStackTrace();
			}
		});
	}

	public FormSubmision() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 599, 551);
		txtname = new JPanel();
		txtname.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(txtname);
		txtname.setLayout(null);

		JLabel lblNewLabel = new JLabel("Name");
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 14));
		lblNewLabel.setBounds(51, 60, 45, 13);
		txtname.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("Address");
		lblNewLabel_1.setFont(new Font("Arial", Font.BOLD, 14));
		lblNewLabel_1.setBounds(51, 101, 90, 13);
		txtname.add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("Gender");
		lblNewLabel_2.setFont(new Font("Arial", Font.BOLD, 14));
		lblNewLabel_2.setBounds(51, 184, 75, 13);
		txtname.add(lblNewLabel_2);

		JLabel lblNewLabel_3 = new JLabel("Age");
		lblNewLabel_3.setFont(new Font("Arial", Font.BOLD, 14));
		lblNewLabel_3.setBounds(51, 230, 75, 13);
		txtname.add(lblNewLabel_3);

		JLabel lblNewLabel_4 = new JLabel("Mobile No");
		lblNewLabel_4.setFont(new Font("Arial", Font.BOLD, 14));
		lblNewLabel_4.setBounds(51, 282, 75, 13);
		txtname.add(lblNewLabel_4);

		JLabel lblNewLabel_5 = new JLabel("Email");
		lblNewLabel_5.setFont(new Font("Arial", Font.BOLD, 14));
		lblNewLabel_5.setBounds(51, 328, 45, 13);
		txtname.add(lblNewLabel_5);

		JLabel lblNewLabel_7 = new JLabel("Username");
		lblNewLabel_7.setFont(new Font("Arial", Font.BOLD, 14));
		lblNewLabel_7.setBounds(51, 373, 103, 17);
		txtname.add(lblNewLabel_7);

		JLabel lblNewLabel_6 = new JLabel("Password");
		lblNewLabel_6.setFont(new Font("Arial", Font.BOLD, 14));
		lblNewLabel_6.setBounds(51, 415, 103, 13);
		txtname.add(lblNewLabel_6);

		textnameee = new JTextField();
		textnameee.setBounds(166, 58, 132, 19);
		txtname.add(textnameee);
		textnameee.setColumns(10);

		JTextArea areaAddress = new JTextArea();
		areaAddress.setBounds(170, 96, 171, 79);
		txtname.add(areaAddress);

		JRadioButton rdMale = new JRadioButton("Male");
		rdMale.setFont(new Font("Tahoma", Font.BOLD, 14));
		genderGroup.add(rdMale);
		rdMale.setBounds(165, 181, 103, 21);
		txtname.add(rdMale);

		JRadioButton rdFemale = new JRadioButton("Female");
		rdFemale.setFont(new Font("Tahoma", Font.BOLD, 14));
		genderGroup.add(rdFemale);
		rdFemale.setBounds(270, 181, 103, 21);
		txtname.add(rdFemale);

		txtage = new JTextField();
		txtage.setBounds(172, 228, 171, 19);
		txtname.add(txtage);
		txtage.setColumns(10);

		txtmobile = new JTextField();
		txtmobile.setBounds(172, 280, 96, 19);
		txtname.add(txtmobile);
		txtmobile.setColumns(10);

		txtemail = new JTextField();
		txtemail.setBounds(172, 326, 96, 19);
		txtname.add(txtemail);
		txtemail.setColumns(10);

		txtuname = new JTextField();
		txtuname.setBounds(172, 373, 96, 19);
		txtname.add(txtuname);
		txtuname.setColumns(10);

		txtpassword = new JPasswordField();
		txtpassword.setBounds(172, 413, 96, 19);
		txtname.add(txtpassword);

		JButton btnragister = new JButton("Register");
		btnragister.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/human", "root", "root@");
                   
					String query = "INSERT INTO registration VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
				    PreparedStatement ps = con.prepareStatement(query);
                   
					ps.setString(1, textnameee.getText());
				
					ps.setString(2, areaAddress.getText());
                   
			        String gender =  rdMale.isSelected() ? "Male" :rdMale.isSelected() ? "FeMale":""; 
				    ps.setString(3, gender);
                         
				    int age = Integer.parseInt(txtage.getText());
				    long mobile = Long.parseLong(txtmobile.getText());

					ps.setInt(4, age);
					ps.setLong(5, mobile);
					ps.setString(6, txtemail.getText());
					ps.setString(7, txtuname.getText());
					
               
                  			
 					ps.setString(8, new String(txtpassword.getPassword()));  
                   
  					int i = ps.executeUpdate();
					JOptionPane.showMessageDialog(btnragister, i + " registered successfully");

					ps.close();
					con.close();

				}
				catch (Exception e1) {
					e1.printStackTrace();
					JOptionPane.showMessageDialog(null, "Registration Failed: " + e1.getMessage());
				}	
				
			}
		});
		btnragister.setBounds(83, 467, 85, 21);
		txtname.add(btnragister);

		JButton btnreset = new JButton("Reset");
		btnreset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textnameee.setText("");
				areaAddress.setText("");
				txtage.setText("");
				txtmobile.setText("");
				txtemail.setText("");
				txtuname.setText("");
				txtpassword.setText("");
				genderGroup.clearSelection();
			}
		});
		btnreset.setBounds(215, 467, 85, 21);
	txtname.add(btnreset);
	}
}
