import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;


public class Client {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			Socket s=new Socket("localhost", 1234);
			
			InputStream is=s.getInputStream();
			InputStreamReader isr=new InputStreamReader(is);
			BufferedReader br=new BufferedReader(isr);
			
			OutputStream os=s.getOutputStream();
			PrintWriter pw=new PrintWriter(os, true);
			
			Scanner scr=new Scanner(System.in);
			System.out.println("Veuillez entrer votre nom :");
			String nom=scr.nextLine();
			pw.println(nom);
			String rep=br.readLine();
			System.out.println(rep);
			
			System.out.println("Veuillez entrer un nombre  :");
			String nb=scr.nextLine();
			pw.println(nb);
			String rep1=br.readLine();
			System.out.println(nb+" * 8 est egal a  : "+rep1);
			
			
						
			/*InputStream is=s.getInputStream();
			OutputStream os=s.getOutputStream();
			
			Scanner scanner=new Scanner(System.in);
			System.out.print("Entrez un nombre :");
			int nb=scanner.nextInt();
			os.write(nb);
			int resu=is.read();
			System.out.println("Résultat"+resu);*/
			
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
