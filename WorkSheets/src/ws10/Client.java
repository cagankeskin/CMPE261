package ws10;

//I am Ibrahim Dogan and worked with Bariscan Akyilmaz and Hanifi Enes Gul

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client {
	public static void main(String[] args) {
		Socket mySocket = null;
		DataOutputStream os= null;
		DataInputStream is= null;
				try {
					mySocket= new Socket(args[0], Integer.parseInt(args[1]));
					os= new DataOutputStream(mySocket.getOutputStream());
					is= new DataInputStream(mySocket.getInputStream());
				}
				catch (UnknownHostException e) {
					// TODO: handle exception
					System.out.println("Unknown host..");
				}
				catch (IOException e) {
					// TODO: handle exception
					System.out.println("I/O exception");
				}
				
				if(mySocket !=null && os!=null && is!=null) {
					try {
						os.writeUTF(args[2]+" "+args[3]);
						
						String responseLine;
						while ((responseLine=is.readUTF())!=null) {
							System.out.println("Server: "+responseLine);
							if(responseLine.indexOf("OK") != -1) {
								break;
							}
						}
						
						os.close();
						is.close();
						mySocket.close();
						
					}
					catch(UnknownHostException e) {
						
					}
					catch (IOException e) {
						// TODO: handle exception
					}
				}
				
	}

}
