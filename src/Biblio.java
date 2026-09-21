import java.util.ArrayList;
public class Biblio {
    public String nom;
    public ArrayList<Livre>livres;
    
    public Biblio(String nom) {
        this.nom = nom;
        this.livres = new ArrayList<>();
    }
    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void ajouteLivre(Livre nom){
        livres.add(nom);
    }
    
    public void afficher() {
        System.out.println("Nom de la bibliotheque : " + nom);
        System.out.println("Livres : ");
        for (Livre livre : livres) {
            livre.afficher();
            System.out.println();
        }
    }
    
}
