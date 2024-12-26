package heritage2;

public class Carre extends Rectangle {
	

	public Carre(int c) {
		super(c,c);
	}
	public String affiche(){
		return "Carré de côté "+getLargeur();
	}
	/*public String afficheRec(){
		return "Rectangle de longueur "+getLongueur()+" et de largeur "+getLargeur();
	}*/

}
