package ws4;

import java.awt.*;
import javax.swing.*;

public class nullL {
	

	 public static void main(String[] args) {

	 JFrame f = new JFrame("Test GUI");
	 f.setSize(300, 300);
	 Container content = f.getContentPane();
	 content.setLayout(null);
	 JButton b1=new JButton("Button 1");
	 JButton b2=new JButton("Button 2");
	 JButton b3= new JButton("Button 3");
	 JRadioButton b4= new JRadioButton("Button 4");
	 JTextArea b5=new JTextArea("TextArea");
	 JLabel b6=new JLabel("Label");
	 
	 b1.setSize(100, 100);
	 b2.setSize(100, 100);
	 b3.setSize(100, 100);
	 b4.setSize(100, 50);
	 b5.setSize(100, 50);
	 b6.setSize(100, 100);
	 b1.setLocation(0, 0);
	 b2.setLocation(100, 0);
	 b3.setLocation(200, 0);
	 b4.setLocation(0, 100);
	 b5.setLocation(150, 150);
	 b6.setLocation(0, 150);
	 content.add(b1);
	 content.add(b2);
	 content.add(b3);
	 content.add(b4);
	 content.add(b5);
	 content.add(b6);
	 
	 f.setVisible(true);
	 }
	
	}

