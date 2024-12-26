import java.util.Scanner;


public class Point {
	double X;
	double Y;

	public Point(double X, double Y) {
		this.X=X;
		this.Y=Y;
	}
	double getPointX(){
		return this.X;
	}
	double getPointY(){
		return this.Y;
	}
	void setPoint(double X, double Y){
		this.X=X;
		this.Y=Y;
	}
	public static void MemeSegment(Point A, Point B, Point C){
		double AB;
		double AC;
		
		//Calcul des coefficients directeurs :
		AB=((B.Y-A.Y)/(B.X-A.X));
		AC=((C.Y-A.Y)/(C.X-A.X));
		
		if(AB==AC){
			System.out.println("Les 3 points appartiennent au m�me segment");
		}else{
			System.out.println("Les 3 points n'appartiennent pas au m�me segment");
		}
		
	}
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("Entrer les coordonn�es de trois points d'un rep�re orthonorm� : ");
	
		System.out.println("Premier point A :");
		double xa=sc.nextDouble();
		double ya=sc.nextDouble();
		Point A=new Point(xa,ya);
		System.out.println("Deuxi�me point B :");
		double xb=sc.nextDouble();
		double yb=sc.nextDouble();
		Point B=new Point(xb,yb);
		System.out.println("Troisi�me point C :");
		double xc=sc.nextDouble();
		double yc=sc.nextDouble();
		Point C=new Point(xc,yc);
		System.out.println("Point("+A.getPointX()+","+A.getPointY()+")");
		System.out.println("Point("+B.getPointX()+","+B.getPointY()+")");
		System.out.println("Point("+C.getPointX()+","+C.getPointY()+")");
		
		MemeSegment(A,B,C);

	}

}
