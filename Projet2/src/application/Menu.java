package application;
public class Menu {
	private String description;
	private float prix;
	private float poids;
	private int tempPrepa;
	private Restaurant resto;
	
	public Menu(String description, double prix, double poids, int tempPrepa){
		this.description=description;
		this.prix=(float) prix;
		this.poids=(float) poids;
		this.tempPrepa=tempPrepa;
	}
	public String toString(){
		return "Menu: description="+description+", Prix="+prix+", Poids="+poids+", Temps de préparation="+tempPrepa+", Restaurant="+resto.toString();
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public float getPrix() {
		return prix;
	}
	public void setPrix(float prix) {
		this.prix = prix;
	}
	public float getPoids() {
		return poids;
	}
	public void setPoids(float poids) {
		this.poids = poids;
	}
	public int getTempPrepa() {
		return tempPrepa;
	}
	public void setTempPrepa(int tempPrepa) {
		this.tempPrepa = tempPrepa;
	}
	public Restaurant getResto() {
		return resto;
	}
	public void setResto(Restaurant resto) {
		this.resto = resto;
	}
	
}
