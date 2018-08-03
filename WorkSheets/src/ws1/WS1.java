package ws1;
public class WS1 {
	/*
	 * I am İbrahim Doğan
	 * the others:
	 * Ersan Kurtuluş
	 * Burak Tatar
	 */
	public static int fib(int n){
		if(n==0) return 0;
		else if(n==1) return n;
		else return fib(n-1)+fib(n-2);
	}
	public static int countLower(String str){
		int n=0;
		for(int i=0;i<str.length();i++){
			 if ((Character.isLowerCase(str.charAt(i)))) n++;
		}
		return n;
	}
	
	public static int mostFreq(int[]x) {
	    int temp = x[0];
	    int maxCount = 0;
	    for (int i = 0; i < x.length; i++) {
	        int temp2 = x[i];
	        int count = 1;
	        for (int j = 0; j < x.length; j++) {
	            if (x[j] == temp2) count++;
	            if (count > maxCount) {
	                temp = temp2;
	                maxCount = count;
	            }
	        }
	    }
	    return temp;
	}
	
	public static void main(String[] arg){
		System.out.println("-----Question 1----- fib(3) fib(6)");
		System.out.println(fib(3));
		System.out.println(fib(6));
		System.out.println("-----Question 2-----");
		System.out.println(countLower("Breathe properly. Stay curious. And eat your beets."));
		System.out.println(countLower("Hello World!"));
		System.out.println(countLower("Abraham"));
		System.out.println("-----Question 3-----{1,2,3,3,4,4,4,5,6,6}");
		int[] x={1,2,3,3,4,4,4,5,6,6};
		System.out.println(mostFreq(x));
	}
}
