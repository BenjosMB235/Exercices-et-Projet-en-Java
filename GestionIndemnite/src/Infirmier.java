package gestion_indemnite;

public class Infirmier extends Personnel {
    protected int comptInf=0;
    private String diplome;
    private int anciennete;

    public Infirmier(String diplome, int anciennete, String cnie, String nom) {
        super(cnie, nom);
        this.diplome=diplome;
        this.anciennete=anciennete;
    }

    public String getDiplome() {

        return diplome;
    }

    public int getAnciennete() {

        return anciennete;
    }

    public float indemnite(){
        if (anciennete<10){
            return getNbreHeureSuppl()*45;
        }else{
            return getNbreHeureSuppl()*75;
        }
    }
    public String toString(){
        return "Les informations de l'infirmier(ière) :\n"+super.toString()+"\nAnciennete :"+anciennete+"\nDiplome : "+diplome;
    }
}
