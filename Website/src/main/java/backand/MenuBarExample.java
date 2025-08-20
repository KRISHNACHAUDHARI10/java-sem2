package backand;

import javax.swing.*;
import java.awt.event.*;

public class MenuBarExample extends JFrame {

    public MenuBarExample() {
        // Frame title
        setTitle("Menu Bar Example");

        // Create menu bar
        JMenuBar menuBar = new JMenuBar();

        // Create menus
        JMenu fileMenu = new JMenu("File");
        JMenu editMenu = new JMenu("Edit");

        // Create File menu items
        JMenuItem newItem = new JMenuItem("New");
        JMenuItem openItem = new JMenuItem("Open");
        JMenuItem exitItem = new JMenuItem("Exit");

        // Add action listeners
        newItem.addActionListener(e -> showMessage("New clicked"));
        openItem.addActionListener(e -> showMessage("Open clicked"));
        exitItem.addActionListener(e -> System.exit(0)); // Exit app

        // Add items to File menu
        fileMenu.add(newItem);
        fileMenu.add(openItem);
        fileMenu.addSeparator();
        fileMenu.add(exitItem);

        // Create Edit menu items
        JMenuItem cutItem = new JMenuItem("Cut");
        JMenuItem copyItem = new JMenuItem("Copy");
        JMenuItem pasteItem = new JMenuItem("Paste");

        cutItem.addActionListener(e -> showMessage("Cut clicked"));
        copyItem.addActionListener(e -> showMessage("Copy clicked"));
        pasteItem.addActionListener(e -> showMessage("Paste clicked"));

        // Add items to Edit menu
        editMenu.add(cutItem);
        editMenu.add(copyItem);
        editMenu.add(pasteItem);

        // Add menus to the menu bar
        menuBar.add(fileMenu);
        menuBar.add(editMenu);

        // Set the menu bar to the frame
        setJMenuBar(menuBar);

        // Frame settings
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // Center the frame
        setVisible(true);
    
    
    }

    private void showMessage(String message) {
        JOptionPane.showMessageDialog(this, message);
    }	

    public static void main(String[] args) {
        new MenuBarExample();
    }
}
