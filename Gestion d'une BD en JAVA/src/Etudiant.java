
public class Etudiant {
	private String nom;
	private String prenom;
	private String email;
	private int age;
	
	public Etudiant(String nom, String prenom, String email, int age){
		this.nom=nom;
		this.prenom=prenom;
		this.email=email;
		this.age=age;
	}

	@Override
	public String toString() {
		return "Etudiant [nom=" + nom + ", prenom=" + prenom + ", email=" + email + ", age=" + age + "]";
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

}
