package ws5;



import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class Part3 extends JFrame implements ActionListener, KeyListener, MouseListener {
	public static void main(String[] args) {
		new Part3();
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private TextField num;
	private TextField result;
	private JLabel numL, resultL;
	ArrayList<Double> list = new ArrayList<>();

	public Part3() {
		// Settings
		setVisible(true);
		setSize(450, 450);
		setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLayout(null);
		// Content
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

		resultL.setSize(100, 20);
		resultL.setLocation(100, 250);
		add(resultL);

		result.setSize(120, 20);
		result.setLocation(200, 250);
		result.setEditable(false);
		add(result);

		num.addKeyListener(this);
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
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		if(num.getText().length()>0){
			toOctal();
		}
		else num.setText("");

	}
	
	public void toOctal() {
		result.setText(Integer.toOctalString(Integer.parseInt(num.getText())));
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
	}
	
}
