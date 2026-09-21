import java.util.ArrayList;
import java.io.Serializable;


public abstract class Livre {
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

    public String getTitre(){
        return titre;
    }

    public void setTitre(String titre){
        this.titre = titre;
    
    }

    public String getAuteur(){
        return auteur;

    }

    public void setAuteur(String auteur){
        this.auteur = auteur;

    }

    public String getIsbn(){
        return isbn;
    }

    public void setIsbn(String isbn){
        this.isbn = isbn;
    }

    public Arraylist<Exemplaire> getExemplaire {
             getExemplaires(){
                return exemplaires;
             }
    }

    public void setExemplaires(ArrayList< Exemplaire> exempalaires){
        this.exemplaires = exemplaires;
    }

    public void ajouterexEmplaire(Exemplaire exemplaire){
        exemplaires.remove(exemplaire);
    }

    public void supprimerExemplaire(Exemplaire exemplaire){
        exemplaires.remove(exemplaire);
    }


    public abstract void afficher();

}
