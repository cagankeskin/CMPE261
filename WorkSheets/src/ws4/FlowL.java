package ws4;

import javax.swing.JFrame;
import java.awt.*;
import javax.swing.*;

public class FlowL {
	

	 public static void main(String[] args) {

	 JFrame f = new JFrame("Test GUI");
	 f.setSize(300, 300);
	 Container content = f.getContentPane();
	 content.setLayout(new FlowLayout());
	 content.add(new JButton("Button 1"));
	 content.add(new JButton("Button 2"));
	 content.add(new JButton("Button 3"));
	 content.add(new JRadioButton("Button 4"));
	 content.add(new JTextArea("   This is TextArea   "));
	 content.add(new JLabel("Label"));
	 f.setVisible(true);
	 }
	
	}

