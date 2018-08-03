package ws9;
import java.util.Random;

public class Data {
	private int[] array = new int[10];
	private int index=0;
	private Random ran;
	public Data() {
		ran=new Random();
	}
	public String printArray() {
		return "Array now looks like: "+"["+array[0]+", "+array[1]+", "+array[2]+", "+array[3]+", "+array[4]+", "+array[5]+", "
				+array[6]+", "+array[7]+", "+array[8]+", "+array[9]+"]";
	}
	public boolean hasSpace() {
		boolean ans=false;
		for (int i = 0; i < array.length; i++) {
			if(array[i]==0)
				ans=true;
			else ans=false;
		}
		return ans;
	}
	public synchronized void add() {
		printArray();
		int number = ran.nextInt(99)+1;

			if(hasSpace()) {
				if(index==10)index--;
				array[index]=number;
				System.out.println(Thread.currentThread().getName()+" put "+ number+ " in position " + index +"\t\t\t\t"+ printArray());
				index++;
			}
			
			if(index==9) {
				try {
					array[index]=number;
					System.out.println(Thread.currentThread().getName()+ " is waiting.");
					wait();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			notifyAll();
			
	}
	public synchronized void remove() {
			if(array[0]==0) {
				try {
					System.out.println(Thread.currentThread().getName()+ " is waiting.");
					wait();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				}

			if(array[9]!=0) {
				array[9]=0;
				System.out.println(Thread.currentThread().getName()+" deleted the element in position " + 9 +"\t\t"+ printArray());
				
			}
			else {
				if(index==0)index++;
				int temp=array[index-1];
				array[index-1]=0;
				System.out.println(Thread.currentThread().getName()+" deleted the element in position " + (index-1) +"\t\t"+ printArray());
				if(index!=0) {
				index--;}
				}
			notifyAll();
				


		}
	
	
	
	
}
