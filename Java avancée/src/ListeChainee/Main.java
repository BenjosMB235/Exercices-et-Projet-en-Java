package ListeChainee;
public class Main {

	public static void main(String[] args) {
		ListeChainee liste=new ListeChainee();
		
		liste.ajouterAuDebut(10);
		liste.ajouterAuDebut(5);
		liste.ajouterALaFin(15);
		liste.ajouterALaFin(20);
		
		System.out.println("Liste apr�s ajouts :");
		liste.afficher();
		
		liste.supprimer(15);
		System.out.println("Liste apr�s suppression de 15 :");
		liste.afficher();
		
		liste.supprimer(100);
		
		liste.ajouterALaFin(25);
		System.out.println("Liste apr�s ajout de 25 :");
		liste.afficher();

	}

}
