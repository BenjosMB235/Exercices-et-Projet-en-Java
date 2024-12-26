import java.util.Scanner;


public class Minimum4 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		System.out.println("Entre quatres valeurs :");
		int a=sc.nextInt();
		int b=sc.nextInt();
		int c=sc.nextInt();
		int d=sc.nextInt();
		System.out.println("Le minimum est : "+minimum(a,b,c,d));
		

	}
	static int minimum(int a, int b){
		return a<b?a:b;
		
	}
	static int minimum(int a, int b, int c, int d){
		int f= minimum(a, b);
		int e= minimum(c, d);
		return f<e?f:e;
	}

}
