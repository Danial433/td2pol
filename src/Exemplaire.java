mport java.io.Serializable;

public class Exemplaire implements Serializable {

    private String emplacement;
    private String etat;

    public Exemplaire(String emplacement, String etat) {
        this.emplacement = emplacement;
        this.etat = etat;
    }

    public String getEmplacement() {
        return emplacement;
    }

    public String getEtat() {
        return etat;
    }

    public void setEmplacement(String emplacement) {
        this.emplacement = emplacement;
    }

    public void setEtat(String etat) {
        this.etat = etat;
    }

    public void afficher() {
        System.out.println("Emplacement : " + emplacement);
        System.out.println("Etat : " + etat);
    }

    public void preter() {
        if (etat.equals("disponible")) {
            etat = "prêté";
        }
    }

    public void rendre() {
        etat = "disponible";
    }
}