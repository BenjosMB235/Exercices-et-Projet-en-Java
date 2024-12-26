import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Etudiant {
	private int id;
	private String nom;
	private int age;
	private double moyenne;
	protected static final List<Etudiant> Etudiants=new ArrayList<>();
	
	public Etudiant(int id, String nom, int age, double moyenne){
		this.id=id;
		this.nom=nom;
		this.age=age;
		this.moyenne=moyenne;
		Etudiants.add(this);
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public double getMoyenne() {
		return moyenne;
	}

	public void setMoyenne(double moyenne) {
		this.moyenne = moyenne;
	}

	public static List<Etudiant> getEtudiants() {
		return Etudiants;
	}
	
	

}
