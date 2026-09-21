import java.io.Serializable;
import java.util.ArrayList;

public abstract class Livre implements Serializable {

    private String titre;
    private String auteur;
    private String isbn;
    private ArrayList<Exemplaire> exemplaires;

    public Livre(String titre, String auteur, String isbn) {
        this.titre = titre;
        this.auteur = auteur;
        this.isbn = isbn;
        this.exemplaires = new ArrayList<>();
    }

    public String getTitre() {
        return titre;
    }

    public String getAuteur() {
        return auteur;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public void setAuteur(String auteur) {
        this.auteur = auteur;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public ArrayList<Exemplaire> getExemplaires() {
        return exemplaires;
    }

    public void ajouterExemplaire(Exemplaire exemplaire) {
        exemplaires.add(exemplaire);
    }

    public void supprimerExemplaire(Exemplaire exemplaire) {
        exemplaires.remove(exemplaire);
    }

    public abstract void afficher();
}