
public class Essai {
	
	public static void main(String[] args){
		Personne P1=new Personne("Benjos");
		Personne P2=new Personne("Maobie");
		Personne P3=new Personne("Thor");
		Thread T1=new Thread(P1);
		Thread T2=new Thread(P2);
		Thread T3=new Thread(P3);
		
		T1.start();
		T2.start();
		T3.start();
		try{
			T1.join();
			T2.join();
			T3.join();
		}catch(Exception e){
			
		}
		
	}

}
