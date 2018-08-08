package ws11;


import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class TestPool {

	// Create ExecutorService to manage threads
	private ExecutorService executor;
	
	public TestPool() {
		executor= Executors.newFixedThreadPool(3); // size is 3
	}
	
	public void startTasks() {
		PoolTasks task=new PoolTasks();
		
			// we have such 100 number of tasks....
		for(int i=0;i<100;i++) {
			executor.execute(task);
		}
		executor.shutdown();
	}
	
	public static void main(String[] args) {
		TestPool t = new TestPool();
		t.startTasks();

	}

}
