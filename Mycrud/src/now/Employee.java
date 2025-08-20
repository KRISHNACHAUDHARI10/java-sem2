package now;

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
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JComboBox;

public class Employee extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel edepart;
	private JTextField eid;
	private JTextField ename;
	private JTextField edepa;
	private JTextField esalary;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Employee frame = new Employee();
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
	public Employee() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 911, 675);
		edepart = new JPanel();
		edepart.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(edepart);
		edepart.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Enter Employee Register Form");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel.setBounds(261, 27, 330, 13);
		edepart.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("employeeid");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1.setBounds(148, 108, 108, 13);
		edepart.add(lblNewLabel_1);
		
		eid = new JTextField();
		eid.setBounds(318, 108, 96, 18);
		edepart.add(eid);
		eid.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Name");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_2.setBounds(148, 158, 108, 13);
		edepart.add(lblNewLabel_2);
		
		ename = new JTextField();
		ename.setBounds(318, 157, 96, 19);
		edepart.add(ename);
		ename.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("DepartMent");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_3.setBounds(148, 219, 86, 13);
		edepart.add(lblNewLabel_3);
		
		edepa = new JTextField();
		edepa.setBounds(318, 218, 96, 19);
		edepart.add(edepa);
		edepa.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("Salary");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_4.setBounds(148, 287, 45, 13);
		edepart.add(lblNewLabel_4);
		
		esalary = new JTextField();
		esalary.setBounds(318, 286, 96, 19);
		edepart.add(esalary);
		esalary.setColumns(10);
		
		
		JLabel totalSalaryLabel = new JLabel("Total Salary: ");
		totalSalaryLabel.setBounds(563, 182, 300, 25);
		edepart.add(totalSalaryLabel);
	


		JButton calcSalaryBtn = new JButton("Calculate Total Salary");
		calcSalaryBtn.setBounds(573, 104, 200, 25);
		edepart.add(calcSalaryBtn);
		
		JButton btnNewButton = new JButton("ADD");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				  try {
					  
					  String id =  eid.getText();
					  String  n = ename.getText();
					  String ed  = edepa.getText();
					  String  es = esalary.getText();
					  
					  
					  
					  
					Class.forName("com.mysql.cj.jdbc.Driver");
			        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/employee","root","root@");
			        String qry = " insert into employ  values (?,?,?,?)";
			        PreparedStatement ps = con.prepareStatement(qry);
			         
			        ps.setString(1, id);
			        ps.setString(2, n);
			        ps.setString(3, ed);
			        ps.setString(4, es);
			        
			        
			        
			        int i = ps.executeUpdate();
			         if(i>0) {
			        	  JOptionPane.showMessageDialog(null,"added successfuly ");
			        	  
			         }
			         else {
                       JOptionPane.showMessageDialog(null,"added successfuly ");
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
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnNewButton.setBounds(148, 334, 108, 36);
		edepart.add(btnNewButton);
		
		JButton btnView = new JButton("View");
		btnView.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) { 
				
				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/employee","root","root@");
				    Statement st = con.createStatement();
				    String qry ="select * from employ";
				    ResultSet rs = st.executeQuery(qry);
				    ResultSetMetaData  rsmd = rs.getMetaData();
				    
				    
				    DefaultTableModel  model = (DefaultTableModel)table.getModel();	
				    
				    int  cols= rsmd.getColumnCount();
				    model.setRowCount(0);
				    
				    
				    String[] coluname = new String[cols];
				    for(int i =0; i<cols; i++) {
				    	coluname[i] = model.getColumnName(i+1);
				    }
				      model.setColumnIdentifiers(coluname);
				      
				    
				      
				      while(rs.next()) {
				    	         String  id = rs.getString(1);
				    	         String  n = rs.getString(2);
				    	         String  ed = rs.getString(3);
				    	         String  es = rs.getString(4);
				    	          String [] row = {id,n,ed,es};
				    	             model.addRow(row);
				    	           
				      } 
				     rs.close();
				     con.close();
				      
				    
				} catch (ClassNotFoundException | SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
		       
			   
			}
		});
	

		calcSalaryBtn.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        try {
		            Class.forName("com.mysql.cj.jdbc.Driver");
		            Connection con = DriverManager.getConnection(
		                "jdbc:mysql://localhost:3306/employee", "root", "root@"
		            );
		            
		            String query = "SELECT SUM(esalary) AS total FROM employ";
		            PreparedStatement ps = con.prepareStatement(query);
		            ResultSet rs = ps.executeQuery();
		            
		            if (rs.next()) {
		                double total = rs.getDouble("total");
		                
		                totalSalaryLabel.setText("Total Salary: " + total);
		            }

		            rs.close();
		            ps.close();
		            con.close();
		        } catch (Exception ex) {
		            ex.printStackTrace();
		        }
		    }
		});


		btnView.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnView.setBounds(286, 334, 108, 36);
		edepart.add(btnView);
		
		JButton btnUpdate = new JButton("Update");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 try {
					  
					  String id =  eid.getText();
					  String  n = ename.getText();
					  String ed  = edepa.getText();
					  String  es = esalary.getText();
					  
					  
					  
					  
					Class.forName("com.mysql.cj.jdbc.Driver");
			        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/employee","root","root@");
			        
			        String qry ="update employ  set eid=?,ename=?,edepa=?  where esalary=? ";
			        PreparedStatement ps = con.prepareStatement(qry);
			         
			        ps.setString(1, id);
			        ps.setString(2, n);
			        ps.setString(3, es);
			        ps.setString(4,ed);
			      
			        
			        
			        
			        int i = ps.executeUpdate();
			         if(i>0) {
			        	  JOptionPane.showMessageDialog(null,"update successfuly ");
			        	  
			         }
			         else {
                 JOptionPane.showMessageDialog(null,"update not successfuly ");
			        	  
			         
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

		btnUpdate.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnUpdate.setBounds(418, 334, 108, 36);
		edepart.add(btnUpdate);
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				
				 try {
					  
					
					  String  es = esalary.getText();
					  
					  
					  
					  
					Class.forName("com.mysql.cj.jdbc.Driver");
			        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/employee","root","root@");
			        String qry ="delete  from employ   where esalary=?";
			        PreparedStatement ps = con.prepareStatement(qry);
			         
			      
			        ps.setString(1, es);
			        
			      
			        
			        
			        
			        int i = ps.executeUpdate();
			         if(i>0) {
			        	  JOptionPane.showMessageDialog(null,"delete successfuly ");
			        	  
			         }
			         else {
                JOptionPane.showMessageDialog(null,"delte not successfuly ");
			        	  
			         
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
		btnDelete.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnDelete.setBounds(531, 334, 108, 36);
		edepart.add(btnDelete);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(148, 419, 603, 209);
		edepart.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		JComboBox comboBox = new JComboBox();
		scrollPane.setColumnHeaderView(comboBox);
		
		JComboBox laptop = new JComboBox();
		laptop.setBounds(726, 253, 117, 21);
		edepart.add(laptop);
		table.addMouseListener(new java.awt.event.MouseAdapter(){
			public   void   mouseClicked (java.awt.event.MouseEvent  evt) {
			       int row = table.getSelectedRow();
			        if(row >= 0) {
			        	   eid.setText(table.getValueAt(row,0).toString());
			        	   ename.setText(table.getValueAt(row,1).toString());
			        	   edepa.setText(table.getValueAt(row,2).toString());
			        	   esalary.setText(table.getValueAt(row,3).toString());
			        }
			}
			
		});
	}
}
