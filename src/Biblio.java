import java.util.ArrayList;
import java.io.FileOutputStream;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

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

    public ArrayList<Livre> getLivres() {
        return livres;
    }

    public void setLivres(ArrayList<Livre> livres){
        this.livres = livres;
    }
    
    public void afficher() {
        System.out.println("Nom de la bibliotheque : " + nom);
        System.out.println("Livres : ");
        for (Livre livre : livres) {
            livre.afficher();
            System.out.println();
        } 
    }

    //this part is for searching, modify and delete functions 


    public Livre rechercherLivre(String isbn){
        for(Livre livre : livres) {
            if (livre.getIsbn().equals(isbn)){
                return livre;
            }
        }

        return null;
    }

    public boolean supprimer(String isbn){
        Livre livre = rechercherLivre(isbn);

        if(livre != null){
            livres.remove(livre);
            return true;
        }

        return false;
    }
    public String modifierLivre(String isbn , String nouveauTitre, String nouvelAuteur){
        Livre livre = rechercherLivre(isbn);

        if(livre != null){
            livre.setTitre(nouveauTitre);
            livre.setAuteur(nouvelAuteur);
            return "Livre modifié avec succès.";
        }

        return "Livre non trouvé.";
    }

    public void chercherLivreParType(Class<?> type) {
        boolean trouve=false;
        System.out.println("Materiel trouvé de ce type: ");
        for (Livre m:livres) {
            if(m.getClass().equals(type)) {
                m.afficher();
                trouve=true;
            }

        }
        if(!trouve) {
            System.out.println(" aucun materiel de ce type...");
        }
    }


}
