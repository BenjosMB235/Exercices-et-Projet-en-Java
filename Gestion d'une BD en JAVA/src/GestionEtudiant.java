import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class GestionEtudiant {
	static Connection con;
	static PreparedStatement pst;
	static ResultSet rs;
	
	public static void connect(){
		try {
			con= DriverManager.getConnection("jdbc:mysql://localhost:3306/gestion_etudiants", "root", "");
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
	public static void ajouter(){
		try {
			connect();
			Scanner sc=new Scanner(System.in);
			System.out.println("Entrer le nom :");
			String nom=sc.nextLine();
			System.out.println("Entrer le prénom :");
			String prenom=sc.nextLine();
			System.out.println("Entrer l'Email :");
			String email=sc.nextLine();
			System.out.println("Entrer l'âge :");
			int age=sc.nextInt();
			
			pst=con.prepareStatement("INSERT INTO etudiants (nom, prenom, email, age) VALUES (?, ?, ?, ?)");
			pst.setString(1,nom);
			pst.setString(2, prenom);
			pst.setString(3, email);
			pst.setInt(4, age);
			pst.executeUpdate();
			con.close();
			
			System.out.println("Etudiant ajouté à la base de données !");
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
	public static void afficher(){
		String sql="SELECT * FROM etudiants";
		try {
			connect();
			Statement st=con.createStatement();
			rs=st.executeQuery(sql);
			System.out.println("Les étudiants enregistrés sont :");
				
			while(rs.next()){
				System.out.println("Etudiant [ID=" + rs.getInt("id") + ", nom=" + rs.getString("nom") + ", prenom=" + rs.getString("prenom") + ", email=" + rs.getString("email") + ", age=" + rs.getInt("age") + "]");
			}
			con.close();	
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void modifier(){
		try {
			connect();
			Scanner sc=new Scanner(System.in);
			System.out.print("Entrer le ID de l'étudiant ");
			int id=sc.nextInt();
			sc.nextLine();
			String sql="SELECT * FROM etudiants WHERE id=?";
			pst=con.prepareStatement(sql);
			pst.setInt(1,id);
			rs=pst.executeQuery();
			
			while(rs.next()){
				System.out.println("Etudiant [ID=" + rs.getInt("id") + ", nom=" + rs.getString("nom") + ", prenom=" + rs.getString("prenom") + ", email=" + rs.getString("email") + ", age=" + rs.getInt("age") + "]");
			}
			System.out.println("Modifier maintenant les données de l'étudiant :");
			
			System.out.println("Nouveau nom :");
			String nom=sc.nextLine();
			System.out.println("Nouveau prénom :");
			String prenom=sc.nextLine();
			System.out.println("Nouvel Email :");
			String email=sc.nextLine();
			System.out.println("Nouvel âge :");
			int age=sc.nextInt();
			
			pst=con.prepareStatement("UPDATE etudiants SET nom=?, prenom=?, email=?, age=? WHERE id=?");
			pst.setString(1,nom);
			pst.setString(2, prenom);
			pst.setString(3, email);
			pst.setInt(4, age);
			pst.setInt(5, id);
			pst.executeUpdate();
			con.close();
			
			System.out.println("Etudiant modifié avec succès dans la base de données !");
			
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
	public static void supprimer(){
		try {
			connect();
			Scanner sc=new Scanner(System.in);
			System.out.println("Entrer le ID de l'étudiant :");
			int id=sc.nextInt();
			sc.nextLine();
			pst=con.prepareStatement("DELETE FROM etudiants WHERE id=?");
			pst.setInt(1, id);
			pst.executeUpdate();
			con.close();
			System.out.println("Etudiant supprimé avec succès !");
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
	public static void filtrer(){
		Scanner sc=new Scanner(System.in);
		System.out.println("Filtrer par nom ou âge ?");
		System.out.println("1. Nom | 2. Age");
		int ch=sc.nextInt();
		try {
			connect();
			if(ch==1){
				String sql="SELECT * FROM etudiants ORDER BY nom ASC";
				Statement st=con.createStatement();
				rs=st.executeQuery(sql);
				System.out.println("La liste des étudiants filtrée par nom :");
					
				while(rs.next()){
					System.out.println("Etudiant [ID=" + rs.getInt("id") + ", nom=" + rs.getString("nom") + ", prenom=" + rs.getString("prenom") + ", email=" + rs.getString("email") + ", age=" + rs.getInt("age") + "]");
				}
				con.close();
			}else{
				String sql="SELECT * FROM etudiants ORDER BY age ASC";
				Statement st=con.createStatement();
				rs=st.executeQuery(sql);
				System.out.println("La liste des étudiants filtrée par âge :");
					
				while(rs.next()){
					System.out.println("Etudiant [ID=" + rs.getInt("id") + ", nom=" + rs.getString("nom") + ", prenom=" + rs.getString("prenom") + ", email=" + rs.getString("email") + ", age=" + rs.getInt("age") + "]");
				}
				con.close();
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
	private static void exporterCSV() {
	    String fichierCSV = "etudiants.csv"; // Nom du fichier CSV à générer

	    try (PrintWriter writer = new PrintWriter(fichierCSV)) {
	    	connect();
			Statement st=con.createStatement();
			rs=st.executeQuery("SELECT * FROM etudiants");
			

	        // Écrire les en-têtes du fichier CSV
	        writer.println("ID,Nom,Prénom,Email,Âge");

	        // Parcourir les résultats et les écrire dans le fichier
	        while (rs.next()) {
	            int id = rs.getInt("id");
	            String nom = rs.getString("nom");
	            String prenom = rs.getString("prenom");
	            String email = rs.getString("email");
	            int age = rs.getInt("age");

	            // Écrire une ligne dans le fichier CSV
	            writer.printf("%d,%s,%s,%s,%d%n", id, nom, prenom, email, age);
	        }

	        System.out.println("Données exportées avec succès dans le fichier : " + fichierCSV);

	    } catch (Exception e) {
	        System.out.println("Erreur lors de l'exportation : " + e.getMessage());
	    }
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		// TODO Auto-generated method stub
		while(true){
			System.out.println("\n1.Ajouter un étudiant");
			System.out.println("2.Afficher tous les étudiants");
			System.out.println("3.Modifier un étudiant par ID");
			System.out.println("4.Supprimer un étudiant");
			System.out.println("5.Filtrer les étudiants ");
			System.out.println("6.Exporter les étudiants dans un fichier CSV");
			System.out.println("7.Quitter");
			System.out.print("Votre choix :");
			int ch=sc.nextInt();
			switch(ch){
				case 1:
					ajouter();
					break;
				case 2:
					afficher();
					break;
				case 3:
					modifier();
					break;
				case 4:
					supprimer();
					break;
				case 5:
					filtrer();
					break;
				case 6:
					exporterCSV();
					break;
				case 7:
					System.out.println("Aurevoir");
					break;
				default :
					System.out.println("Erreur");
			}

		}
	}

}
