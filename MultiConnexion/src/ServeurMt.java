import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;


public class ServeurMt extends Thread{
	int nbClients;
	
	public void run(){
		try {
			ServerSocket ss=new ServerSocket(1234);
			//Connection of several clients at the same time
			while(true){
				Socket s=ss.accept();
				++nbClients;
				//Boot of each thread 
				new Conversation(s,nbClients).start();
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	class Conversation extends Thread{
		Socket socket;
		private int numeroClient;

		public Conversation(Socket socket, int num) {
			super();
			this.socket = socket;
			this.numeroClient = num;
		}
		public void run(){
			try {
				InputStream is=socket.getInputStream();
				InputStreamReader isr=new InputStreamReader(is);
				BufferedReader br=new BufferedReader(isr);
				
				OutputStream os=socket.getOutputStream();
				PrintWriter pw=new PrintWriter(os, true);
				
				//Recover the IP address Client
				String IP=socket.getRemoteSocketAddress().toString();
				System.out.println("Connexion du Client numero : "+numeroClient+"IP="+IP);
				pw.println("Vous etes le client numero "+numeroClient+IP);
				
				//Answer request
				while(true){
					String req;
					while((req=br.readLine())!= null){
						System.out.println(IP+" a envoyé "+req);
						String rep="Size"+req.length();
						pw.println(rep);
					}
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
	}
	public static void main(String[] args) {
		//boot thread
		new ServeurMt().start();
	}

}
