package ws5;



import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class Part2 extends JFrame implements ActionListener, KeyListener, MouseListener {
	public static void main(String[] args) {
		new Part2();
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JButton calc, reset;
	private JCheckBox sum, mult;
	private TextField num;
	private JLabel numL;
	ArrayList<Double> list = new ArrayList<>();

	public Part2() {
		// Settings
		setVisible(true);
		setSize(450, 450);
		setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLayout(null);
		// Content
		calc = new JButton("Calculate");
		reset = new JButton("Reset");
		sum = new JCheckBox("Sum All");
		mult = new JCheckBox("Multiply All");
		num = new TextField();
		numL = new JLabel("Number:");
		// Locate and Design
		numL.setSize(100, 20);
		numL.setLocation(100, 100);
		add(numL);

		num.setSize(120, 20);
		num.setLocation(200, 100);
		add(num);

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
		if (e.getSource().equals(calc)) {
			if (!list.isEmpty() && mult.isSelected() && sum.isSelected())
				JOptionPane.showMessageDialog(this,
						"Addition: " + listSum(list) + System.lineSeparator() + "Multiplication: " + listMul(list));
			else if (sum.isSelected()) {
				if (!list.isEmpty())
					JOptionPane.showMessageDialog(this, "Addition: " + listSum(list));
			} else if (mult.isSelected()) {
				if (!list.isEmpty())
					JOptionPane.showMessageDialog(this, "Multiplication: " + listMul(list));

			}
		}

		else if (e.getSource().equals(reset)) {
			num.setText("");
			list.clear();
		}
	}

	public static double listSum(ArrayList<Double> x) {
		double sum = 0;
		for (double y : x) {
			sum = sum + y;
		}
		return sum;
	}

	public static double listMul(ArrayList<Double> x) {
		double mul = 1;
		for (double y : x) {
			mul = mul * y;
		}
		return mul;
	}

}
