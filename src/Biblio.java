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


}
