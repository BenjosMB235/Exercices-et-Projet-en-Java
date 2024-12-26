package heritage1;

public class Salarie extends Personne {
	private float salaire;
	
	public Salarie(int nbEnfants, String nom, float salaire) {
		super(nbEnfants, nom);
		this.salaire=salaire;
	}
	public float getSalaire(){
		return salaire;
	}
	public float salariePrime(){
		if(getNbEnfants()>0){
			float P=((5*getNbEnfants()*salaire)/100);
			return P;
		}else{
			return 0;
		}
	}
	public String afficheInfo(){
		String str=super.afficheInfo();
		str+= " Avec une salaire de "+getSalaire()+" et une prime de "+salariePrime();
		return str;

	}


}
