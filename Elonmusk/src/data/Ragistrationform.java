package data;

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
public class Ragistrationform extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel name;
	private JTextField Name;
	private JTextField rollno;
	private JTextField course;
	private JTable table;
	private JScrollPane scrollPane;
	private JButton btnNewButton_1;
	private JButton btnNewButton_2;
	private JButton btnNewButton_3;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Ragistrationform frame = new Ragistrationform();
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
	public Ragistrationform() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 683, 586);
		name = new JPanel();
		name.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(name);
		name.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Name");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel.setBounds(78, 85, 45, 13);
		name.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("rollno");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1.setBounds(78, 141, 70, 13);
		name.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Course");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_2.setBounds(78, 200, 95, 13);
		name.add(lblNewLabel_2);
		
		Name = new JTextField();
		Name.setBounds(202, 84, 96, 19);
		name.add(Name);
		Name.setColumns(10);
		
		rollno = new JTextField();
		rollno.setBounds(202, 140, 96, 19);
		name.add(rollno);
		rollno.setColumns(10);
		
		course = new JTextField();
		course.setBounds(202, 199, 96, 19);
		name.add(course);
		course.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("THIS is ragistration form");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_3.setBounds(223, 22, 189, 13);
		name.add(lblNewLabel_3);
		
		JButton btnNewButton = new JButton("Add");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
		        try {
		          String n = Name.getText();
		          String r = rollno.getText();
		          String c = course.getText();
		        	
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/elon","root","root@");
				    String qry  = "insert into musk  values(?,?,?)";
				    PreparedStatement ps= con.prepareStatement(qry);
				       
				   ps.setString(1, n);
				   ps.setString(2, r);
				   ps.setString(3, c);
				   
				   int i = ps.executeUpdate();
				   if(i>0) {
					   JOptionPane.showMessageDialog(null,"added succesfully");
				   }
				   else {
					   
						   JOptionPane.showMessageDialog(null," not added succesfully");
					   
				   }
					
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
		        
		        
			 	
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnNewButton.setBounds(78, 249, 85, 39);
		name.add(btnNewButton);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(78, 331, 558, 195);
		name.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		table.addMouseListener(new java.awt.event.MouseAdapter() {
		    @Override
		    public void mouseClicked(java.awt.event.MouseEvent evt) {
		    	
		        int row = table.getSelectedRow();
		        if (row >= 0) {
		            Name.setText(table.getValueAt(row, 0).toString());
		            rollno.setText(table.getValueAt(row, 1).toString());
		            course.setText(table.getValueAt(row, 2).toString());
		        }
		        
		    }
		});   
		 
		btnNewButton_1 = new JButton("View");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/elon","root","root@");
					Statement st= con.createStatement();
				    String qry  = "select * from musk";
				   
				    ResultSet rs =  st.executeQuery(qry);
				    ResultSetMetaData rsmd = rs.getMetaData();		
				    
				    DefaultTableModel model =(  DefaultTableModel)  table.getModel();
				   
				  
				   int cols = rsmd.getColumnCount();
				   model.setRowCount(0);
				   
				   
				   String[] coluname = new String[cols];
	                 for(int i=0; i<cols; i++) {
	                	 coluname[i]  = rsmd.getColumnName(i+1);
	                 }
	                 model.setColumnIdentifiers(coluname);
	                 
	                while(rs.next()) {
	              
	                	  String n =rs.getString(1);
	                	  String r=rs.getString(2);
	                	  String c =rs.getString(3);
	  	                  String[] row = { n, r,c };
		                  model.addRow(row); 
	                }
	                
	                st.close();				    
				    con.close();
				    
				   
				    
				}  catch (ClassNotFoundException | SQLException e1) {
		            e1.printStackTrace();
		        }
		        
				
			}
		});
		btnNewButton_1.setBounds(202, 249, 105, 39);
		name.add(btnNewButton_1);
		
		btnNewButton_2 = new JButton("Update");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				try {
			          String n = Name.getText();
			          String r = rollno.getText();
			          String c = course.getText();
			        	
						Class.forName("com.mysql.cj.jdbc.Driver");
						Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/elon","root","root@");
					    String qry  = "update   musk  set Name=?,rollno=? where course=?";
					    PreparedStatement ps= con.prepareStatement(qry);
					       
					   ps.setString(1, n);
					   ps.setString(2, r);
					   ps.setString(3, c);
					   
					   int i = ps.executeUpdate();
					   if(i>0) {
						   JOptionPane.showMessageDialog(null,"updated  succesfully");
					   }
					   else {
						   
							   JOptionPane.showMessageDialog(null," not updated succesfully");
						   
					   }
					   ps.close();
					   con.close();						
					} catch (ClassNotFoundException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
			        
			        
				
			}
		});
		btnNewButton_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnNewButton_2.setBounds(339, 254, 105, 28);
		name.add(btnNewButton_2);
		
		btnNewButton_3 = new JButton("Delete");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				

				try {
			         
			          String c = course.getText();
			        	
						Class.forName("com.mysql.cj.jdbc.Driver");
						Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/elon","root","root@");
					    String qry  = "delete from musk where course=?";
					    PreparedStatement ps= con.prepareStatement(qry);
					       
					 
					   ps.setString(1, c);
					   
					   int i = ps.executeUpdate();
					   if(i>0) {
						   JOptionPane.showMessageDialog(null,"Deleted  succesfully");
					   }
					   else {
						   
							   JOptionPane.showMessageDialog(null," not deleted succesfully");
						   
					   }
					   ps.close();
					   con.close();						
					} catch (ClassNotFoundException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
			        
			        
				
				
			}
		});
		btnNewButton_3.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnNewButton_3.setBounds(458, 249, 120, 39);
		name.add(btnNewButton_3);
	}
}
