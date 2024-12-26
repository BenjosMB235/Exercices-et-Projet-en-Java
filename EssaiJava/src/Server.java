import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;



public class Server {

	
	public static void main(String[] args) {
		try {
			ServerSocket ss=new ServerSocket(1234);
			Socket s=ss.accept();
			
			InputStream is=s.getInputStream();
			InputStreamReader isr=new InputStreamReader(is);
			BufferedReader br=new BufferedReader(isr);
			
			OutputStream os=s.getOutputStream();
			PrintWriter pw=new PrintWriter(os, true);
			String nom=br.readLine();
			pw.println("Bonjour M."+nom);
			
			String str=br.readLine();
			
			int nb=Integer.parseInt(str);
			nb=nb*8;
			System.out.println("Envoi de résultat.");
			pw.println(nb);
			
			/*ServerSocket ss=new ServerSocket(1234);
			System.out.println("J'attends la connexion d'un client");
			Socket s=ss.accept();
			
			InputStream is=s.getInputStream();
			OutputStream os=s.getOutputStream();
			System.out.println("J'attends un nombre");
			int nbr=is.read();
			int resp=nbr*8;
			System.out.println("J'envoie la réponse");
			os.write(resp);*/
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
