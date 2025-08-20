package anyone;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.*;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;

public class Register extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel email;
	private JTextField name;
	private JTextField phone;
	private JTextField address;
	private JTextField Email;
	private JTextField password;
	private JTable table;
	private JButton btnNewButton;
	private JTable table_2;
	private JTable table_1;
	private JButton btnNewButton_1;
	private JScrollPane scrollPane;
	private JButton btnNewButton_2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Register frame = new Register();
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
	public Register() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 833, 702);
		email = new JPanel();
		email.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(email);
		email.setLayout(null);
		
		JLabel lblNewLabel_3 = new JLabel("Name");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_3.setBounds(86, 109, 45, 13);
		email.add(lblNewLabel_3);
		
		name = new JTextField();
		name.setBounds(205, 108, 96, 19);
		email.add(name);
		name.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("Phone");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_4.setBounds(86, 157, 45, 13);
		email.add(lblNewLabel_4);
		
		phone = new JTextField();
		phone.setBounds(205, 156, 96, 19);
		email.add(phone);
		phone.setColumns(10);
		
		JLabel lblNewLabel_5 = new JLabel("address");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_5.setBounds(86, 213, 86, 13);
		email.add(lblNewLabel_5);
		
		address = new JTextField();
		address.setBounds(204, 212, 96, 19);
		email.add(address);
		address.setColumns(10);
		
		JLabel lblNewLabel_6 = new JLabel("Passsword");
		lblNewLabel_6.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_6.setBounds(86, 302, 69, 13);
		email.add(lblNewLabel_6);
		
		Email = new JTextField();
		Email.setBounds(205, 263, 96, 19);
		email.add(Email);
		Email.setColumns(10);
		
		JLabel lblNewLabel_7 = new JLabel("Email");
		lblNewLabel_7.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_7.setBounds(86, 264, 45, 13);
		email.add(lblNewLabel_7);
		
		password = new JTextField();
		password.setBounds(204, 301, 96, 19);
		email.add(password);
		password.setColumns(10);
		JButton Login = new JButton("ADD");
		Login.addActionListener(new ActionListener() {
		  
			public void actionPerformed(ActionEvent e) {
		    
				try { 
                          		    	
		    	    String n = name.getText(); // fixed method name
		            String p = phone.getText(); // fixed method name
		            String a = address.getText(); // fixed method name
		            String E = Email.getText(); // fixed method name
		            String pa= password.getText(); // fixed method name

		            Class.forName("com.mysql.cj.jdbc.Driver");
		            String qry = "insert into majur values(?,?,?,?,?)";
		            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/majdur", "root", "root@");
		            PreparedStatement ps = con.prepareStatement(qry);

		            ps.setString(1, n);
		            ps.setString(2, p);
		            ps.setString(3, a);
		            ps.setString(4, E);
		            ps.setString(5, pa);

		            int i = ps.executeUpdate(); // fixed: added ps. before executeUpdate
		            if (i > 0) {
		                JOptionPane.showMessageDialog(null,"login  successfully");
		             
		            } else {
		                JOptionPane.showMessageDialog(null,"login not successfully");
		            }
		        } catch (SQLException e1) { // fixed: correct exception name
		            e1.printStackTrace();   // optional: to see the error details
		        } catch (Exception e2) {
		            e2.printStackTrace();
		        }
		    }
		});

				
				
			
			
	
			
	
		Login.setFont(new Font("Tahoma", Font.PLAIN, 14));
		Login.setBounds(86, 362, 113, 40);
		email.add(Login);
		
		JLabel lblNewLabel = new JLabel("Registration Form ");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel.setBounds(178, 10, 190, 40);
		email.add(lblNewLabel);
		
	
		
		btnNewButton = new JButton("Update");
		btnNewButton.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        try {
		            String n = name.getText();
		            String p = phone.getText();
		            String a = address.getText();
		            String E = Email.getText();
		            String pa = password.getText();

		            Class.forName("com.mysql.cj.jdbc.Driver");
		            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/majdur", "root", "root@");
		            String qry = "UPDATE majur SET name=?, phone=?, address=?, password=? WHERE email=?";
		            PreparedStatement ps = con.prepareStatement(qry);
                                                                       
		            ps.setString(1, n);
		            ps.setString(2, p);
		            ps.setString(3, a);
		            ps.setString(4, pa);
		            ps.setString(5, E);

		            int i = ps.executeUpdate();
		            if (i > 0) {
		                JOptionPane.showMessageDialog(null, "Updated successfully");
		             
		            } else {
		                JOptionPane.showMessageDialog(null, "No record found with this Email");
		            }

		            ps.close();
		            con.close();
		        } catch (SQLException e1) {
		            e1.printStackTrace();
		        } catch (Exception e2) {
		            e2.printStackTrace();
		        }
		    }
		});

		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnNewButton.setBounds(205, 362, 105, 40);
		email.add(btnNewButton);
		
		table_2 = new JTable();
		table_2.setBounds(469, 199, 1, 1);
		email.add(table_2);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(111, 461, 412, 176);
		email.add(scrollPane);
		
		table_1 = new JTable();
		scrollPane.setViewportView(table_1);
		// Add a mouse listener to populate text fields when a row is selected
		table_1.addMouseListener(new java.awt.event.MouseAdapter() {
		    @Override
		    public void mouseClicked(java.awt.event.MouseEvent evt) {
		        int row = table_1.getSelectedRow();
		        if(row >= 0) {
		        	name.setText(table_1.getValueAt(row, 0).toString());
		            phone.setText(table_1.getValueAt(row, 1).toString());
		            address.setText(table_1.getValueAt(row, 2).toString());
		            Email.setText(table_1.getValueAt(row, 3).toString());
		            password.setText(table_1.getValueAt(row, 4).toString());
		        }
		    }
		});                                   
                                             
		
		btnNewButton_1 = new JButton("View");
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnNewButton_1.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        
		        try {
		        	
		        	
		            Class.forName("com.mysql.cj.jdbc.Driver");
		            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/majdur", "root", "root@");
		            Statement st = con.createStatement();
		            String query = "SELECT * FROM majur";
		            ResultSet rs = st.executeQuery(query);
		            ResultSetMetaData rsmd = rs.getMetaData();

		            DefaultTableModel model = (DefaultTableModel) table_1.getModel();

                    int  cols = rsmd.getColumnCount();             
                    model.setRowCount(0);                           
                     
                     
                    String[] coluname = new String[cols];
                    for(int i=0; i<cols;i++) {
                    	 coluname[i] =  rsmd.getCatalogName(i+1);
                    }                     
                     model.setColumnIdentifiers(coluname);

		            // Now add rows
		            while (rs.next()) 
		             {
		            	
		                String n = rs.getString(1);
		                String p = rs.getString(2);
		                String a = rs.getString(3);
		                String E = rs.getString(4);
		                String pa = rs.getString(5);
		                String[] row = { n, p, a, E, pa };
		                model.addRow(row); // ✅ USING addRow method
		            }

		            st.close();
		            con.close();

		        } 
		        catch (ClassNotFoundException | SQLException e1) {
		            e1.printStackTrace();
		        }
		        
		    }
		});

		btnNewButton_1.setBounds(320, 362, 96, 37);
		email.add(btnNewButton_1);
		
		btnNewButton_2 = new JButton("Delete");
		btnNewButton_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			    try {
			    	
			        String E = Email.getText();

			        Class.forName("com.mysql.cj.jdbc.Driver");
			        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/majdur", "root", "root@");

			        PreparedStatement ps = con.prepareStatement("DELETE FROM majur WHERE email = ?");
			        ps.setString(1, E);

			        int count = ps.executeUpdate(); // Only call once

			        if (count > 0) {
			            JOptionPane.showMessageDialog(null, "Deletion successful");
			        } else {
			            JOptionPane.showMessageDialog(null, "No record found with this Email");
			        }

			        ps.close();
			        con.close();
			    } catch (ClassNotFoundException | SQLException ex) {
			        ex.printStackTrace(); // Show error in console
			        JOptionPane.showMessageDialog(null, "Error occurred: " + ex.getMessage());
			    }
			}

		});
		btnNewButton_2.setBounds(426, 362, 97, 39);
		email.add(btnNewButton_2);
	
	}

}
