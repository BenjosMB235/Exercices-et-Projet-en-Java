import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;


public class Factoriel extends Thread{
	int nClient;
	
	public void run(){
		try {
			ServerSocket ss=new ServerSocket(234);
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
						System.out.println(IP+" a envoyé "+nbr);
						try{
							int res=Integer.parseInt(nbr);
							if(res<0){
								pw.println("Erreur: le nombre doit etre positif");
								continue;
							}
							int fac=1;
							for(int i=1; i<=res; i++){
								fac=fac*i;
						    }
							pw.println("La factorielle de "+res+" est "+fac);
						
						
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
		new Factoriel().start();
	}

}
