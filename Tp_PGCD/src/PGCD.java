import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;


public class PGCD extends Thread{
	int nClient;
	
	public void run(){
		try {
			ServerSocket ss=new ServerSocket(1234);
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
					String nbr2;
					
					while(((nbr=br.readLine())!=null) && ((nbr2=br.readLine())!= null)){
						System.out.println(IP+" a envoyé "+nbr+" et "+nbr2);
						try{
							int res=Integer.parseInt(nbr);
							int res2=Integer.parseInt(nbr2);
							if((res<0)||(res2<0)){
								pw.println("Erreur: les nombre doivent etre positif");
								continue;
							}
							int reste=res%res2;
							//int quotien=res/res2;
							
							while(reste!=0){
								reste=res%res2;
								//quotien=res/res2;
								if(reste != 0){
									res=res2;
									res2=reste;
								}
							}
							pw.println("Le PGCD est "+res2);
						
						
						}catch(NumberFormatException e){
							pw.println("Erreur : Format de l'un des nombres est non valide ");
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
		new PGCD().start();
	}

}
