import java.io.Serializable;

public class Livre implements Serializable{
	private static final long serialVersionUID = 1L; //Assure la compatibilité entre les versions
	private int id;
	private String titre;
	private String auteur;
	private int annee;
	private Boolean disponible;
	
	public Livre(int id, String titre, String auteur, int annee){
		this.id=id;
		this.titre=titre;
		this.auteur=auteur;
		this.annee=annee;
		this.disponible=true;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitre() {
		return titre;
	}

	public void setTitre(String titre) {
		this.titre = titre;
	}

	public String getAuteur() {
		return auteur;
	}

	public void setAuteur(String auteur) {
		this.auteur = auteur;
	}

	public int getAnnee() {
		return annee;
	}

	public void setAnnee(int annee) {
		this.annee = annee;
	}

	public Boolean getDisponible() {
		return disponible;
	}

	public void setDisponible(Boolean disponible) {
		this.disponible = disponible;
	}

	@Override
	public String toString() {
		return "Livre [id=" + id + ", titre=" + titre + ", auteur=" + auteur + ", annee=" + annee + ", disponible="
				+ disponible + "]";
	}
	
}
