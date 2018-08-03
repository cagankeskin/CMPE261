package ws9;

//I am Ibrahim Dogan i worked with Tugberk Goc and Bariscan Akyilmaz

public class Test {
	public static void main(String[] args) {
		Data d=new Data();
		Producer p= new Producer(d);
		Producer p1= new Producer(d);
		Consumer c= new Consumer(d);
		Consumer c1= new Consumer(d);
		p.setName("Producer 1");
		p1.setName("Producer 2");
		c.setName("Consumer 1");
		c1.setName("Consumer 2");
		p.start();
		p1.start();
		c.start();
		c1.start();
	}
}
