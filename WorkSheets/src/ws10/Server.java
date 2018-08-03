package ws10;

//I am Ibrahim Dogan and worked with Bariscan Akyilmaz and Hanifi Enes Gul

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
	
	public static int findFact(int n){
		int result=1;
		for (int i = 1; i <= n; i++) {
			result=result*i;
		}
		return result;
	}
	
	public static boolean isPrime(int n) {
		if(n==2) return true;
		else if (n%2==0) return false;
	    //if not, then just check the odds
	    for(int i=3;i*i<=n;i+=2) {
	        if(n%i==0)
	            return false;
	    }
	    return true;
	}
	
	public static void main(String[] args) {
		ServerSocket myServer = null;
		String line= null;
		DataInputStream is;
		DataOutputStream os;
		Socket mySocket=null;
		while(true){
		try {
			myServer= new ServerSocket(Integer.parseInt(args[0]));
			
		}
		catch (IOException e) {
			// TODO: handle exception
			System.out.println(e);
		}
		
		try {
			System.out.println("Server is waiting");
			mySocket= myServer.accept();
			System.out.println("Server is has a connection");
			is= new DataInputStream(mySocket.getInputStream());
			os= new DataOutputStream(mySocket.getOutputStream());
			while(true) {
				line= is.readUTF();
				String[] calc=line.split(" ");
				if(calc[0].equals("findFactorial")){
					line="Factorial of "+calc[1]+": "+findFact(Integer.parseInt(calc[1]));
				}
				else if(calc[0].equals("isPrime")){
					line="Is "+calc[1]+" prime? :"+isPrime(Integer.parseInt(calc[1]));
				}
				os.writeUTF(line);
			}
		}
		catch (IOException e) {
			// TODO: handle exception
		}
		}
	}
	

}
