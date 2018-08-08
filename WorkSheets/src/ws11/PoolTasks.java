package ws11;

import java.util.Random;
import java.util.concurrent.locks.ReentrantLock;

public class PoolTasks implements Runnable {

	private Random ran;
	private int number;
	ReentrantLock lock =new ReentrantLock();
	
	public PoolTasks() {
		ran = new Random();
		number=100;
	}

	@Override
	public void run() {
		int worktime=ran.nextInt(10000);
		try {
			lock.lock();
			System.out.println("Thread " + Thread.currentThread().getId() + " will work for " + worktime + " miliseconds. Job:#"+number);
			number--;
			lock.unlock();
			Thread.currentThread().sleep(worktime);
			System.out.println("Thread " + Thread.currentThread().getId() + " finished its work.");

		} catch (InterruptedException e) {
			// TODO: handle exception
		}

	}

}
