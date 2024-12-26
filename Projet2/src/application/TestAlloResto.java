package application;

import java.util.ArrayList;

public class TestAlloResto {
	public static void main(String[] args){
		ArrayList<Livreur> livreurs=new ArrayList<Livreur>();
		
		Client client1=new Client("Mark", 75003);
		Proprietaire propri1=new Proprietaire("Donei");
		int[] tab1={75001, 75002, 75005};
		Livreur liv1=new Livreur("Barbe",tab1);
		livreurs.add(liv1);
		int[] tab2={75001, 75002, 75003};
		Livreur liv2=new Livreur("Serg", tab2 );
		livreurs.add(liv2);
		
		Restaurant rest1=new Restaurant("Le Bon Resto", "Chinoise", propri1, 75002);
		
		Menu menu1=new Menu("carottes aux gingembres", 9.5, 250.3, 15);
		Menu menu2=new Menu("Dos de Saint Marin", 14.5, 350.2, 20);
		Menu menu3=new Menu("Pigeonneau de racan roti", 16.5, 265, 25);
		
		menu1.setResto(rest1);
		menu2.setResto(rest1);
		menu3.setResto(rest1);
		
		Commande cmd1=new Commande(client1);
		cmd1.ajouterNewMenu(menu1);
		cmd1.ajouterNewMenu(menu2);
		cmd1.choisirLivreur(livreurs);
		//cmd1.toSring();
		System.out.println(cmd1.aPayer());
		cmd1.calculTempLivraison();
		cmd1.finaliser(4);
		
		Personne[] perss={client1, liv1, propri1, liv2};
		
		for(Personne p:perss){
			p.bonus(cmd1);
		}
		
	}
}
