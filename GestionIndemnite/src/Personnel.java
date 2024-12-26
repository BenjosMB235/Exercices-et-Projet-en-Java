package gestion_indemnite;

public abstract class Personnel {
    private String cnie;
    private String nom;
    private float nbreHeureSuppl=-1;

    public Personnel(String cnie, String nom) {
        this.cnie=cnie;
        this.nom=nom;
    }
    public float getNbreHeureSuppl() {

        return nbreHeureSuppl;
    }
    public void setNbreHeureSuppl(float nbreHeureSuppl) {

        this.nbreHeureSuppl = nbreHeureSuppl;
    }

    public String getCnie() {

        return cnie;
    }
    public String getNom() {

        return nom;
    }
    public abstract float indemnite();

    public String toString(){

        return "CNIE :"+cnie+"\nNom :"+nom;
    }

}
