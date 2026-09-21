public class Journal extends Livre {
    private String numeroParution;

    public Journal(String titre, String auteur, String isbn, String numeroParution) {
        super(titre, auteur, isbn);
        this.numeroParution = numeroParution;
    }

    public String getNumeroParution() {
        return numeroParution;
    }

    @Override
    public void afficher() {
        System.out.println("Titre : "+getTitre()) ;
        System.out.println("Auteur : "+getAuteur());
        System.out.println("ISBN : "+getIsbn());
        System.out.println("Numero Parution : "+numeroParution);
    }
}

