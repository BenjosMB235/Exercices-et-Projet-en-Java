package application;

public class Livreur extends Personne{
	boolean estLibre=true;
	int codePostaux[];
	
	public Livreur(String nom, int[] tab) {
		super(nom);
		this.codePostaux = tab;
	}

	public boolean estCompatible(Client c){
		boolean res=false;
		for(int cp:codePostaux){
			if(c.getCodePostal()==cp){
				res=true;
				break;
			}
		}
		if(res==true){
			return true;
		}else
			return false;
	}
	public void bonus(Commande commande){
		if(commande.aPayer()>=10){
			int p=(int)((commande.aPayer())/10);
			super.setPoint(p);
		}else{
			super.setPoint(0);
		}
	}
	public String toString(){
		return super.toString()+"CodePostals="+codePostaux+"\n EstLibre="+estLibre;
	}
	public boolean getEstLibre() {
		return estLibre;
	}
	public void setEstLibre(boolean estLibre) {
		this.estLibre=estLibre;
	}
	public int[] getCodePostaux() {
		return codePostaux;
	}
	public void setCodePostaux(int[] codePostaux) {
		this.codePostaux = codePostaux;
	}
	
	
}
