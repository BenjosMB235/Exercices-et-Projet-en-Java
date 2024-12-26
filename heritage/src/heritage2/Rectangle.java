package heritage2;

public class Rectangle extends Forme {
	private int largeur;
	private int longueur;
	
	public Rectangle(int largeur, int longueur) {
		this.largeur=largeur;
		this.longueur=longueur;
	}
	public int getLargeur(){
		return largeur;
	}
	public int getLongueur(){
		return longueur;
	}
	public int surface(){
		return largeur*longueur;
	}
	public String afficheRec(){
		return "Rectangle de longueur "+longueur+" et de largeur "+largeur;
	}

}
