package application;
import java.util.ArrayList;

public class Commande {
	private Client client;
	private Livreur livreur;
	ArrayList<Menu> menusChoisis=new ArrayList<Menu>(50);
	private int note;
	
	public Commande(Client client){
		this.client=client;
		this.livreur=null;
		this.note=0;
	}
	public Client getClient() {
		return client;
	}
	
	public int getNote() {
		return note;
	}
	
	public void setNote(int note) {
		this.note = note;
	}
	public void ajouterNewMenu(Menu menu){
		menusChoisis.add(menu);
		
	}
	public void supprimerMenu(Menu menu){
		menusChoisis.remove(menu);
	}
	public String toSring(){
		return "Commande Client:"+client.toString()+"\n Livreur :"+livreur.toString()+"\n  Menus Choisis:";
	}
	public void choisirLivreur(ArrayList<Livreur> livreurs){
		boolean res=false;
		String nm="";
		for(Livreur lv:livreurs){
			if((lv.estCompatible(client)== true)&&(lv.getEstLibre()==true)){
				lv.setEstLibre(false);
				res=true;
				nm=lv.getNom();
				break;
			}
		}
		if(res==true){
			System.out.println("Le livreur de la commande est "+nm);
		}else{
			System.out.println("Aucun livreur disponible");
		}
		
	}
	public void calculTempLivraison(){
		int total=0;
		for(Menu mn:menusChoisis){
			total+=mn.getTempPrepa();
		}
		total+=10;
		System.out.println("Le temps de livraison maximal est "+total);
	}
	public float aPayer(){
		float total=0;
		for(Menu mn:menusChoisis){
			total+=mn.getPrix();
		}
		return total;
	}
	public void finaliser(int n){
		boolean lb=true;
		setNote(n);
		try {
			livreur.setEstLibre(lb);
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Erreur");
		}
	}
}
