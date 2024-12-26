package Fonctionnelle;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Collectors;

public class MainProduit {

	public static void main(String[] args) {
		List<Produit> produits=Arrays.asList(
				new Produit("Ordinateur", 1000),
				new Produit("Clavier",25),
				new Produit("Souris", 15),
				new Produit("Ecran", 150)
		);
		
		//Filtre des produits coutant plus de 20
		Predicate<Produit> filtrePrix=produit -> produit.getPrix() > 20;
		
		List<Produit> produitsFiltres=produits.stream().filter(filtrePrix).collect(Collectors.toList());
		
		System.out.println("Produits coûtant plus de 20 :");
		produitsFiltres.forEach(System.out::println);
		
		//Appliquer une réduction de 10%
		Function<Produit, Produit> appliquerReduction=produit ->{
			produit.setPrix(produit.getPrix()*0.9);
			return produit;
		};
		
		List<Produit> produitsReduits=produitsFiltres.stream().map(appliquerReduction).collect(Collectors.toList());
		
		System.out.println("\nProduits après réduction de 10% :");
		produitsReduits.forEach(System.out::println);
		
		//Afficher chaque produit
		Consumer<Produit> afficherProduit=produit -> System.out.println("Produit :"+produit.getNom()+", Prix : "+produit.getPrix());
		
		System.out.println("\nAffichage des produits :");
		produitsReduits.forEach(afficherProduit);
		
		//Fournir un produit par défaut
		Supplier<Produit> produitParDefaut=() -> new Produit("Produit par défaut", 0);
		
		Produit produitDefaut=produits.stream().filter(p ->p.getPrix() > 2000).findFirst().orElseGet(produitParDefaut);
		
		System.out.println("\nProduit par défaut :");
		System.out.println(produitDefaut);

	}

}
