package mainproject;
import javax.swing.*;
import java.awt.event.*;

public class Websitesss {
    public static void main(String[] args) {
        // Create the frame
        JFrame frame = new JFrame("Menu Bar Example");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);

        // Create the menu bar
        JMenuBar menuBar = new JMenuBar();

        // Create the File menu and its items
        JMenu fileMenu = new JMenu("File");
        JMenuItem newItem = new JMenuItem("New");
        JMenuItem openItem = new JMenuItem("Open");
        JMenuItem exitItem = new JMenuItem("Exit");

        // Add action listeners for File menu items
        newItem.addActionListener(e -> JOptionPane.showMessageDialog(frame, "New clicked"));
        openItem.addActionListener(e -> JOptionPane.showMessageDialog(frame, "Open clicked"));
        exitItem.addActionListener(e -> JOptionPane.showMessageDialog(frame, "Exit clicked"));

        // Add items to the File menu
        fileMenu.add(newItem);
        fileMenu.add(openItem);
        fileMenu.add(exitItem);

        // Create the Edit menu and its items
        JMenu editMenu = new JMenu("Edit");
        JMenuItem cutItem = new JMenuItem("Cut");
        JMenuItem copyItem = new JMenuItem("Copy");
        JMenuItem pasteItem = new JMenuItem("Paste");

        // Add action listeners for Edit menu items
        cutItem.addActionListener(e -> JOptionPane.showMessageDialog(frame, "Cut clicked"));
        copyItem.addActionListener(e -> JOptionPane.showMessageDialog(frame, "Copy clicked"));
        pasteItem.addActionListener(e -> JOptionPane.showMessageDialog(frame, "Paste clicked"));

        // Add items to the Edit menu
        editMenu.add(cutItem);
        editMenu.add(copyItem);
        editMenu.add(pasteItem);

        // Add menus to the menu bar
        menuBar.add(fileMenu);
        menuBar.add(editMenu);

        // Add the menu bar to the frame
        frame.setJMenuBar(menuBar);

        // Set frame visibility
        frame.setVisible(true);
    }
}