
public class Employe {
	private String nom;
	private double salaire;
	
	public Employe(String nom, double salaire) {
		this.nom=nom;
		this.salaire=salaire;
	}
	public String getNom(){
		return this.nom;
	}
	public double getSalaire(){
		return this.salaire;
	}
	public double prime(){
		return ((this.salaire)*1.05);
	}
	public double prime(int nbreEnfants){
		return ((this.salaire)*(1+0.1*nbreEnfants));
	}

}
