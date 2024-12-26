import java.util.Scanner;


public class BoucleFor {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int i, n, som;
		som=0;
		Scanner ss= new Scanner(System.in);
		for(i=0;i<4;i++){
			System.out.println ("Donnez un entier :");
			n= ss.nextInt();
			som += n;
		}System.out.println ("Somme :"+som);
	}

}
