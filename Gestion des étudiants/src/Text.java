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
		System.out.print("Entrer âge :");
		int age=sc.nextInt();
		System.out.print("Entrer moyenne :");
		double moyenne=sc.nextDouble();
		
		Etudiant et=new Etudiant(id,nom,age,moyenne);
		System.out.println("Etudiant ajouté avec succès !");
		
	}
	
	public static void afficher(){
		if(Etudiant.Etudiants.isEmpty()){
			System.out.println("Aucun étudiant trouvé!");
		}else{
			System.out.println("Liste des étudiants :");
			for(Etudiant et:Etudiant.Etudiants){
				System.out.println("ID "+et.getId()+", Nom :"+et.getNom()+", Age :"+et.getAge()+", Moyenne :"+et.getMoyenne());
			}
		}
		
	}
	
	public static void rechercher(){
		Scanner sc=new Scanner(System.in);
		System.out.println("Entrer le ID de l'étudiant :");
		int id=sc.nextInt();
		for(Etudiant et:Etudiant.Etudiants){
			if(et.getId() == id){
				System.out.println("ID "+et.getId()+", Nom :"+et.getNom()+", Age :"+et.getAge()+", Moyenne :"+et.getMoyenne());
				return;
			}else{
				System.out.println("Etudiant non trouvé !");
			}
		}
		
	}
	
	public static void supprimer(){
		Scanner sc=new Scanner(System.in);
		System.out.println("Entrer le ID de l'étudiant :");
		int id=sc.nextInt();
		Iterator<Etudiant> iterator =Etudiant.Etudiants.iterator();
		while(iterator.hasNext()){
			if(iterator.next().getId() == id){
				iterator.remove();
				System.out.println("Etudiant supprimé !");
				return;
			}else{
				System.out.println("Etudiant non trouvé !");
			}
		}
	}
	
	public static void trier(){
		if(Etudiant.Etudiants.isEmpty()){
			System.out.println("Aucun étudiant trouvé!");
			return;
		}else{
			Etudiant.Etudiants.sort((e1,e2) -> Double.compare(e2.getMoyenne(), e1.getMoyenne()));
			System.out.println("Etudiants triés par moyenne :");
			afficher();
			return;
		}
	}

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		// TODO Auto-generated method stub
		while(true){
			System.out.println("\n1.Ajouter un étudiant");
			System.out.println("2.Afficher les étudiants");
			System.out.println("3.Rechercher un étudiant par ID");
			System.out.println("4.Supprimer un étudiant");
			System.out.println("5.Trier les étudiants par moyenne");
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
