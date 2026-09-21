import java.util.ArrayList;
public class Biblio {
    public String nom;
    public ArrayList<Livre>livres;
    
    public Biblio(String nom) {
        this.nom = nom;
        livres = new ArrayList<>();
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
    public void afficherLivres(){
        System.out.print("Livres dans la bibliotheque " + livres);
    }
    public 
}
