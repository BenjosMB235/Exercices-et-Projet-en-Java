package gestion_indemnite;

public class Medecin extends Personnel{
    protected int comptMed=0;
    private static final int tauxHoraire=220;
    private String specialite;

    public Medecin(String specialite, String cnie, String nom) {
        super(cnie, nom);
        this.specialite=specialite;

    }
    public String getSpecialite() {

        return specialite;
    }
    public float indemnite(){
        return getNbreHeureSuppl()*tauxHoraire;
    }
    public String toString(){
        return "Les informations du Médecin :\n"+super.toString()+"\nSpecialité :"+specialite;
    }

}
