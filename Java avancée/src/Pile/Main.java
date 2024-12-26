package Pile;

public class Main {
	public static void main(String[] args){
		Pile<Integer> pile=new Pile<>();
		
		pile.empiler(10);
		pile.empiler(20);
		pile.empiler(30);
		pile.empiler(25);
		
		System.out.println("Apr�s empilements :");
		pile.afficherPile();
		
		System.out.println("Sommet de la pile :"+pile.sommet());
		
		System.out.println("Element d�pil� :"+pile.depiler());
		System.out.println("Apr�s d�pilement :");
		pile.afficherPile();
		
		System.out.println("La pile est-elle vide ?"+pile.estVide());
	}
}
