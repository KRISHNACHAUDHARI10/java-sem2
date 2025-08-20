package now;

import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.event.*;
import java.sql.*;

public class Crud extends JFrame {
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField title;
	private JTextField author;
	private JTextField isbn;
	private JTextField quant;
	private JTable table;

	public static void main(String[] args) {
		EventQueue.invokeLater(() -> {
			try {
				Crud frame = new Crud();
				frame.setVisible(true);
			} catch (Exception e) {
				e.printStackTrace();
			}
		});
	}

	public Crud() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 700, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(10, 10, 10, 10));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblTitle = new JLabel("Title");
		lblTitle.setBounds(100, 100, 100, 20);
		contentPane.add(lblTitle);

		title = new JTextField();
		title.setBounds(200, 100, 150, 25);
		contentPane.add(title);

		JLabel lblAuthor = new JLabel("Author");
		lblAuthor.setBounds(100, 150, 100, 20);
		contentPane.add(lblAuthor);

		author = new JTextField();
		author.setBounds(200, 150, 150, 25);
		contentPane.add(author);

		JLabel lblIsbn = new JLabel("ISBN");
		lblIsbn.setBounds(100, 200, 100, 20);
		contentPane.add(lblIsbn);

		isbn = new JTextField();
		isbn.setBounds(200, 200, 150, 25);
		contentPane.add(isbn);

		JLabel lblQuant = new JLabel("Quantity");
		lblQuant.setBounds(100, 250, 100, 20);
		contentPane.add(lblQuant);

		quant = new JTextField();
		quant.setBounds(200, 250, 150, 25);
		contentPane.add(quant);

		JButton btnAdd = new JButton("Add");
		btnAdd.setBounds(100, 300, 80, 30);
		contentPane.add(btnAdd);

		JButton btnUpdate = new JButton("Update");
		btnUpdate.setBounds(200, 300, 80, 30);
		contentPane.add(btnUpdate);

		JButton btnDelete = new JButton("Delete");
		btnDelete.setBounds(300, 300, 80, 30);
		contentPane.add(btnDelete);

		JButton btnView = new JButton("View");
		btnView.setBounds(400, 300, 80, 30);
		contentPane.add(btnView);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(100, 350, 500, 200);
		contentPane.add(scrollPane);
		JTextField searchField = new JTextField();
		searchField.setBounds(480, 130, 130, 25);
		contentPane.add(searchField);

		JButton btnSearch = new JButton("Search");
		btnSearch.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnSearch.setBounds(620, 130, 100, 25);
		contentPane.add(btnSearch);


		table = new JTable();
		scrollPane.setViewportView(table);
		btnSearch.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        String keyword = searchField.getText().trim();

		        try {
		            Class.forName("com.mysql.cj.jdbc.Driver");
		            Connection con = DriverManager.getConnection( "jdbc:mysql://localhost:3306/Librery", "root", "root@");

		            String query = "SELECT * FROM Studnt WHERE title LIKE ? OR author LIKE ?";
		            
		            PreparedStatement ps = con.prepareStatement(query);
		            ps.setString(1, "%" + keyword + "%");
		            ps.setString(2, "%" + keyword + "%");

		            ResultSet rs = ps.executeQuery();
		            ResultSetMetaData rsmd = rs.getMetaData();
		            DefaultTableModel model = (DefaultTableModel) table.getModel();

		            int cols = rsmd.getColumnCount();
		            model.setNumRows(0); // clear existing
		            String[] coluname = new String[cols];
		            for (int i = 0; i < cols; i++) {
		                coluname[i] = rsmd.getColumnName(i + 1);
		            }
		            model.setColumnIdentifiers(coluname);

		            while (rs.next()) {
		                String t = rs.getString(1);
		                String a = rs.getString(2);
		                String l = rs.getString(3);
		                String q = rs.getString(4);
		                String[] row = { t, a, l, q };
		                model.addRow(row);
		            }

		            rs.close();
		            ps.close();
		            con.close();

		        } catch (Exception ex) {
		            ex.printStackTrace();
		        }
		    }
		});

		// Add button
		btnAdd.addActionListener(e -> {
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Librery", "root", "root@");
				String qry = "insert into Studnt values(?, ?, ?, ?)";
				PreparedStatement ps = con.prepareStatement(qry);
				ps.setString(1, title.getText());
				ps.setString(2, author.getText());
				ps.setString(3, isbn.getText());
				ps.setString(4, quant.getText());
				ps.executeUpdate();
				JOptionPane.showMessageDialog(null, "Added successfully");
				con.close();
			} catch (Exception ex) {
				System.out.println(ex);
			}
		});

		// Update button
		btnUpdate.addActionListener(e -> {
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Librery", "root", "root@");
				String qry = "update Studnt set title=?, author=?, isbn=? where quant=?";
				PreparedStatement ps = con.prepareStatement(qry);
				ps.setString(1, title.getText());
				ps.setString(2, author.getText());
				ps.setString(3, isbn.getText());
				ps.setString(4, quant.getText());
				ps.executeUpdate();
				JOptionPane.showMessageDialog(null, "Updated successfully");
				con.close();
			} catch (Exception ex) {
				System.out.println(ex);
			}
		});

		// Delete button
		btnDelete.addActionListener(e -> {
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Librery", "root", "root@");
				String qry = "delete from Studnt where quant=?";
				PreparedStatement ps = con.prepareStatement(qry);
				ps.setString(1, quant.getText());
				ps.executeUpdate();
				JOptionPane.showMessageDialog(null, "Deleted successfully");
				con.close();
			} catch (Exception ex) {
				System.out.println(ex);
			}
		});

		// View button
		btnView.addActionListener(e -> {
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Librery", "root", "root@");
				String qry = "select * from Studnt";
				Statement st = con.createStatement();
				ResultSet rs = st.executeQuery(qry);
				ResultSetMetaData rsmd = rs.getMetaData();
				DefaultTableModel model = (DefaultTableModel) table.getModel();
				int cols = rsmd.getColumnCount();
				String[] colName = new String[cols];
				for (int i = 0; i < cols; i++) {
					colName[i] = rsmd.getColumnName(i + 1);
				}
				model.setColumnIdentifiers(colName);
				model.setRowCount(0);
				while (rs.next()) {
					String[] row = new String[cols];
					for (int i = 0; i < cols; i++) {
						row[i] = rs.getString(i + 1);
					}
					model.addRow(row);
				}
				con.close();
			} catch (Exception ex) {
				System.out.println(ex);
			}
		});
	}
}
