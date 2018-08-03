package ws6;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

public class MyTabs extends JFrame implements ActionListener, KeyListener {
	private JTabbedPane myPanes;
	private JPanel pValue;
	private JPanel pDraw;
	private JLabel txt;

	private DrawCircle x = new DrawCircle();

	private Random ran;
	JMenuBar menuBar;
	JMenu mProgram, mHelp;
	JMenuItem newCircle, exit, help, about;

	public MyTabs() {
		// Constructing Menu
		menuBar = new JMenuBar();

		mProgram = new JMenu("Program");
		newCircle = new JMenuItem("New Circle");
		exit = new JMenuItem("Exit");
		mProgram.add(newCircle);
		mProgram.add(exit);

		mHelp = new JMenu("Help");
		help = new JMenuItem("Help");
		about = new JMenuItem("About");
		mHelp.add(help);
		mHelp.add(about);

		menuBar.add(mProgram);
		menuBar.add(mHelp);

		newCircle.addActionListener(this);
		exit.addActionListener(this);
		help.addActionListener(this);
		about.addActionListener(this);

		// Constructing Panels
		myPanes = new JTabbedPane();

		pValue = new JPanel();

		pDraw = new JPanel();
		pDraw.setBackground(Color.GRAY);
		pDraw.setLayout(new BorderLayout());

		pDraw.add(x);

		myPanes.add("Circles", pDraw);

		myPanes.add("Values", pValue);

		txt = new JLabel("x: " + x.getCircle().getX() + " y: " + x.getCircle().getY() + " radius: "
				+ x.getCircle().getR() + " red: " + x.getCircle().getC().getRed() + " green: "
				+ x.getCircle().getC().getGreen() + " blue: " + x.getCircle().getC().getBlue());
		pValue.add(txt);

		// Constructing Frame
		setLayout(new BorderLayout());

		add(myPanes);
		setJMenuBar(menuBar);
		myPanes.addKeyListener(this);
		setSize(500, 500);
		setTitle("Draw and See");
		setVisible(true);
		setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	public static void main(String[] args) {
		new MyTabs();
	}

	public void actionPerformed(ActionEvent e) {
		
		if (e.getActionCommand().equals("New Circle")) {
			pDraw.remove(x);
			x = new DrawCircle();
			pDraw.add(x);
			pDraw.repaint();
			
			//to update values after new circle
			txt.setText("x: " + x.getCircle().getX() + " y: " + x.getCircle().getY() + " radius: " + x.getCircle().getR()
					+ " red: " + x.getCircle().getC().getRed() + " green: " + x.getCircle().getC().getGreen() + " blue: "
					+ x.getCircle().getC().getBlue());
			pValue.repaint();
		}
		
		if (e.getActionCommand().equals("Exit")) {
			System.exit(1);
		}
		
		if (e.getActionCommand().equals("Help")) {
			JOptionPane.showMessageDialog(null, "w key, the circle moves up in the first tab,\n" + 
					"s key, the circle moves down in the first tab,\n" + 
					"a key, the circle moves right in the first tab,\n" + 
					"d key, the circle moves right in the first tab,\n" + 
					"c key, the circle’s color changes randomly in the first tab,\n" + 
					"up arrow key, the circle’s radius gets larger in the first lab,\n" + 
					"down arrow key, the circle’s radius gets smaller in the first lab,\n" + 
					"and values are updated in second tab.");
		}
		
		if (e.getActionCommand().equals("About")) {
			JOptionPane.showMessageDialog(null,"The author is Burak Demirel, \n"+"The program version is 1.0,\n"+"Made at 7/12/2018.");
		}
		
	}

	public void keyPressed(KeyEvent e) {
	}

	public void keyReleased(KeyEvent e) {

		if (KeyEvent.getKeyText(e.getKeyCode()).equals("C")) {
			ran = new Random();
			int r = ran.nextInt(255);
			int g = ran.nextInt(255);
			int b = ran.nextInt(255);
			Color c = new Color(r, g, b);
			x.getCircle().setC(c);
			pDraw.repaint();
		}

		if (KeyEvent.getKeyText(e.getKeyCode()).equals("Up")) {
			x.getCircle().setR(x.getCircle().getR() + 5);
			pDraw.repaint();
		}
		if (KeyEvent.getKeyText(e.getKeyCode()).equals("Down")) {
			x.getCircle().setR(x.getCircle().getR() - 5);
			pDraw.repaint();
		}
		if (KeyEvent.getKeyText(e.getKeyCode()).equals("W")) {
			x.getCircle().setY(x.getCircle().getY() - 5);
			pDraw.repaint();
		}
		if (KeyEvent.getKeyText(e.getKeyCode()).equals("S")) {
			x.getCircle().setY(x.getCircle().getY() + 5);
			pDraw.repaint();
		}
		if (KeyEvent.getKeyText(e.getKeyCode()).equals("A")) {
			x.getCircle().setX(x.getCircle().getX() - 5);
			pDraw.repaint();
		}
		if (KeyEvent.getKeyText(e.getKeyCode()).equals("D")) {
			x.getCircle().setX(x.getCircle().getX() + 5);
			pDraw.repaint();
		}

		txt.setText("x: " + x.getCircle().getX() + " y: " + x.getCircle().getY() + " radius: " + x.getCircle().getR()
				+ " red: " + x.getCircle().getC().getRed() + " green: " + x.getCircle().getC().getGreen() + " blue: "
				+ x.getCircle().getC().getBlue());
		pValue.repaint();
	}

	public void keyTyped(KeyEvent e) {
	}
}
