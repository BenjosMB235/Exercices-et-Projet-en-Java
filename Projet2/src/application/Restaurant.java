package application;
public class Restaurant {
	private String nom;
	private String specialite;
	private Proprietaire proprietaire;
	private int codePostal;
	
	public Restaurant(String nom, String specialite, Proprietaire proprietaire, int codePostal){
		this.nom=nom;
		this.specialite=specialite;
		this.proprietaire=proprietaire;
		this.codePostal=codePostal;
	}
	public String toString(){
		return "Restaurant : nom="+nom+", Specialité"+specialite+", Code Postal="+codePostal+", Propriétaire:"+proprietaire.toString();
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getSpecialite() {
		return specialite;
	}
	public void setSpecialite(String specialite) {
		this.specialite = specialite;
	}
	public Proprietaire getProprietaire() {
		return proprietaire;
	}
	public void setProprietaire(Proprietaire proprietaire) {
		this.proprietaire = proprietaire;
	}
	public int getCodePostal() {
		return codePostal;
	}
	public void setCodePostal(int codePostal) {
		this.codePostal = codePostal;
	}
	
}
