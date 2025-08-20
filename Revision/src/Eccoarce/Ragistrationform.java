package Eccoarce;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTable;
import javax.swing.JLabel;
import javax.swing.JList;

public class Ragistrationform extends JFrame {

	private static final long serialVersionUID = 1L;
	private JTable table;

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
		setBounds(100, 100, 450, 456);
		
		table = new JTable();
		getContentPane().add(table, BorderLayout.NORTH);
		
		JList list = new JList();
		getContentPane().add(list, BorderLayout.CENTER);
	}

}
