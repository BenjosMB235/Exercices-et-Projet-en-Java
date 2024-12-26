
public class chien {
	private String nom;
	private float taille;
	private String race;

	public chien() {
		taille=10;
		race="";
		nom="";
	}
	public chien(float taille, String nom, String race){
		this.taille=taille;
		this.race=race;
		this.nom=nom;
	}
	public void setTaille(float taille){
		this.taille=taille;
	}
	public void setRace(String race){
		this.race=race;
	}
	public void setNom(String nom){
		this.nom=nom;
	}
	public float getTaille(){
		return this.taille;
	}
	public String getRace(){
		return this.race;
	}
	public String getNom(){
		return this.nom;
	}
	public void aboyer(){
		System.out.println("Ouah! Ouah!");
	}

}
