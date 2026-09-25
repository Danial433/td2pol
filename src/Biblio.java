import java.util.ArrayList;
import java.io.FileOutputStream;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.io.FileWriter;
import org.json.JSONArray;
import org.json.JSONObject;


public class Biblio implements Serializable {
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


    public void sauvergarder(String fichier){
        try {
            FileOutputStream fos = new FileOutputStream (fichier);
            ObjectOutputStream oos = new ObjectOutputStream(fos);


            oos.writeObject(this);

            oos.close();
            fos.close();

            System.out.println("Bibiliotheque sauvergardée");


        } catch (Exception e) {
            System.out.println("Erreur lors de la sauvergarde");
        }

    }

        public Biblio charger(String fichier){
            try {
                FileInputStream fis = new FileInputStream(fichier);
                ObjectInputStream ois = new ObjectInputStream(fis);

                Biblio biblio  = (Biblio) ois.readObject();

                ois.close();
                fis.close();


                System.out.println("Bibliotheque chargée");

                return biblio;


            } catch (Exception e) {
            System.out.println("Erreur lors de la sauvergarde");
            } 

            return null;

        }

        public void sauvergarderJSON(String fichier){
            try{
                JSONObject objetBiblio = new JSONObject();

                objetBiblio.put("nom", nom);

                JSONArray tableauLivres = new JSONArray();

                for(Livre livre : livres) {
                    JSONObject objetLivre = new JSONObject();

                    objetLivre.put("titre",livre.getTitre());
                    objetLivre.put("auteur",livre.getAuteur());
                    objetLivre.put("ISBN",livre.getIsbn());

                    if (livre instanceof Roman) {
                        objetLivre.put("genre","Roman");

                    } else if (livre instanceof BD){
                        objetLivre.put("dessinateur",((BD)livre).getDessinateur());

                    } else if (livre instanceof Journal){
                        objetLivre.put("numeroParution",((Journal)livre).getNumeroParution());
                    }

                    JSONArray tableauExemplaires = new JSONArray();

                    for(Exemplaire exemplaire : livre.getExemplaires()){
                        JSONObject objetExemplaire = new JSONObject();

                        objetExemplaire.put("emplacement", exemplaire.getEmplacement());
                        objetExemplaire.put("etat", exemplaire.getEtat());

                        tableauExemplaires.put(objetExemplaire);

                        objetLivre.put("exemplaires", tableauExemplaires);
                    }

                    tableauLivres.put(objetLivre);

                }

                objetBiblio.put("livres", tableauLivres);

                FileWriter fichierJSON = new FileWriter(fichier);

                fichierJSON.write(objetBiblio.toString());

                fichierJSON.close();

                System.out.println("Bibliotheque sauvegardé en JSON dans biblio.json");

            } catch (Exception e) {
                System.out.println("erreur lors de la sauvergarde");
            }
        }

}
