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
        super.afficher();
        System.out.println("Genre : "+genre);
    }
}
