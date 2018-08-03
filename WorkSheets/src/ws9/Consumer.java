package ws9;
public class Consumer extends Thread {
	private Data data;
	public Consumer(Data data) {
		this.data=data;
	}
	
	public void run() {
		while(true) {
			try {
				sleep(300);
				data.remove();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
