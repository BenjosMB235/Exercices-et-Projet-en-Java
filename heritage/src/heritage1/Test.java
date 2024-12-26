package heritage1;

public class Test {
	public static void main(String[] args){
		Personne p1=new Personne(3, "Ben");
		Salarie s1=new Salarie(3, "Ben", 155);
		
		System.out.println(p1.afficheInfo());
		System.out.println(s1.afficheInfo());
	}
}
