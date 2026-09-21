public class Journal extends Livre {
    private String numeroParution;

    public Roman(String titre, String auteur, String isbn, String numeroParution) {
        super(titre, auteur, isbn);
        this.numeroParution = numeroParution;
    }

    public String getNumeroParution() {
        return numeroParution;
    }

    @Override
    public void afficher() {
        super.afficher();
        System.out.println("Numero Parution : "+numeroParution);
    }
}

