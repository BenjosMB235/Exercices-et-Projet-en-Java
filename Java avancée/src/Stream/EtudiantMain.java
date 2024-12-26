package Stream;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.OptionalDouble;
import java.util.stream.Collectors;

public class EtudiantMain {
	
	public static void exporterEnTexte(List<Etudiant> etudiants) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("etudiants.txt"))) {
            writer.write("Nom,Note\n");
            for (Etudiant e : etudiants) {
                writer.write(e.getNom() + "," + e.getNote() + "\n");
            }
            System.out.println("\nLes données ont été exportées dans le fichier 'etudiants.txt'.");
        } catch (IOException ex) {
            System.out.println("Erreur lors de l'écriture du fichier : " + ex.getMessage());
        }
    }
	
	/*public static void exporterEnCSV(List<Etudiant> etudiants) {
        try (CSVWriter writer = new CSVWriter(new FileWriter("etudiants.csv"))) {
            String[] header = {"Nom", "Age", "Note"};
            writer.writeNext(header);

            for (Etudiant e : etudiants) {
                String[] ligne = {e.getNom(), String.valueOf(e.getAge()), String.valueOf(e.getNote())};
                writer.writeNext(ligne);
            }
            System.out.println("\nLes données ont été exportées dans le fichier 'etudiants.csv'.");
        } catch (IOException ex) {
            System.out.println("Erreur lors de l'écriture du fichier CSV : " + ex.getMessage());
        }
    }*/

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Etudiant> etudiants=Arrays.asList(
				new Etudiant("Alice",20,12.5),
				new Etudiant("Bob",21,9.0),
				new Etudiant("Charlie",22,15.0),
				new Etudiant("Diana",19,8.5)
		);
		
		List<Etudiant> etudiantsFiltrees=etudiants.stream().filter(e -> e.getNote() > 10).collect(Collectors.toList());
		
		System.out.println("Etudiants avec note > 10 :");
		etudiantsFiltrees.forEach(System.out::println);
		
		List<Etudiant> etudiantsTries = etudiants.stream().sorted(Comparator.comparing(Etudiant::getNom)).collect(Collectors.toList());
		
		System.out.println("\nEtudiants triés par nom :");
		etudiantsTries.forEach(System.out::println);
		
		List<String> noms = etudiants.stream().map(Etudiant::getNom).collect(Collectors.toList());
		
		System.out.println("\nNoms des étudiants :"+noms);
		
		Optional<Etudiant> meilleurEtudiant=etudiants.stream().max(Comparator.comparing(Etudiant::getNote));
		
		if(meilleurEtudiant.isPresent()){
			System.out.println("\nEtudiant avec la meilleure note :");
			System.out.println(meilleurEtudiant.get());
		}
		
		Optional<Etudiant> mediocreEtudiant=etudiants.stream().min(Comparator.comparing(Etudiant::getNote));
		
		if(mediocreEtudiant.isPresent()){
			System.out.println("\nEtudiant avec la plus petite note :");
			System.out.println(meilleurEtudiant.get());
		}
		
		double sommeNote=etudiants.stream().mapToDouble(Etudiant::getNote).sum();
		
		System.out.println("\nTotal somme de notes d'étudiants :"+sommeNote);
		
		long nombreEtudiants=etudiants.stream().count();
		
		System.out.println("\nNombre total d'étudiants :"+nombreEtudiants);
		
		OptionalDouble moyenneNote=etudiants.stream().mapToDouble(Etudiant::getNote).average();
		
		if(moyenneNote.isPresent()){
			System.out.println("\nMoyenne des notes :"+moyenneNote.getAsDouble());
		}
		
		Map<String, Long> distributionNotes=etudiants.stream().collect(Collectors.groupingBy(
				e -> {
					if(e.getNote()<10) 
						return "Faible(<10)";
					else if(e.getNote()<=14) 
						return "Moyenne (10-14)"; 
					else return "Elevé(>14)";
				},Collectors.counting()));
		System.out.println("\nDistribution des notes ");
		distributionNotes.forEach((groupe, nombre)->System.out.println(groupe+":"+nombre+"Etudiants"));
		
		exporterEnTexte(etudiants);
        //exporterEnCSV(etudiants);
	}

}
