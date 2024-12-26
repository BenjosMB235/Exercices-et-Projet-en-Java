package Stream;

public class Etudiant {
	private String nom;
	private int age;
	private double note;
	
	public Etudiant(String nom, int age, double note){
		this.nom=nom;
		this.age=age;
		this.note=note;
	}
	

	@Override
	public String toString() {
		return "Etudiant [nom=" + nom + ", age=" + age + ", note=" + note + "]";
	}


	public String getNom() {
		return nom;
	}


	public void setNom(String nom) {
		this.nom = nom;
	}


	public int getAge() {
		return age;
	}


	public void setAge(int age) {
		this.age = age;
	}


	public double getNote() {
		return note;
	}


	public void setNote(double note) {
		this.note = note;
	}

}
