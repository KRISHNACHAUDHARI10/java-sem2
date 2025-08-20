package today;
import javax.swing.*;
import java.util.EventListener;
import java.awt.event.*;

import java.awt.color.*;



public class  Form extends JFrame  {
	  private JTextField texfield;
	  private JButton button;
	  private JLabel label;
	  
	  
public Form(){
   		   
 	  
	JFrame  framj = new   JFrame("krishna application");
	framj.setSize(400,400);
	framj.setLayout(null);
	 
	JTextField texfield  = new JTextField();
	texfield.setBounds(15,60,200, 30);
	framj.add(texfield);
	 
	JButton button = new JButton("Submit form");
	button.setBounds(15,500,200, 30);
	framj.add(button);
	
	JLabel label = new JLabel();
	label.setBounds(15,150,200, 30);
	framj.add(label);
	
	 button.addActionListener(new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {
		  label.setText(texfield.getText());	
			}
		});
	 
	 framj.setVisible(true);
    }
public static void main(String[] args) {
	Form  fm = new Form();    
  	  
  }
}
