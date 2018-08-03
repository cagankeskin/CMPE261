import java.awt.Graphics;
import java.util.List;

import javax.swing.JPanel;

public class DrawChart extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	int q1, q2, p, m, f, a;

	public DrawChart(List<Student> listStudents) {

		int q1 = 0, q2 = 0, p = 0, m = 0, f = 0, counter = 0;
		int a = 1;
		for (Student y : listStudents) {
			q1 = q1 + (int) y.getQ1();
			q2 = q2 + (int) y.getQ2();
			p = p + (int) y.getP();
			m = m + (int) y.getM();
			f = f + (int) y.getF();
			counter++;
		}
		if (counter != 0) {
			q1 = q1 / counter;
			q2 = q2 / counter;
			p = p / counter;
			m = m / counter;
			f = f / counter;
			a = (q1 + q2 + p + m + f) / 5;
			this.q1 = q1 * 3;
			this.q2 = q2 * 3;
			this.p = p * 3;
			this.m = m * 3;
			this.f = f * 3;
			this.a = a * 3;
		}

	}

	public void paint(Graphics g) {
		super.paint(g);
		g.fillRect(100, 350 - q1, 50, 1 + q1);
		g.fillRect(250, 350 - q2, 50, 1 + q2);
		g.fillRect(400, 350 - p, 50, 1 + p);
		g.fillRect(550, 350 - m, 50, 1 + m);
		g.fillRect(700, 350 - f, 50, 1 + f);
		g.fillRect(850, 350 - a, 50, 1 + a);

		g.drawString("Quiz1", 100, 375);
		g.drawString("Quiz2", 250, 375);
		g.drawString("Project", 400, 375);
		g.drawString("Midterm", 550, 375);
		g.drawString("Final", 700, 375);
		g.drawString("Average", 850, 375);

	}
}
