import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;


public class SuiteFibonacci extends Thread{
	int nClient;
	
	public void run(){
		try {
			ServerSocket ss=new ServerSocket(61134);
			//connection of several clients at the same time
			while(true){
				Socket s=ss.accept();
				++nClient;
				//Boot of each thread
				new Conversation(s,nClient).start();
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	class Conversation extends Thread{
		Socket socket;
		private int numClient;
		
		public Conversation(Socket socket, int num){
			super();
			this.socket=socket;
			this.numClient=num;
		}
		
		public void run(){
			try {
				InputStream is = socket.getInputStream();
				InputStreamReader isr=new InputStreamReader(is);
				BufferedReader br=new BufferedReader(isr);
				
				OutputStream os=socket.getOutputStream();
				PrintWriter pw=new PrintWriter(os, true);
				
				String IP=socket.getRemoteSocketAddress().toString();
				System.out.println("Connexion du Client numero : "+numClient+" IP="+IP);
				pw.println("Vous etes le client numero "+numClient+IP);
				
				while(true){
					String nbr;
					
					while((nbr=br.readLine())!=null){
						System.out.println(IP+" a envoy� "+nbr);
						try{
							int res=Integer.parseInt(nbr);
							if(res<0){
								pw.println("Erreur: le nombre doit etre positif");
								continue;
							}
							int f0=0;
							int f1=1;
							int f=0;
							for(int i=2; i<=res; i++){
								f=f0+f1;
								f0=f1;
								f1=f;
						    }
							pw.println("On a f("+res+")="+f);
						
						
						}catch(NumberFormatException e){
							pw.println("Erreur : Format de nombre non valide "+nbr);
						}
						
						
					}
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new SuiteFibonacci().start();
	}

}