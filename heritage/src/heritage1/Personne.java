package heritage1;

public class Personne {
	private int nbEnfants;
	private String nom;
	public Personne(int nbEnfants, String nom) {
		this.nbEnfants=nbEnfants;
		this.nom=nom;
	}
	public String getNom(){
		return nom;
	}
	public int getNbEnfants(){
		return nbEnfants;
	}
	public String afficheInfo(){
		return "M(me) "+getNom()+", "+getNbEnfants()+" enfants.";
		
	}

}
