package ws4;

import java.awt.*;
import javax.swing.*;

public class BorderL {
	

	 public static void main(String[] args) {

	 JFrame f = new JFrame("Test GUI");
	 f.setSize(300, 300);
	 Container content = f.getContentPane();
	 content.setLayout(new BorderLayout());
	 content.add(new JButton("Button 1"),BorderLayout.EAST);
	 content.add(new JButton("Button 2"),BorderLayout.WEST);
	 content.add(new JRadioButton("Button 3"),BorderLayout.CENTER);
	 content.add(new JLabel("Label"),BorderLayout.SOUTH);
	 content.add(new JTextArea("TextArea"),BorderLayout.BEFORE_FIRST_LINE);

	 f.setVisible(true);
	 }
	
	}

