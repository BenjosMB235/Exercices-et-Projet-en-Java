package Pile;

public class Main {
	public static void main(String[] args){
		Pile<Integer> pile=new Pile<>();
		
		pile.empiler(10);
		pile.empiler(20);
		pile.empiler(30);
		pile.empiler(25);
		
		System.out.println("Après empilements :");
		pile.afficherPile();
		
		System.out.println("Sommet de la pile :"+pile.sommet());
		
		System.out.println("Element dépilé :"+pile.depiler());
		System.out.println("Après dépilement :");
		pile.afficherPile();
		
		System.out.println("La pile est-elle vide ?"+pile.estVide());
	}
}
