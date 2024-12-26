package gestion_indemnite;

import java.util.ArrayList;
import java.util.Scanner;


public class Service {
    private String intitule;
    private static final int nbreMaxInfirmier=12;
    private static final int nbreMaxMedecin=4;
    private static final int MAX_PERSONNEL=nbreMaxInfirmier+nbreMaxMedecin;
    ArrayList<Personnel> srv=new ArrayList<Personnel>();

    public Service(String intitule) {
        this.intitule=intitule;
    }
    public void ajouterUnMedecin(Medecin med, float nbreHeure){
        if((med.getCnie()!=null)&&(med.getNom()!= null)&&(med.getSpecialite() != null)){
            for(Personnel p : srv){
                if(p instanceof Medecin){
                    med.comptMed++;
                }
            }
            if(med.comptMed==nbreMaxMedecin){
                System.out.println("Nombre max de médecins atteint !");
            }else{
                srv.add(med);
                System.out.println("Médecin ajouté avec succès !");
            }
        }
        med.setNbreHeureSuppl(nbreHeure);
    }
    public void ajouterUnInfirmier(Infirmier inf){
        if((inf.getDiplome() !=null)&&(inf.getNom()!= null)&&(inf.getCnie() != null)){
            for(Personnel p : srv){
                if(p instanceof Infirmier){
                   inf.comptInf++;
                }
            }
            if(inf.comptInf==nbreMaxInfirmier){
                System.out.println("Nombre max des infirmiers atteint !");
            }else{
                srv.add(inf);
                System.out.println("Infirmier ajouté avec succès !");
            }
        }
    }
    public void ajouterPersonnel(){
        Scanner sc=new Scanner(System.in);

        while(true){
            if(srv.size()>=MAX_PERSONNEL){
                System.out.println("La liste du personnel est saturée !");
                break;
            }
            System.out.println("Ajoute un personnel Oui/Non? :");
            String  response=sc.nextLine().trim();

            if(response.equalsIgnoreCase("O")){
                System.out.println("Voulez vous ajouter un Medecin('M') ou un infirmier('I') ?");
                String choix=sc.nextLine().trim();

                if (choix.equalsIgnoreCase("M")){
                    System.out.println("Spécialité :");
                    String spec=sc.nextLine().trim();
                    System.out.println("Nom :");
                    String nom=sc.nextLine().trim();
                    System.out.println("CNIE :");
                    String cnie=sc.nextLine().trim();
                    System.out.println("Nombre d'heure :");
                    float nbr=sc.nextFloat();
                    sc.nextLine();
                    Medecin med=new Medecin(spec, cnie, nom);
                    ajouterUnMedecin(med, nbr);
                }else if (choix.equalsIgnoreCase("I")) {
                        System.out.println("Diplôme :");
                        String diplome = sc.nextLine().trim();
                        System.out.println("Nom :");
                        String nom = sc.nextLine().trim();
                        System.out.println("CNIE :");
                        String cnie = sc.nextLine().trim();
                        System.out.println("Ancienneté :");
                        int anc = sc.nextInt();
                        sc.nextLine();
                        Infirmier inf = new Infirmier(diplome, anc, cnie, nom);
                        ajouterUnInfirmier(inf);
                    } else {
                        System.out.println("Choix invalide !");
                }
            }else{
                break;
            }

        }
        sc.close();
    }
    public void afficherSrv(){
        System.out.println("La liste du personnel du service "+intitule);
        for(int j=0; j<srv.size(); j++){
            System.out.println(srv.get(j).toString());
        }
    }
    public  float totalIndemnite(){
        float totalIndemnite=0;
        for(Personnel p:srv){
            if(p instanceof Infirmier){
                totalIndemnite+=p.indemnite();
            } else if(p instanceof Medecin) {
                totalIndemnite += p.indemnite();
            }
        }
        return  totalIndemnite;
    }
}
