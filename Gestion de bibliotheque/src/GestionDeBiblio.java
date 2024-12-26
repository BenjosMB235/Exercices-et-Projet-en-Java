import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class GestionDeBiblio {
	private static List<Livre> livres=new ArrayList<>();
	
	public static void ajouter(){
		Scanner sc=new Scanner(System.in);
		System.out.print("Entrer ID :");
		int id=sc.nextInt();
		sc.nextLine();
		System.out.print("Entrer le titre :");
		String titre=sc.nextLine();
		System.out.print("Entrer auteur :");
		String auteur=sc.nextLine();
		System.out.print("Entrer année de publication :");
		int annee=sc.nextInt();
		 
		Livre livre=new Livre(id,titre,auteur,annee);
		livres.add(livre);
		System.out.println("Livre ajouté avec succès !");
		
	}
	
	public static void afficher(){
		if(livres.isEmpty()){
			System.out.println("Aucun livre disponible !");
			return;
		}else{
			for(Livre l:livres){
				System.out.println(l);
			}
		}
	}
	
	public static void rechercher(){
		Scanner sc=new Scanner(System.in);
		System.out.println("Choisir le moyen de recherche :");
		System.out.println("1.Tire");
		System.out.println("2.Auteur");
		System.out.print("Entrer :");
		int ch=sc.nextInt();
		sc.nextLine();
		if(ch==1){
			System.out.println("Entrer le titre du livre :");
			String titre=sc.nextLine();
			for(Livre l:livres){
				if(l.getTitre() == titre){
					System.out.println(l);
				}else{
					System.out.println("Livre non trouvé !");
				}
			}
		}else 
			if(ch==2){
				System.out.println("Entrer l'auteur du livre :");
				String auteur=sc.nextLine();
				for(Livre l:livres){
					if(l.getAuteur() == auteur){
						System.out.println(l);
					}else{
						System.out.println("Livre non trouvé !");
					}
			}
		}
	}
	
	public static void emprunter(){
			Scanner sc=new Scanner(System.in);
			System.out.print("Entrer ID :");
			int id=sc.nextInt();
			
			for(Livre l:livres){
				if(l.getId() == id){
					if(l.getDisponible() == true){
						l.setDisponible(false);
						System.out.println("Vous pouvez emprunter le livre ");
					}else{
						System.out.println("Livre emprunté !");
					}
				}else{
					System.out.println("Livre non trouvé !");
				}
		}
		
	}
	
	public static void retourner(){
		Scanner sc=new Scanner(System.in);
		System.out.print("Entrer ID :");
		int id=sc.nextInt();
		
		for(Livre l:livres){
			if(l.getId() == id){
				if(l.getDisponible() == false){
					l.setDisponible(true);
					System.out.println("Merci d'avoir ramener le livre ");
				}else{
					System.out.println("Livre dejà ramené !");
				}
			}else{
				System.out.println("Livre non trouvé !");
			}
	}
	}
	
	public static void supprimer(){
		Scanner sc=new Scanner(System.in);
		System.out.println("Entrer le ID du livre :");
		int id=sc.nextInt();
		Iterator<Livre> iterator =livres.iterator();
		while(iterator.hasNext()){
			if(iterator.next().getId() == id){
				iterator.remove();
				System.out.println("Livre supprimé !");
				return;
			}else{
				System.out.println("Livre non trouvé !");
			}
		}
	}
	
	public static void trierParTitre(){
		if(livres.isEmpty()){
			System.out.println("Aucun livre trouvé!");
			return;
		}else{
			livres.sort(Comparator.comparing(Livre::getTitre));
			System.out.println("Livres triés par Titre :");
			afficher();
			return;
		}
	}
	
	public static void trierParAnnee(){
		if(livres.isEmpty()){
			System.out.println("Aucun livre trouvé!");
			return;
		}else{
			livres.sort(Comparator.comparingInt(Livre::getAnnee));
			System.out.println("Livres triés par Titre :");
			afficher();
			return;
		}
	}
	
	public static void sauvegarderLivre(String nomFichier){
		try (ObjectOutputStream oos= new ObjectOutputStream(new FileOutputStream(nomFichier))){
			oos.writeObject(livres);
			System.out.println("Données sauvegardées avec succès dans "+nomFichier);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Erreur lors de la sauvegarde :"+e.getMessage());
		}
	}
	
	@SuppressWarnings("unchecked")
	public static void chargerLivres(String nomFichier){
		try (ObjectInputStream ois= new ObjectInputStream(new FileInputStream(nomFichier))){
			livres = (List<Livre>) ois.readObject();
			System.out.println("Données chargées avec succès dans "+nomFichier);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Erreur lors du chargement :"+e.getMessage());
		}
	}
	
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		int ch;
		do{
			System.out.println("\n1.Ajouter un livre");
			System.out.println("2.Afficher tous les livres");
			System.out.println("3.Rechercher un livre par titre ou auteur");
			System.out.println("4.Emprunter un livre");
			System.out.println("5.Retourner un livre");
			System.out.println("6.Supprimer un étudiant");
			System.out.println("7.Trier les livres par titre");
			System.out.println("8.Trier les livres par année de publication");
			System.out.println("9.Sauvegarder les livres dans un fichier");
			System.out.println("10.Charger les livres depuis un fichier");
			System.out.println("11.Quitter");
			System.out.print("Votre choix :");
			ch=sc.nextInt();
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
					emprunter();
					break;
				case 5:
					retourner();
					break;
				case 6:
					supprimer();
					break;
				case 7:
					trierParTitre();
					break;
				case 8:
					trierParAnnee();
					break;
				case 9:
					System.out.print("Entrer le nom du fichier pour sauvegarder les livres :");
					sc.nextLine();
					String nomFichier=sc.nextLine();
					sauvegarderLivre(nomFichier);
					break;
				case 10:
					System.out.print("Entrer le nom du fichier pour charger les livres :");
					sc.nextLine();
					String nomFichie=sc.nextLine();
					chargerLivres(nomFichie);
					break;
				case 11:
					System.out.println("Aurevoir");
					break;
				default :
					System.out.println("Erreur");
			}

			
		}while(ch<=11);

	}

}
