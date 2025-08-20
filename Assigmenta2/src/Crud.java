import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.JScrollPane;

public class Crud extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField title;
	private JTextField author;
	private JTextField isbn;
	private JTextField quant;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Crud frame = new Crud();
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
	public Crud() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 790, 636);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		title = new JTextField();
		title.setBounds(244, 130, 96, 19);
		contentPane.add(title);
		title.setColumns(10);
		
		author = new JTextField();
		author.setBounds(244, 192, 96, 19);
		contentPane.add(author);
		author.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("title");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel.setBounds(141, 131, 130, 13);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("author");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1.setBounds(137, 184, 57, 30);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("ISBN");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_2.setBounds(137, 257, 45, 13);
		contentPane.add(lblNewLabel_2);
		
		isbn = new JTextField();
		isbn.setBounds(244, 256, 96, 19);
		contentPane.add(isbn);
		isbn.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Quanttiy");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_3.setBounds(141, 318, 45, 13);
		contentPane.add(lblNewLabel_3);
		
		quant = new JTextField();
		quant.setBounds(244, 312, 96, 19);
		contentPane.add(quant);
		quant.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("This is Registration Form");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_4.setBounds(225, 47, 210, 13);
		contentPane.add(lblNewLabel_4);
		
		JButton btnNewButton = new JButton("ADD");
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			 	
			
			}
		});
		btnNewButton.setBounds(141, 370, 85, 21);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Update");
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnNewButton_1.setBounds(255, 372, 85, 21);
		contentPane.add(btnNewButton_1);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(90, 415, 557, 142);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
	}
}
