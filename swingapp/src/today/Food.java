package today;
import javax.swing.*;
import java.util.EventListener;
import java.awt.event.*;
public class Food  extends JFrame{
	
private  JLabel  label,imagelabel;
private  JCheckBox box1box2,box3;
private  JButton  button;

public Food() {
	   
	 JFrame  framj = new JFrame("application");
	 framj.setSize(400,400);
	 framj.setVisible(true);
	 framj.setLayout(null);
	   
	 ImageIcon Icon = new ImageIcon("D:\\myeclipswork'\\Adovbeweb\\oops\\AAnimal\\swingapp\\src\\swingapp\\Screenshot 2025-01-19 221034.png");
	 imagelabel = new JLabel(Icon);
	 imagelabel.setBounds(100,50,350,50);
	 framj.add(imagelabel);
	 
	 JCheckBox box1 = new JCheckBox("Cake -- 100");
	 box1.setBounds(100,100,200,30);
	 framj.add(box1);
    
	 
	 JCheckBox box2 = new JCheckBox("Bread -- 200");
	 box2.setBounds(100,150,200,30);
	 framj.add(box2);
   
	 JCheckBox box3 = new JCheckBox("Chai -- 300");
	 box3.setBounds(100,200,200,30); 
	 framj.add(box3);
	 
	 JButton button = new JButton("Addtocart");
	 button.setBounds(100,250,200,30);
	 framj.add(button);
	 
	 button.addActionListener(new ActionListener() {
		 public void actionPerformed(ActionEvent e) {
			    String msg ="";
				    int  total = 0;
				 
			    if(box1.isSelected()) {
			    	total+=100;
			    	msg+="Cake -- 100\n";  
			    }
			    if(box2.isSelected()) {
			    	total+=200;
			    	msg+="Bread -- 200\n";  
			    }
			    if(box3.isSelected()) {
			    	total+=300;
			    	msg+="Chai -- 300\n";  
			    }
			    
			    
			    msg += "-------------\nTotal  " + total;
            JOptionPane.showMessageDialog(Food.this,msg);
		  }
		 
		 
	 });
	
	 
   
   }
 public static void main(String[] args) {
	 Food  food = new Food(); 
	 
 }

}
