package gestion_indemnite;

public class test {

    public static  void main(String[] args){
        Service sr=new Service("Santé");
        sr.ajouterPersonnel();
        sr.afficherSrv();
        System.out.println("\nLe total des indemnités du service est :"+sr.totalIndemnite());
    }
}
