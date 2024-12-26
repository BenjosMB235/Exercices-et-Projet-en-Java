import java.util.Iterator;
import java.util.Scanner;

public class Text {
	
	public static void ajouter(){
		Scanner sc=new Scanner(System.in);
		System.out.print("Entrer ID :");
		int id=sc.nextInt();
		sc.nextLine();
		System.out.print("Entrer nom :");
		String nom=sc.nextLine();
		System.out.print("Entrer �ge :");
		int age=sc.nextInt();
		System.out.print("Entrer moyenne :");
		double moyenne=sc.nextDouble();
		
		Etudiant et=new Etudiant(id,nom,age,moyenne);
		System.out.println("Etudiant ajout� avec succ�s !");
		
	}
	
	public static void afficher(){
		if(Etudiant.Etudiants.isEmpty()){
			System.out.println("Aucun �tudiant trouv�!");
		}else{
			System.out.println("Liste des �tudiants :");
			for(Etudiant et:Etudiant.Etudiants){
				System.out.println("ID "+et.getId()+", Nom :"+et.getNom()+", Age :"+et.getAge()+", Moyenne :"+et.getMoyenne());
			}
		}
		
	}
	
	public static void rechercher(){
		Scanner sc=new Scanner(System.in);
		System.out.println("Entrer le ID de l'�tudiant :");
		int id=sc.nextInt();
		for(Etudiant et:Etudiant.Etudiants){
			if(et.getId() == id){
				System.out.println("ID "+et.getId()+", Nom :"+et.getNom()+", Age :"+et.getAge()+", Moyenne :"+et.getMoyenne());
				return;
			}else{
				System.out.println("Etudiant non trouv� !");
			}
		}
		
	}
	
	public static void supprimer(){
		Scanner sc=new Scanner(System.in);
		System.out.println("Entrer le ID de l'�tudiant :");
		int id=sc.nextInt();
		Iterator<Etudiant> iterator =Etudiant.Etudiants.iterator();
		while(iterator.hasNext()){
			if(iterator.next().getId() == id){
				iterator.remove();
				System.out.println("Etudiant supprim� !");
				return;
			}else{
				System.out.println("Etudiant non trouv� !");
			}
		}
	}
	
	public static void trier(){
		if(Etudiant.Etudiants.isEmpty()){
			System.out.println("Aucun �tudiant trouv�!");
			return;
		}else{
			Etudiant.Etudiants.sort((e1,e2) -> Double.compare(e2.getMoyenne(), e1.getMoyenne()));
			System.out.println("Etudiants tri�s par moyenne :");
			afficher();
			return;
		}
	}

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		// TODO Auto-generated method stub
		while(true){
			System.out.println("\n1.Ajouter un �tudiant");
			System.out.println("2.Afficher les �tudiants");
			System.out.println("3.Rechercher un �tudiant par ID");
			System.out.println("4.Supprimer un �tudiant");
			System.out.println("5.Trier les �tudiants par moyenne");
			System.out.println("6.Quitter");
			System.out.print("Votre choix :");
			int ch=sc.nextInt();
			switch(ch){
				case 1:
					ajouter();
					break;
				case 2:
					afficher();
					break;
				case 3:
					rechercher();
					break;
				case 4:
					supprimer();
					break;
				case 5:
					trier();
					break;
				case 6:
					System.out.println("Aurevoir");
					System.exit(0);
					break;
				default :
					System.out.println("Erreur");
			}

		}
	}
		

}
