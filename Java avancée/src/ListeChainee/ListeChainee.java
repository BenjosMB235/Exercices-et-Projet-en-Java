package ListeChainee;
public class ListeChainee {
	private Noeud tete;
	
	public ListeChainee(){
		this.tete=null;
	}
	
	public void ajouterAuDebut(int valeur){
		Noeud nouveau = new Noeud(valeur);
		nouveau.suivant=tete;
		tete=nouveau;
	}
	
	public void ajouterALaFin(int valeur){
		Noeud nouveau = new Noeud(valeur);
		if(tete==null){
			tete=nouveau;
		}else{
			Noeud courant=tete;
			while(courant.suivant != null){
				courant = courant.suivant;
			}
			courant.suivant=nouveau;
		}
	}
	
	public void supprimer(int valeur){
		if(tete==null){
			System.out.println("La liste est vide.");
			return;
		}
		
		if(tete.valeur==valeur){
			tete=tete.suivant;
			return;
		}
		
		Noeud courant=tete;
		while(courant.suivant != null && courant.suivant.valeur != valeur){
			courant=courant.suivant;
		}
		
		if(courant.suivant==null){
			System.out.println("Element non trouvé.");
		}else{
			courant.suivant=courant.suivant.suivant;
		}
	}
	
	public void afficher(){
		if(tete==null){
			System.out.println("La liste est vide.");
			return;
		}
		
		Noeud courant=tete;
		while (courant != null){
			System.out.print(courant.valeur+"->");
			courant=courant.suivant;
		}
		System.out.println("null");
	}

}
