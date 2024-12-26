import java.util.Random;


public class Personne implements Runnable {
	private String nom;
	private Random alea;

	public Personne(String nom) {
		// TODO Auto-generated constructor stub
		this.nom=nom;
		alea = new Random();
	}
	public void run(){
		for(int i=1;i<10; i++){
			try{
				Thread.sleep(alea.nextInt()%5*1000);
			}catch(Exception e){
				
			}finally{
				System.out.println("Je suis "+nom+"    i="+i);
			}
		}
	}

}
