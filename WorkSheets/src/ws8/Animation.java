package ws8;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;
import java.util.concurrent.Semaphore;

import javax.swing.JFrame;
import javax.swing.JPanel;

class Oval {
	int x, y, r, speed;
	Color c;
	Random rand = new Random();

	public Oval() {
		speed = rand.nextInt(5) - 5;
		x = rand.nextInt(400);
		y = 425;
		r = 50;
		c = new Color(rand.nextInt(255), rand.nextInt(255), rand.nextInt(255));
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public int getR() {
		return r;
	}

	public int getSpeed() {
		return speed;
	}

	public void setX(int x) {
		this.x = x;
	}

	public void setY(int y) {
		this.y = y;
	}

	public void setR(int r) {
		this.r = r;
	}

	public void setSpeed(int speed) {
		this.speed = speed;
	}

	public void setC(Color c) {
		this.c = c;
	}

	public void setRand(Random rand) {
		this.rand = rand;
	}

	public Color getC() {
		return c;
	}

	public Random getRand() {
		return rand;
	}
}

public class Animation extends JPanel implements Runnable {
	int speed = 5;
	Oval[] ovals;
	Semaphore s;

	public Animation(int x, int y) {
		ovals = new Oval[x];
		this.s = new Semaphore(y);
		for (int i = 0; i < ovals.length; i++) {
			ovals[i] = new Oval();
			Thread t = new Thread(this);
			t.setName(i + "");
			t.start();
		}
	}

	@Override
	public void run() {
		while (true) {
			try {
				int index = Integer.parseInt(Thread.currentThread().getName());
				
				s.acquire();

				while (!(ovals[index].getY() < 0)) {
					ovals[index].setY(ovals[index].getSpeed() + ovals[index].getY());
					Thread.sleep(20);
					repaint();
				}
				if (ovals[index].getY() < 0) {
					s.release();
					ovals[index].setY(-300);
				}

			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
	}

	public void paint(Graphics g) {

		super.paint(g);
		for (Oval r : ovals) {
			g.setColor(r.getC());
			g.fillOval(r.getX(), r.getY() + speed, r.getR(), r.getR());
		}
	}

	public static void main(String[] args) {
		
		int noOfShapes = Integer.parseInt(args[0]);
		int limit = Integer.parseInt(args[1]);
		Animation animation = new Animation(noOfShapes, limit);
		
		
		JFrame a = new JFrame("Animation");
		a.setVisible(true);
		a.setSize(500, 500);
		a.setDefaultCloseOperation(a.EXIT_ON_CLOSE);
		a.add(animation);
		
	}

}
