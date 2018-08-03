package ws6;

import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class DrawCircle extends JPanel {
	private Circle circle;

	public DrawCircle() {
		circle = new Circle();
	}

	public Circle getCircle() {
		return circle;
	}

	public void paint(Graphics g) {
		super.paint(g);
		
		g.setColor(circle.getC());
		g.fillOval(circle.getX(), circle.getY(), circle.getR(), circle.getR());
		
	}

}
