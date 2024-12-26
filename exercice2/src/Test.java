
public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		chien monChien=new chien();
		chien tonchien=new chien((float) 0.85, "bob", "labrador");
		System.out.println("La race de votre chien est "+tonchien.getRace());
		tonchien.setRace("Boxer");
		System.out.println("La race de votre chien est maintenant "+tonchien.getRace());

	}

}
	