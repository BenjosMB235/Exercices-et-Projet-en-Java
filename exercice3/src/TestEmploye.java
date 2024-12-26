
public class TestEmploye {

	public static void main(String[] args) {
		Employe E1=new Employe("John", 2000);
		double P1=E1.prime();
		Employe E2=new Employe("Paul", 3000);
		double P2=E2.prime(3);
		double net1=E1.getSalaire()+P1;
		double net2=E2.getSalaire()+P2;
		System.out.println("Le salaire net à payer de "+E1.getNom()+" est "+net1);
		System.out.println("Le salaire net à payer de "+E2.getNom()+" est "+net2);
	}

}
