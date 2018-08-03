package ws9;
public class Producer extends Thread {
	private Data data;
	public Producer(Data data) {
		this.data=data;
	}
	
	public void run() {
		while(true) {
			try {
				sleep(500);
				data.add();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
