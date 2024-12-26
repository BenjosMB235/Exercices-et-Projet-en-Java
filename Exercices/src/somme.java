import java.util.Scanner;


public class somme {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		System.out.println("Entrer deux valeurs : ");
		int a=sc.nextInt();
		int b=sc.nextInt();
		int som=a+b;
		System.out.println("La somme de " +a+" + "+ b + " est égale à " + som);
		
		if (a>b)
			System.out.println("La plus grande valeur est "+a+ " et la plus petite est "+b);
		else
			System.out.println("La plus grande valeur est "+b+ " et la plus petite est "+a);

	
	}

}
