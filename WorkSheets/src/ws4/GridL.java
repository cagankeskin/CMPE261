package ws4;

import java.awt.*;
import javax.swing.*;

public class GridL {
	

	 public static void main(String[] args) {

	 JFrame f = new JFrame("Test GUI");
	 f.setSize(300, 300);
	 Container content = f.getContentPane();
	 content.setLayout(new GridLayout());
	 content.add(new JButton("Button 1"));
	 content.add(new JButton("Button 2"));
	 content.add(new JButton("Button 3"));
	 content.add(new JRadioButton("Button 4"));
	 content.add(new JTextArea("   This is TextArea   "));
	 content.add(new JLabel("Label"));
	 f.setVisible(true);
	 }
	
	}

