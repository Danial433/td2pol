public class Roman extends Livre {
    private String genre;

    public Roman(String titre, String auteur, String isbn, String genre) {
        super(titre, auteur, isbn);
        this.genre = genre;
    }

    public String getGenre() {
        return genre;
    }

    @Override
    public void afficher() {
        System.out.println("Titre : "+getTitre()) ;
        System.out.println("Auteur : "+getAuteur());
        System.out.println("ISBN : "+getIsbn());
        System.out.println("Genre : "+genre);
    }
}
