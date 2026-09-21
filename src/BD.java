public class BD extends Livre {
    private String dessinateur;

    public BD (String titre, String auteur, String isbn, String dessinateur) {
        super(titre, auteur, isbn);
        this.dessinateur = dessinateur;
    }

    public String getDessinateur() {
        return dessinateur;
    }

    @Override
    public void afficher() {
        System.out.println("Titre : "+getTitre()) ;
        System.out.println("Auteur : "+getAuteur());
        System.out.println("ISBN : "+getIsbn());
        System.out.println("Dessinateur : "+dessinateur);
    }
}

