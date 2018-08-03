package ws5;



import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JRadioButton;

public class Part1 extends JFrame implements ActionListener, KeyListener, MouseListener {
	public static void main(String[] args) {
		new Part1();
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JButton calc, reset;
	private JRadioButton sum, mult;
	private TextField num, result;
	private JLabel numL, resultL;
	ArrayList<Double> list = new ArrayList<>();

	public Part1() {
		// Settings
		setVisible(true);
		setSize(450, 450);
		setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLayout(null);
		// Content
		calc = new JButton("Calculate");
		reset = new JButton("Reset");
		sum = new JRadioButton("Sum All");
		mult = new JRadioButton("Multiply All");
		num = new TextField();
		result = new TextField();
		numL = new JLabel("Number:");
		resultL = new JLabel("Result:");
		// Locate and Design
		numL.setSize(100, 20);
		numL.setLocation(100, 100);
		add(numL);

		num.setSize(120, 20);
		num.setLocation(200, 100);
		add(num);

		ButtonGroup group = new ButtonGroup();
		group.add(sum);
		group.add(mult);
		sum.setSize(100, 20);
		sum.setLocation(200, 130);
		add(sum);

		mult.setSize(100, 20);
		mult.setLocation(200, 150);
		add(mult);

		calc.setSize(100, 50);
		calc.setLocation(100, 180);
		add(calc);

		reset.setSize(100, 50);
		reset.setLocation(220, 180);
		add(reset);

		resultL.setSize(100, 20);
		resultL.setLocation(100, 250);
		add(resultL);

		result.setSize(120, 20);
		result.setLocation(200, 250);
		result.setEditable(false);
		add(result);

		num.addKeyListener(this);
		calc.addActionListener(this);
		reset.addActionListener(this);
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource().equals(num) && e.getKeyCode() == KeyEvent.VK_ENTER) {
			double number = Double.parseDouble(num.getText());
			list.add(number);
			num.setText("");
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource().equals(calc)&&sum.isSelected()) {
			if(!list.isEmpty()) result.setText(listSum(list)+"");
		}
		if(e.getSource().equals(calc)&&mult.isSelected()) {
			if(!list.isEmpty())	result.setText(listMul(list)+"");
		}
		if(e.getSource().equals(reset)){
			num.setText("");
			result.setText("");
			list.clear();
		}
	}
	
	public static double listSum(ArrayList<Double> x) {
		double sum=0;
		for(double y:x) {
			sum=sum+y;
		}
		return sum;
	}
	
	public static double listMul(ArrayList<Double> x) {
		double mul=1;
		for(double y:x) {
			mul=mul*y;
		}
		return mul;
	}

}
