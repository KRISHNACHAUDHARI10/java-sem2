package now;

import java.awt.EventQueue;
import javax.swing.*;
import java.awt.event.*;

public class MenuBarExample {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(() -> {
			try {
				MenuBarExample  window = new  MenuBarExample  ();
				window.frame.setVisible(true);
			} catch (Exception e) {
				e.printStackTrace();
			}
		});
	}

	/**
	 * Create the application.
	 */
	public MenuBarExample () {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JMenuBar menuBar = new JMenuBar();
		frame.setJMenuBar(menuBar);

		JMenu mnFile = new JMenu("File");
		menuBar.add(mnFile);

		JMenuItem mntmNew = new JMenuItem("New");
		mntmNew.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "New clicked");
			}
		});
		mnFile.add(mntmNew);

		JMenuItem mntmOpen = new JMenuItem("Open");
		mntmOpen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "Open clicked");
			}
		});
		mnFile.add(mntmOpen);

		JMenuItem mntmExit = new JMenuItem("Exit");
		mntmExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "Exit clicked");
				System.exit(0);
			}
		});
		mnFile.add(mntmExit);

		JMenu mnEdit = new JMenu("Edit");
		menuBar.add(mnEdit);

		JMenuItem mntmCut = new JMenuItem("Cut");
		mntmCut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "Cut clicked");
			}
		});
		mnEdit.add(mntmCut);

		JMenuItem mntmCopy = new JMenuItem("Copy");
		mntmCopy.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "Copy clicked");
			}
		});
		mnEdit.add(mntmCopy);

		JMenuItem mntmPaste = new JMenuItem("Paste");
		mntmPaste.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "Paste clicked");
			}
		});
		mnEdit.add(mntmPaste);
		frame.getContentPane().setLayout(null);
		
		JMenuItem menuItem = new JMenuItem("New menu item");
		menuItem.setBounds(135, 37, 135, 26);
		frame.getContentPane().add(menuItem);
		
		JMenuItem menuItem_1 = new JMenuItem("New menu item");
		menuItem_1.setBounds(135, 37, 135, 26);
		frame.getContentPane().add(menuItem_1);
	}
}
