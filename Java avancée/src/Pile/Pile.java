package Pile;

import java.util.ArrayList;

public class Pile<T> {
	private ArrayList<T> elements;
	
	public Pile(){
		elements = new ArrayList<>();
	}
	
	public void empiler(T element){
		elements.add(element);
	}
	
	public T depiler(){
		if(estVide()){
			throw new IllegalStateException("La pile est vide.");
		}
		return elements.remove(elements.size()-1);
	}
	
	public T sommet(){
		if(estVide()){
			throw new IllegalStateException("La pile est vide");
		}
		return elements.get(elements.size()-1);
	}
	
	public boolean estVide(){
		return elements.isEmpty();
	}
	
	public void afficherPile(){
		System.out.println("Contenu de la pile :"+elements);
	}

}
