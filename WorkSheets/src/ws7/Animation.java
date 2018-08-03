package ws7;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;
import java.util.concurrent.Semaphore;

import javax.swing.JFrame;
import javax.swing.JPanel;
//I'm Ibrahim Dogan worked with Bariscan Akyilmaz and Recep Goger
class Rectangle{
	Semaphore s;
	int x,y,wh,speed;
	Color c;
	Random rand=new Random();
	public Rectangle(){
		//this.s=s;
		speed=rand.nextInt(5)+1;
		x=rand.nextInt(400);
		y=rand.nextInt(1);
		wh=rand.nextInt(50)+50;
		c=new Color(rand.nextInt(255),rand.nextInt(255),rand.nextInt(255));
	}
	public int getX() {
		return x;
	}
	public int getY() {
		return y;
	}
	public int getWh() {
		return wh;
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
	public void setWh(int wh) {
		this.wh = wh;
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
	int speed=5;
	Semaphore semaphore=new Semaphore(1);
	Rectangle[] rects;
	
	public Animation(int x){
		rects=new Rectangle[x];
		for (int i = 0; i < rects.length; i++) {
			rects[i]=new Rectangle();
			Thread t=new Thread(this);
			t.setName(i+"");
			t.start();
		}
	}
	
	@Override
	public void run() {
		while(true){
			int index=Integer.parseInt(Thread.currentThread().getName());
			
							
				
				
				try {
					Thread.currentThread().sleep(20);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				rects[index].setY(rects[index].getSpeed()+rects[index].getY());
				repaint();

				
			}

			
			
			
			
			
			
			
			
			
			
			
			
		
	}
	
	public void paint(Graphics g){
	
		super.paint(g);
		for(Rectangle r:rects){
			g.setColor(r.getC());
			g.fillRect(r.getX(), r.getY()+speed, r.getWh(), r.getWh());
		}
	}
	
	public static void main(String[] args) {
		JFrame a= new JFrame("Animation");
		a.setVisible(true);
		a.setSize(500, 500);
		a.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Animation animation=new Animation(Integer.parseInt("10"));
		a.add(animation);
		
	}
	
}
