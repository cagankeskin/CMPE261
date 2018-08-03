package ws6;

import java.awt.Color;
import java.util.Random;

public class Circle {
	private int x;
	private int y;
	private int r;
	private Color c;
	private Random ran;

	public Circle() {
		ran = new Random();
		x = (ran.nextInt(300) + 5);
		y = (ran.nextInt(300) + 5);
		r = (ran.nextInt(200) + 50);
		c = new Color(ran.nextInt(255), ran.nextInt(255), ran.nextInt(255));
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

	public void setC(Color c) {
		this.c = c;
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

	public Color getC() {
		return c;
	}

}
