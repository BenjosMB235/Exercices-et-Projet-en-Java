
public class cercle {
	 double rayon;
	 double x, x2;
	 double y, y2;
	 Point Centre=new Point(x,y);
	 Point PointCercle=new Point(x2,y2);
	 Point getCentre(){
		 return this.Centre;
	 }
	 Point getPointCercle(){
		 return this.PointCercle;
	 }
	 void setCentre(double x, double y){
		 Centre.X=x;
		 Centre.Y=y;
	 }
	 void setPointCercle(double x, double y){
		 PointCercle.X=x;
		 PointCercle.Y=y;
	 }

	public cercle(double r, double x, double y) {
		this.rayon=r;
		this.Centre.X=x;
		this.Centre.Y=y;
	}
	public double surface(){
		double res=Math.PI*(Math.pow((this.rayon), 2));
		return res;
	}
	public double perimetre(){
		double res=2*Math.PI*(this.rayon);
		return res;
	}
	public void PointDuCercle(double x, double y){
		this.PointCercle.X=x;
		this.PointCercle.Y=y;
		if ((Math.pow(((this.Centre.X)-(this.PointCercle.X)), 2)+ (Math.pow(((this.Centre.Y)-(this.PointCercle.Y)), 2))==Math.pow((this.rayon), 2))){
			System.out.println("Le point appartient au cercle");
		}else{
			System.out.println("Le point n'appartient pas au cercle");
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	//	Point C=new Point(4,3);
		cercle C=new cercle(4, 0, 0);
		cercle D=new cercle(2, 3, 3);
		System.out.println("les surfaces des cercles sont "+C.surface()+" et "+D.surface());
		System.out.println("les perimetres des cercles sont "+C.perimetre()+" et "+D.perimetre());
		C.PointDuCercle(4, 0);
		

	}

}
